package p01;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio (New Input Output)
 * nonblocking-io 가 아님
 *
 * io stream : 입력 노드 / 출력 노드가 구분
 * nio channel : 입/출력 모두 처리 가능
 *
 * - 채널을 이용해서 입/출력을 모두 처리 (동시에는 안됨)
 * - 기본적으로 버퍼를 사용
 * - nio는 non-blocking 을 지원 (= 비동기식)
 *  - 읽고/쓰기를 시켜놓고 다른 작업 진행 가능 (= 멀티 스레드)
 *
 *
 */



public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // path 표현 방식 1
        Path path = Paths.get("1.txt");

        // 방식 2
        Path path1 = Paths.get("User", "name", "1. txt");

        // 방식 3
        // file -> 로컬에 접근 가능한 프로토콜 중 하나.
        // file을 사용하는 순간 네트워크에서 사용할 순 없음.
        Path path2 = Paths.get(new URI("file:///Users/username/1.txt"));

        // Paths -> get  정적 메소드
        // Files -> createFile, createDirectory, copy, delete, move 정적 메소드


        // Buffer : Direct buffer, non-direct buffer
        // direct buffer : OS에 buffer로 쓰겠다고 직접 요청 -> OS로 부터  Stack 메모리를 가져옴. 사용 가능한 크기가 큼 (JVM 제한이 없음)
        //                             -> 생성 속도가 느림 (= OS와 통신 필요하기 때문)
        //                             -> 입출력 성능이 좋음 (= 입/출력 속도가 빠름)
        //                             -> ByteBuffer 만 생성 가능, nio는 ByteBuffer 사용
        // non-direct buffer : OS 까지 가지 않고 JVM 에 있는 heap 메모리를 사용
        //                     -> 사용 가능한 메모리 작은편 (= JVM에 의해 제한)
        //                     -> 생성속도가 빠름 (JVM상에서 곧바로 사용)
        //                     -> 입출력 성능은 direct buffer 에 비해 떨어짐 ( 많이, 자주 사용할거면 direct buffer 사용 )

        ByteBuffer buff = ByteBuffer.allocateDirect(1024); // Direct buffer
        ByteBuffer buff1 = ByteBuffer.allocate(1024); // Non-direct buffer

        CharBuffer cBuff = CharBuffer.allocate(1024); // Non-Direct buffer 만 있다
        IntBuffer iBuff = IntBuffer.allocate(1024);
        // ByteBuffer 외 다른 버퍼는 allocateDirect 없음

        // bytebuffer를 쉽게 변환 가능
        DoubleBuffer dBuff = buff.asDoubleBuffer(); // OS에 처리하는것 -> byte 기준이기 때문에 수동으로 바꿔야 함

        Path src = Paths.get("1.txt");
        Path dst = Paths.get("2.txt");

        try (FileChannel channel1 = FileChannel.open(src,
                StandardOpenOption.READ);
             FileChannel channel2 = FileChannel.open(dst,
                     StandardOpenOption.WRITE,
                     StandardOpenOption.CREATE )
        ) {
            //with resourece로 하는게 좋음 create 하면 새로만듬 create_new는 없으니 새로만든다는 의미 파일이 기존에 있으면 에러남

            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate((int) channel1.size());
            // channel1 을 한번에 읽을수 있는 buffer 생성
            // allocate -> allocateDirect(보통사용함)
            // 버퍼 크기를 변경하여 최적화 가능. 버퍼크기가 너무 크면 느려진다. 적절한게 좋음.

            read = channel1.read(readBuffer); // 버퍼를 읽어줌

            if (read == -1) { // 읽은게 하나도 없다면
                throw new IOException();
            }

            readBuffer.flip();
            channel2.write(readBuffer); // 이러면 써준 것
            readBuffer.clear();

            /**
             * buffer 사용법
             * capacity, limit, position, mark
             * 0 <= mark <= position <= limit <= capacity
             * capacity는 Buffer 전체를 뜻한다
             * 한번 읽을 때마다 포지션이 증가함
             * Read에 의해서 bytes5개 써졌을 때 6번째에 position 이 limit으로 어디까지 읽었는지(사용이 되었는지) 표기하는것이 표시해두는곳
             *  - read()하면 포지션은 0 로되고 limit은 capacity랑 같은 사이즈가 되서 원래 사용하지 않은것처럼 돌아간다.
             *  -  channel2.write(readBuffer) : 그래서 포지션 0부터 limit까지 쓰게 된다.
             * 특정 위치 이후에는 쓰레기 값이 있을 수 있는데 그걸방지하기 위해 LIMIT이 있는 것
             * flip = limit을 하고 posiont 이 맨앞으로 간 것
             * flip 현재 포지션을 limit으로 세팅하고 포지션을 0으로 돌리는 역할을 함. 읽은 포지션을 limit으로 기억함.
             *  - (어느 부분까지 적혀있는지, 사이즈를 말하는 듯)
             * buffer에 크기 상관없이 읽힌 만큼만 옮기게된다
             * clear 하면 position 은 앞으로 오고 limit은 capacity 로 간다
             * 그럼 해당 buffer 를 쓴적이 없는 상태가 된다
             *
             */

        } catch (IOException e) {
            e.printStackTrace();
        }


        // 버퍼가 작은 경우
        src = Paths.get("1.txt");
        dst = Paths.get("3.txt");

        try(FileChannel channel1 = FileChannel.open(src,
                StandardOpenOption.READ);
            FileChannel channel2 = FileChannel.open(dst,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE)
        ) {
            //with resourece로 하는게 좋음 create 하면 새로만듬 create_new는 없으니 새로만든다는 의미 파일이 기존에 있으면 에러남
            int read = -1;
            ByteBuffer readBuffer =
                    ByteBuffer.allocate(8); // channel1 을 한번에 읽을수 있는 buffer 만듦

            // 채널에서 읽어올때  순서대로 읽어올수 있게 기억하고 있음 readbuffer크기만큼 가져오고 나머지는 대기하고있음
            // 이어서 다시 읽기 가능
            while ((read = channel1.read(readBuffer)) != -1){
                readBuffer.flip(); // 채워진 곳에 limit 거릴고 position 0
                channel2.write(readBuffer); // 현재 읽은 곳을 write
                readBuffer.clear(); // 버퍼 다시 쓸 수 있게 초기화
            }
            // allocate -> allocateDirect // 보통 allocateDirect 사용 (allocate로 차이나는 정도는 너무 작은 경우 )
            // 버퍼 크기를 변경, 너무 크면 또 오버헤드 발생
            // 너무작으면 또 왔다갔다 하는 경우 많아짐 -> 적절해야된다

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
