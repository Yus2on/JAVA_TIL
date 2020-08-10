# TIL

### 생성자 (Constructor)

- 클래스에서 인스턴스를 생성할 때 사용되는 메소드
  - `new` 키워드를 사용해 호출
- 기본 생성자 (Default Constructor)
  - 구현하지 않아도 자동으로 생성되는 생성자
  - 아무런 동작도 하지 않고, 객체만을 생성
- 파라미터 생성자 (Parameter Constructors)
  - 입력 파라미터를 받는 생성자
  - 여러개의 파라미터 생성자를 오버로딩 할 수 있음
  - 보통 멤버 변수를 초기화하는 동작 수행



### 기본 생성자

```` java
public class Constructor {
  int x;
  int y;
  String z; //  3개 다 인스턴스 변수

  // public Constructor() {} 기본 생성자, 구현하지 않아도 알아서 생긴다.(생략가능)
  public Constructor() {
//    x = 1;
//    y = 20;
//    z = "초기화";
    this(0, 0, "디폴트 constructor");
  }
  
  // private Constructor(){} // 생성자 중에 외부에서 사용할 수 없는 것.. 외부에서 호출이 불가능한 생성자이다


  // 실행부
  class ConstructorTest {
    public static void main(String[] args) {
      Constructor c = new Constructor(); // 기본 생성자 호출
      //System.out.println(c.x+","+c.y+","+c.z);//0,0,null //기본생성자
      // z의 경우, 클래스이기 때문에 null로 초기화 됨
      // null -> 아무것도 참조하고 있지 않다. // 참조형 변수의 경우 null로 초기화
     
      System.out.println(c.x + "," + c.y + "," + c.z);//1,2,초기화//생성자 수정 이후


````

> - 기본 생성자는 입력 인자와 실행문이 비어있는 생성자로 생략 시 자동으로 구현된다 
> - 기본 생성자로 인스턴스를 생성하면 멤버 변수의 값은 int = 0, Stirng = null 로 초기화 (null은 아무것도 참조하지 않고 있다는 뜻)
> - 기본 생성자에 각 변수 별 초기화 값을 실행문에 넣어주면 인스턴스 생성시 해당값으로 각 변수가 초기화 함



### 파라미터 생성자

```java
// 파라미터 생성자
public Constructor(int x, int y, String z) {
  this.x = x; // this는 멤버 변수를 표기하기 위해 사용될 수 있다.
  this.y = y;
  this.z = z;
}

// 생성자는 클래스이름, return이 없기에 return type적지 않음
// 기본 생성자의 오버로딩
public Constructor(int a, int b) {
  this(a, b, "");  // 이전 생성자를 불러오는 this. 
  // 자바에서 this.는 무조건 첫줄에 사용 해야 함.
  // 코드 중복을 최소화 하기 위해 사용함
  // 가장 긴 파라미터를 기준으로 짧은것을 this로 불러올 수 있다.
}

// 실행부 
class ConstructorTest{
    public static void main(String[] args) {
      Constructor c1 = new Constructor(10, 20, "파라미터생성자");
			System.out.println(c1.x + "," + c1.y + "," + c1.z); // 10,20,파라미터생성자

			Constructor c2 = new Constructor(10, 20);
			System.out.println(c2.x + "," + c2.y + "," + c2.z); //10,20,
    }
}

```

> - 파라미터 생성자는 입력 인자를 입력 받는 메서드로 기본 생성자를 오버로딩 하여 만든 메서드
> - 필요에 따라 다양한 파라미터를 조합하여 생성자를 만들어서 사용함
> - 파라미터 생성자를 생성하면 생략되어 있는 생성자는 사용 못함 => 필요하면 기본생성자





## Getter, Setter

- 클래스의 멤버 변수를 간접적으로 다룰 수 있게 해 주는 메소드
- 멤버 변수의 캡슐화(Encapsulation)에 도움이 됨 -> 정보의 은닉/보호
- 멤버 변수의 값을 제한 해야 할 때 유용

```java
public class GetterSetter {
    int x,y;
    String z;
    float w; // code - generate - GetterSetter

    //constructor도 Generate를 통해 만들 수 있다.
    //constructor 만들면 기본 생성자가 사라짐.
    //만약 둘다 필요하다면 기본생성자를 작성해주면됨
    public GetterSetter(){};
    public GetterSetter(int x, int y, String z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public int getX() { // 경우에 따라 구현하지 않을 수 있음 
        return x;
    }

    public void setX(int x) {
      // x의 조건이 있는 경우라면 Ex. 환자ID( 1 ~ 1000)
        if(x>0 && x <= 1000){
            this.x=x;
        }else{
            System.out.println("x should be 1<= x <=1000");
            System.out.println("however, you put in x =" +x);
        }

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}

class GetterSetterTest {
    public static void main(String[] args) {
        GetterSetter g = new GetterSetter();
        g.x = 10; // => 직접 값을 넣어주는 것은 권장되지 않는 멤버식 변수 처리 방법 
        System.out.println(g.x);
      
        g.setX(20);
        System.out.println(g.getX()); 
      
        g.x = 20; // 권장되지 않은 접근
        g.setX(1111111111);
        //System.out.println(g.getX());
    }
}
```

- 필요한 변수를 선언한 후 Menu -Code - Generate - Getter, Setter를 선택하여 만들 수 있음
- 참고로 Constructor도 같은 방법으로 사용 가능. 기본 생성자도 같이 사용하고 싶을 땐 기본생성자를 오버로딩
- get()메서드는 해당 변수를 불러 오는 메서드이고 set함수는 해당 변수의 값을 수정할 때사용하는 메서드
- 사용자에게 멤버 변수에 접근을 제한적으로 설정 할 때 사용할 수 있음(값을 수정할수 없거나 불러올 수 없거나)
- 나중에 배울 private 멤버 변수와 함게 사용 됨





## 초기화 블록 (Initializer)

- 클래스 또는 인스턴스를 생성할 때 단 한번 실행되는 코드 블록

```java
public class Main {
  static int classVar;
  static int instancecount;
  int instanceVar;

  // static initializer
  // 정적 초기화 블록
  static {
    System.out.println(" static block1 ");
    classVar = 20; // class variable에만 접근 가능, 객체생성 이전
  }

  // 객체를 초기화 하는 object initializer
  {
    System.out.println(" block1 ");
    instanceVar = 30; // 객체 생성이후이기 때문에 instanceVar에 접근가능
    classVar = 50;		// 추천되지 않는다. 객체생성이 스태틱에 영향. 객체를 생성하는데 클래스에 관한 것이 변하면 X
    instancecount++;  //예외적으로 전체적으로 관리해주어야 할 항목은 넣을 수 있음.
  }

  static{ //2번째 staticinitialze는 첫번째 이후에 바로 실행. 여러개 있을 수 있음
    System.out.println(" static block 2");
    classVar = 5;
  }

  { // 2번째 object도 마찬가지.. 결국은 동일한 중괄호 안에 있는것과 다르지 않다.
    instanceVar =5;
    System.out.println(" block2 ");

  }
}

class MainTest{
  public static void main(String[] args) {
    //static block 실행(만들어지면서 실행바로됨)
    System.out.println((Main.classVar));	// 20  static block에서 초기화됨
    //instance 생성시 initializer 실행
    Main main = new Main();
    System.out.println(Main.instancecount);
    System.out.println(main.instanceVar);	//30 object initialize에서 초기화됨
    System.out.println(Main.classVar);		//20

    Main main2 = new Main();
    System.out.println(Main.instancecount); // block1
    																				// block2
    																				//2

    Main main3 = new Main();                
    System.out.println(Main.instancecount);	// block1
    																				// block2
    																				//3
  }
}
```

> - static initializer는 클래스가 생성 될 때 실행 -> 보통은 클래스를 import할 때 클래스가 생성 
> - 객체 생성 이전에 생성되기 때문에 Static variable에만 접근 가능
> - object initializer는 인스턴스가 생성 될 때 실행되는 코드
> - 보통은 instanceVar에만 접근 하지만 instancecount++같이 static으로 관리해야하는 경우 staticVar에도 접근함
> - 두 initalizer 모두 여러번 나누어 작성해도 각각 하나의 코드를 길게 늘어뜨린 형태로 한번에 실행됨