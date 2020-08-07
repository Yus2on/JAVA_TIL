## Shell

## gitbash

>  gitforwindows.org -> git bash(window)



 # shell command Basic

- $, % .... : 사용자 입력을 받을 준비가 되었단 의미
- ~ : home directory

```shell
$ cd documents

$ mkdir dev # - make directory dev
$ cd dev # - change directory
$ cd .. # - go up
$ pwd # - print working directory 

$ ls
$ ls -al # 숨김 파일 보기

$ touch hello.py # - touch : create hello.py
$ exit # - terminate shell

$ mv index.html bin/ # - mv:move -> index.html을 bin으로 옮기기
$ mv index.html uses.html # - rename 도 가능 
$ mv users.html users.java # - 확장자도 변경 가능하지만 파일 인코딩 문제가 생김
$ cp index.html .. 

$ rm README.txt # 파일 삭제
$ rm *.java # * -> 애스터리스크. 모든 java 파일 삭제

$ rm -r bin # bin 안에 있는 모든 파일을 삭제한 후 bin 디렉토리도 삭제
# $ sudo rm -rf # -rf : 강제삭제 

```



## chmod

> 파일 권한 설정할 때 사용

`drwxr-xr-x`

-  `d` or `-`: directory or file (user)(group)(other)
-  `r`: read  `w`: write  `x`: execute  `-`: no permission

```` shell
$ chmod 777 index.html # chmod [옵션] (8진수) (파일명)
#0:000 1:001 2:010 3:011 4:100 5:101 6:110 7:111

````



## vim

```` shell
$vim readme.txt # vim (파일명)
````

- vim 에는 크게 3가지 모드가 존재

  - normal mode
  - insert mode : `normal mode 에서 i 입력 시 insert` . insert mode에서 normal mode로 돌아가려면 `esc`
  - visual mode

- > h, j, k, l : 방향키 
  >
  > 0 : 문장의 맨 앞으로 이동
  >
  > shift + a : 문장의 맨 끝
  >
  > shitf + o : 커서가 있는 문장의 위에 새로 라인을 추가할 수 있다 
  >
  > o : 커서가 있는 문장의 아래에 새로 라인을 추가 할 수 있다 
  >
  > v : 커서를 위치시킨 상태에서 v를 누르면 비주얼 모드.
  >
  > y - yank :  복사 (비주얼 모드, 노멀모드에서 가능. 노멀 모드에서 문장 앞에shift _ y 를 하면 블록 없이 문장 전체 복사)
  >
  > p - paste : 붙여넣기
  >
  > u -undo : 되돌리기
  >
  > dd : 잘라내기/삭제  (노멀모드. 비주얼 모드에선 블록설정 + d)
  >
  > x : 문자 하나씩 삭제 (dd는 문장을 삭제함 )
  >
  > 저장 또는 나기기 : 노멀모드에서 esc -> : (콜론) -> w(write) -> q(quit)
  >
  > - q! : 저장하지 않고 나가기
  > - wq : 저장하고 나가기
  >
  > cat : 저장을 확인

  