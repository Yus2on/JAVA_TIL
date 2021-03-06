# 배열 (Arrays)

## 배열이란

- 다루는 자료의 수가 많아질 때, 이를 다루기 위해 사용하는 **자료 구조**
- 하나의 변수에 여러 자료를 저장할 수 있으며, 반복문을 이용해 효율적으로 처리 가능
- 배열에서 인덱스는 유일무이한 식별자(Identifier)로 사용된다.

## 배열의 특징

- 크기(Element의 개수)가 정해져 있다.
- 자료 구조에 기능(메소드)이 포함되어 있지 않다.
- 자료가 메모리상에 빈틈 없이 연속적으로 위치해 있다.
- 인덱스를 활용하여 자료에 빠르게 접근할 수 있다.

## 배열의 단점

- 배열의 길이는 생성 시 정해져, 변경할 수 없다.
  - 가변 길이 배열은 배열의 크기를 변경할 때 마다 새 배열을 만든다.
- Element를 제거할 경우, 배열에 빈 틈이 생긴다.
  - 기존 Element의 인덱스를 유지하기 위해 빈 틈을 유지한다.

## 배열의 활용

- 배열의 생성 [![배열의 생성](https://github.com/ai-creatv/algorithm_jbd1/raw/master/3_DataStructures/3_2_Array/img/1.png)](https://github.com/ai-creatv/algorithm_jbd1/blob/master/3_DataStructures/3_2_Array/img/1.png)
- 자료의 삽입 [![자료의 삽입](https://github.com/ai-creatv/algorithm_jbd1/raw/master/3_DataStructures/3_2_Array/img/2.png)](https://github.com/ai-creatv/algorithm_jbd1/blob/master/3_DataStructures/3_2_Array/img/2.png)
- 자료의 삭제 [![자료의 삭제](https://github.com/ai-creatv/algorithm_jbd1/raw/master/3_DataStructures/3_2_Array/img/3.png)](https://github.com/ai-creatv/algorithm_jbd1/blob/master/3_DataStructures/3_2_Array/img/3.png)
- 자료의 색인 [![자료의 색인](https://github.com/ai-creatv/algorithm_jbd1/raw/master/3_DataStructures/3_2_Array/img/4.png)](https://github.com/ai-creatv/algorithm_jbd1/blob/master/3_DataStructures/3_2_Array/img/4.png)

## Java과 배열

- Java에는 배열 자료구조가 있어, 저수준 동작을 구현할 수 있음

  - 다양한 종류의 배열 생성

    ```
    int[] intArray = {1, 4, 52, 12, 95};
    float[] floatArray = {4.2f, 5.55f, 2.459f};
    String[] stringArray = {"자바", "will", "네버", "die"};
    int[][] int2DArray = {{1, 2}, {3, 4}, {5, 6}};
    ```

  - 배열은 특정 형식의 Element만을 허용한다.

  - 배열은 자료가 메모리에 연속적으로 배치되는 것을 보장한다.

<details class="details-reset details-overlay details-overlay-dark" id="jumpto-line-details-dialog" style="box-sizing: border-box; display: block;"><summary data-hotkey="l" aria-label="Jump to line" role="button" style="box-sizing: border-box; display: list-item; cursor: pointer; list-style: none;"></summary></details>