package interview.apple;

public class A extends B {
    public A(){
        super(10);
    }


    @Override
    public void doSomethingElse() {
        super.doSomething();
    }

    public void doSomething() {
        super.doSomething();
        System.out.println("Do something inside");
    }

    public static int count;

    public synchronized static int getCount() {
        return count;
    }

    public static synchronized void increment() {
        count++;
    }

}
