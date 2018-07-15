package interview.apple;

public abstract class B {
    public int value;

    public B(int value) {
        this.value = value;
    }

    public abstract void doSomethingElse();

    public void doSomething() {
        System.out.println("Do something");
    }
}
