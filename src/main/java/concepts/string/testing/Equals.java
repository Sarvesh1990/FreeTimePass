package concepts.string.testing;

public class Equals {
    public static void main(String[] args) {
        String a = "abc";
        String b = a;
        String c = "abc";

        Integer a1 = 1;
        Integer b1 = new Integer(1);

        System.out.println((b == c)  + " " + a1.equals(b1));
    }
}
