/**
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
 * 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 * 예를 들어 s가 `pPoooyY`면 true를 return하고 `Pyy`라면 false를 return합니다.
 */

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // 문자열 내에서 p와 y가 있을 때마다 카운트 할 변수
        int pCnt = 0, yCnt = 0;

        for(int i = 0; i < s.length(); i++) {
            // 문자열 s에서 i 번째 문자가 'p' || 'P' 일 때 pCnt를 1 증가
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pCnt ++;

            // 문자열 s에서 i 번째 문자가 'y' || 'Y' 일 때 yCnt를 1 증가
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yCnt ++;
            }
        } // end for

        // 문자열에서 문자 p, y 가 하나도 없었다면 true 반환
        if(pCnt == 0 && yCnt == 0) {
            return true;
        }

        // 문자열에서 문자 p, y의 수가 같다면 true, 아니면 false 반환
        return (pCnt == yCnt) ? true : false;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("Pyy"));
    }
}



