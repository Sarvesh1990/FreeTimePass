package concepts.prot.testing;

public class Base {
    private int integer1;

    public class NestedClass {
        public NestedClass (Integer a) {
            integer1 = 1;
        }

        public Integer getInteger() {
            return integer1;
        }
    }
}
