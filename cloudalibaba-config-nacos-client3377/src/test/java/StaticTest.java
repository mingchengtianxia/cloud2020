public class StaticTest {
    @SuppressWarnings("all")
    private static int value = 2;
    static void print(){
        System.out.println(Math.abs(value));
    }

    public static void main(String[] args){
        StaticTest.print();

        final String a = "1";
        String b = "1";
        String c = "123";
        String d = b+"23";
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(c == d);
        String e= a+"23";
        System.out.println(System.identityHashCode(e));
        System.out.println(c==e);
    }

}
