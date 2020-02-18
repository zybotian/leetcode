package offer;

/**
 * @author tianbo
 * @date 2019-07-17
 */
public class PowerOfN {

    public static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        double result = power(base, exp >> 1);
        result *= result;
        if ((exp & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(power(2, i));
            System.out.println(power(3, i));
            System.out.println(power(5, i));
            System.out.println(power(7, i));
        }
    }
}
