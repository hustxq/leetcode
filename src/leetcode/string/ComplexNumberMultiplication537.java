package leetcode.string;

public class ComplexNumberMultiplication537 {
    public static void main(String[] args) {
        ComplexNumberMultiplication537 test = new ComplexNumberMultiplication537();
        String s = "1+-1i";
        System.out.println(test.complexNumberMultiply(s, s));
    }

    public String complexNumberMultiply(String a, String b) {
        Num na = parse(a);
        Num nb = parse(b);
        int ia = na.a * nb.a - (na.b * nb.b);
        int ib = na.a * nb.b + na.b * nb.a;
        return new Num(ia, ib).toString();
    }

    private Num parse(String s) {
        Num num = new Num();
        String[] sarr = s.split("\\+");
//        System.out.println(sarr[0]);
        num.a = Integer.parseInt(sarr[0]);
        String b = sarr[1].split("i")[0];
//        System.out.println(b);
        num.b = Integer.parseInt(b);

        return num;
    }

    class Num {
        int a;
        int b;

        public Num() {
        }

        public Num(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + "+" + b + 'i';
        }
    }
}
