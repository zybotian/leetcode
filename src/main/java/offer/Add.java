package offer;

public class Add {
    public int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(1, 2));
        System.out.println(add.add(5, 7));
    }
}
