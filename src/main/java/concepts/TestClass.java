package concepts;

public class TestClass extends  Abstract1 implements Interface1, Interface2 {
    @Override
    public void function() {
        System.out.println("Testing");
    }

    @Override
    public void printValue() {
        System.out.println(this.value);
    }
}
