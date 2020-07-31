## TIL (Today I Learned)

-----

## 배열 (Array)

- 하나의 변수로 여러 개의 값을 다룰 수 있다.
- 동일 자료형만 다룰 수 있다.
- 한번 생성한 배열의 크기는 변하지 않는다.
- 배열에 속한 값은 메모리에 연속으로 위치한다.



**배열의 선언**

```` java
int[] intArray;// 자료형[] 변수명; recommended
long [] longs;
char [] chars;
String [] strings;
// 데이터 타입에 상관없이 배열 선언이 가능

/* 좋지 않은 선언 방법*/
int integerArray[];// 자료형 변수명[]; old c-style 
````

**배열 생성과 초기화**

- 생성 후 값 할당

```` java
integers = new int[10]; // 생성
int [] integers2 = new int[10]; // 생성 후 값 할당
integers2[0] = 5;
integers2[1] = 10;
integers2[3] = 9;
// 값을 넣을 때 순차적으로 하지 않아도 된다.

System.out.println(integers2[2]); 
// [2]의 값을 선언하지 않아도 0으로 자동 초기화
// 다른 언어는 가능하지 않을 수 있음

int [] integers3; // 생성
int [] integers3 = new int[]{5, 2, 3, 6, 12, 4}; // 생성 후 값 할당 -> 길이 입력 안해도 된다.
// System.out.println(integers3[6]); // ArrayIndexOufOfBoundsException 오류 발생

````

 - 생성과 동시에 값 할당

```` java
// new int[]를 빼도 초기화 가능
int[] intArray = {3, 5, 1, 20, 65};
int[] intArray2 = new int[]{4, 6, 2, 3, 4};
````



#### 반복문을 이용한 초기화

```` java
// 배열을 반복문으로 접근 // 인덱스 이용
float [] floats = new float[5];
for (int i = 0; i < floats.length; i++) { // for문을 이용한 초기화
  floats[i] = (float)(i * 0.25);
}

for (int i = 0; i < floats.length; i++) { // for문을 이용한 출력
  System.out.println(floats[i]);
}


for (int i = 0; i < floats.length; i++) {
  float floatVal = floats[i];
  System.out.println(floatVal);
}

/****************************************************/
// 향상된 for문을 이용한 접근
// Enhanced for, for each 문 --> 위와 같은 것!
// float타입의 floatVal라는 변수를 생성해서 floats array의 0번째 값부터 순서대로 대입해줌
for (float floatVal: floats) {
  System.out.println(floatVal); 
  // res :  floatVal[0], floatVal[1], floatVal[2] .......
}
/****************************************************/
````

#### 배열의 크기 변경

- 배열의 크기를 변경할 수 없으므로 새로운 배열을 만들어 데이터를 옮겨야 한다.

```` java
// 배열의 크기를 변경(확장)
// case1
int [] src = {1, 2, 3, 4, 5};
int [] dst = new int[10];
for (int i = 0; i < src.length; i++) {
  dst[i] = src[i];
}

for (int integer: dst) {
  System.out.println(integer);
}


// case2
int [] src2 = { 1, 2, 3, 4, 5};
int [] dst2 = new int[10]; // 복사할 소스를 넣을 배열

//배열 크기 변경을 위해 arraycopy : 가져올 배열( 복사해올소스 , 몇번인덱스부터 가져올것인지, 몇개나 복사할 것인지)
System.arraycopy(src2, 0, dst2, 0, src2.length);
//전체를 다 가져오기 위해서 length. 3개만 가져오고 싶으면 length : 3

for(int interger: dst2){
  System.out.println(interger);
}//end for
````

#### Practice

- 배열에서 최대값 찾기

```` java
int [] integers = {4, 2, 12, 23, 62, 9, -2, 0, 1, -4};
int max = integers[0]; //첫번째 값으로 초기화

//Q1 - case 1
for(int i = 0; i<integers.length; i ++){
  if (max < integers[i]) { // max보다 크면 대체하는 로직
    max = integers[i];
  }
} //end for
System.out.println(max);



//Q1 - case2
for(int val : integers){
  max = max > val ? max : val;
}
System.out.println(max);
````

- 배열에서 두번째로 큰 값 찾기

```` java
int [] integers = {4, 2, 12, 23, 62, 9, -2, 0, 1, -4};
max = integers[0]; // 배열의 첫번째 값
int max2 = integers[1]; // 배열의 두번째 값 -> 두번째로 큰 수를 담을 예정

for(int i = 0; i<integers.length; i ++){
  if (max < integers[i]) { // max보다 크면 대체하는 로직. max보다 배열의 값이 크다면 타는 로직
    max2 = max; // max2를 max값으로 업데이트해줌 ..
    max = integers[i]; // max에 가장 큰 값을 계속 넣어줌

  }else if (max2 > integers[i] ){ // max2는 배열의 두번째 값
    max2 = integers[i];
  }
}



//Q2 - case2 max 2 == maxVal
int [] maxVal = new int[2];
// 없어도 작동은 함 
//maxVal[0] = integers[0] > integers[1] ? integers[0] : integers[1];
//maxVal[1] = integers[0] < integers[1] ? integers[0] : integers[1];
for(int val: integers){
  if(maxVal[0] < val){
    maxVal[1] = maxVal[0];
    maxVal[0] = val;
  }else if(maxVal[1] < val){
    maxVal[1] = val;
  }
}
System.out.println(maxVal[1]);
````

