package offer;

public class IsNumber {

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("0"));
        System.out.println(isNumber.isNumber("1e-3"));
        System.out.println(isNumber.isNumber("+12.3E-5"));
        System.out.println(isNumber.isNumber("e"));
        System.out.println(isNumber.isNumber("."));

    }

    public boolean isNumber(String s) {
        // 参数有效性检查
        if (s == null || s.length() == 0) {
            return false;
        }

        // 转换为字符数组
        char[] arr = s.trim().toCharArray();
        if (arr.length == 0) {
            return false;
        }

        // 遍历字符数组
        int index = 0;
        // 跳过前面的正负号
        if (arr[index] == '+' || arr[index] == '-') {
            index++;
        }
        int cur = index;

        // 跳过整数
        index = scanUnsignedInteger(arr, index);

        // 当前遍历过的是数字
        boolean numeric = (index > cur);

        // 小数点
        if (index < arr.length && arr[index] == '.') {
            // 跳过小数点
            index++;
            cur = index;
            // 小数点后面的数字
            index = scanUnsignedInteger(arr, index);
            numeric = (index > cur) || numeric;
        }

        // e或E
        if (index < arr.length && (arr[index] == 'e' || arr[index] == 'E')) {
            // 跳过e/E
            index++;
            // 略过符号位
            if (index < arr.length && (arr[index] == '+' || arr[index] == '-')) {
                index++;
            }
            cur = index;
            index = scanUnsignedInteger(arr, index);
            numeric = (index > cur) && numeric;
        }
        return numeric && index == arr.length;
    }

    /**
     * 从index开始遍历，返回的index是第一个不是数字的位置
     *
     * @param arr
     * @param index
     * @return
     */
    public int scanUnsignedInteger(char[] arr, int index) {
        while (index < arr.length && arr[index] >= '0' && arr[index] <= '9') {
            index++;
        }
        return index;
    }
}
