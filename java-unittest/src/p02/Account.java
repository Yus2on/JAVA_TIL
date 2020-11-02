package p02;

// POJO : Plain Old Java Object -> 프레임워크 없이 자바만 사용한 클래스
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int value) {
        balance -= value;
    }

    public void deposit(int value) {
        balance += value;
    }

    public boolean isMinus() {
        return balance < 0;
    }

    public void throwExcept() {
        throw new ArithmeticException();
    }
}