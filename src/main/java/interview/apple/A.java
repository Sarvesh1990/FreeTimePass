package interview.apple;

public class A extends B {
    public A(){
        super(10);
    }


    public static void doSomething() {
        System.out.println("Do something inside");
    }

    public static int count;

    public static synchronized int getCount() {
        return count;
    }

    public static synchronized void increment() {
        count++;
    }

}
