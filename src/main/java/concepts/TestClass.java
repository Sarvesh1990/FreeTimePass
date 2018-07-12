package concepts;

public class TestClass extends  Abstract1 implements Interface1, Interface2 {
    private int value = 10;

    public void function(int value) {
        System.out.println("Testing " + value);
    }

    @Override
    public void printValue() {
        System.out.println(this.value);
    }
}
