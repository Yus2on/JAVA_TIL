package p03;

/**
 * 좋은 테스트의 조건 - FIRST
 *
 * Fast
 * Isolated
 * Repeatable
 * Self-validating
 * Timely
 *
 * - Fast: 빠른
 *  - 전형적인 자바 시스템의 테스트 케이스는 수천 단위
 *  - 평균 200ms 가 걸리는 경우, 5000개를 수행하는 데에 16분 소요
 *      - 우리가 코드를 1번 수정할 때 마다 16분의 테스트를 수행해야 함
 *      - 메소드에 테스트용 우회 코드를 넣거나, Stub 객체를 활용
 *
 * - Isolated: 고립된
 *  - 테스트는 기본적으로 순서와 시간에 영향을 받지 않아야 함
 *  - 고립되지 않은 테스트는 실패했을 때 원인을 찾기 어려움 ( 고립된 테스트는 그 테스트 케이스 내에서 문제를 찾으면 됨)
 *
 * - Repeatable: 반복 가능한
 *  - 테스트를 반복했을 때 그 결과는 같아야 함
 *  - 테스트 코드 내용만으로 그 내용을 설명할 수 있어야 함
 *      - 외부 환경에 영향을 받지 않아야 함
 *
 * - Self-validating: 스스로 검증 가능한
 *  - 테스트는 반드시 기대하는 바를 단언해야 한다.
 *      - ex) main 메소드에서 이걱저것 프린트해보고 동작시키기
 *  - 테스트는 스스로 검증하며, 테스트를 준비하는 것도 스스로 한다.
 *  - Continuous Integration (CI) 도구를 활용하기 위해 이것이 꼭 이루어져야 함
 *      - 코드가 통합될 때마다 자동으로 모든 테스트를 수행하고, 상태를 점거하는 프레임워크를 CI 도구라고 함
 *
 * - Timely: 적시의, 제 때
 *  - 변화하는 코드는 테스트 코드를 항상, 꾸준히 작성해야 한다 ( 변화하지 않는 코드는 테스트를 작성할 필요성이 떨어짐)
 *  - 리뷰 시스템을 통해서, 혹은 CI 도구를 이용해서 테스트 코드 작성을 강제하기도 함
 *      -> Peer Pressure: 동료에게 테스트 코드가 없음을 알림 - 스스로 압박
 *  - 큰 결함 없이 기존의 잘 동작하는(변경 예정이 없는) 코드 보다는,
 *    말썽을 일으키고, 계속해서 변하고 있는 동적ㅇ니 코드에 대한 테스트를 먼저 작성
 *
 *
 */



public class First {
}
