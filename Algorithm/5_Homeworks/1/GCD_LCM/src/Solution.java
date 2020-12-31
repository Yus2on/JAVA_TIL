/**
 *
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * 제한 사항
 * 두 수는 1이상 1000000이하의 자연수입니다.
 *
 */

class Solution {
    public int[] solution(int n, int m) {
        int [] answer = new int [2]; // 배열의 길이 2로 지정

        // 입력받은 n, m 비교해서 작은 걸 small, 큰 걸 big에 저장
        int small = Math.min(n, m);
        int big = Math.max(n, m);

        // 최대공약수 큰 수 % 작은 수가 0이 될때까지 반복
        while (big % small != 0) {
            // 기존 큰 수 % 작은 수를 tmp 에 저장
            int tmp = big % small;
            // 작은 수를 큰 수에 저장
            big = small;
            // tmp를 작은 수에 저장
            small = tmp;
        } // end while

        // big % small == 0 일 때 -> small 이 두 수의 최대공약수
        // 최소공배수는 (두 수의 곱) / 최대공약수
        answer[0] = small;
        answer[1] = (n * m ) / small;

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, 12));
    }
}
