## TIL (Today I Learned)

--------------

#### 다차원 배열

- 배열을 담고 있는 공간(배열이 배열을 담고 있음)
- 수학의 점 -> 선 -> 면 -> 공간 -> 4차원 -> 5차원 개념과 동일

#### 다차원 배열의 선언

```java
int [][] ints;
int[] array2D[];
int[][] array2D;
int array2D[][];

/**** 좋지 않은 선언 방법*****/
// [] array1 [];
// oldCstyle[][];
```

#### 다차원 배열의 생성과 초기화

- 여러 차원의 배열을 동시 생성

```` java
int[][] array2D = new int[5][10];
// 길이가 5인 array를 담고 있는 길이가 10인 array
````

- 상위 차원의 배열부터 생성

```` java
int[][] array2D = new int[5][];
for (int i = 0; i < array2D.length; i++) {
  array2D[i] = new int[10];
}

// 하위 차원의 길이는 달라 질 수 있음
// 다차원 배열ㅇ느 길이가 다른 배열도 들어갈 수 있음
int [][] ints3 = new int[5][];
ints3[0] = new int[10];
ints3[1] = new int[8];
ints3[2] = new int[4];
ints3[3] = new int[15];
ints3[4] = new int[9];
````

- 다차원 배열의 초기화

```` java
int[][] array2D = {{3, 5, 1, 20, 65},
                   {5, 2, 6}, // length may vary
                   {10, 3, 5, 67, 3}};

int [][] ints4 = {{1, 2, 3}, {4, 5, 6}}; // int [2][3] 으로 표기 가능. 길이가 3인 배열이 두개 존재
int [][] ints5 = {{1, 2, 3}, {7, 8 }, {4, 5, 6}}; // int [3][] 으로 표기 가능
for(int i = 0; i < ints5.length; i ++){ // length : 3 상위 배열
  // System.out.printf("[%d] : ", ints5[i].length  ); // 길이 변화 확인용
  for(int j = 0; j < ints5[i].length; j ++) { // 하위배열
    System.out.printf("%d ", ints5[i][j]);
  }
  System.out.println("");
} // end for
````

#### 배열과 반복문

- 인덱스를 이용한 접근

```` java
int[][] array2D = new int[10][10];
for (int i = 0; i < array2D.length; i++) {
  for (int j = 0; j < array2D[i].length; j++) {
    array2D[i][j] = i * j;
  }
}
````

#### Practice

```` java
int [][] matA = {{1, 2, 3}, {4, 5, 6}}; // 2x3
int [][] matB = {{7, 8, 9}, {6, 5, 4}}; // 2x3

int [][] A2 = new int [matA.length][matA[0].length]; 
// 직접 2, 3 으로 지정할 수 있지만 A행렬과 똑같이 만들기위해 A행렬 변수로 지정

for (int i = 0; i < matA.length; i ++){
  for(int j = 0; j < matA[i].length; j ++){
    A2[i][j] = matA[i][j] + matB[i][j];
  }

  
//향상된 for문//
for(int [] row: A2){
  for(int elem : row){
    System.out.printf("%d ", elem);
  }
  System.out.println("");
}
////
````



