package D0725;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class generate {
    public static void main(String[] args) {
        generate generate = new generate();
        System.out.println(generate.generate(30));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>(Arrays.asList(1));
            result.add(firstRow);
            return result;
        }

        // 第一行
        List<Integer> firstRow = new ArrayList<>(Arrays.asList(1));
        result.add(firstRow);

        // 依次生成每一行
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            // 每行第一个是1
            currentRow.add(1);
            // 处理中间的元素
            for (int j = 1; j <= i - 1; j++) {
                List<Integer> upRow = result.get(i - 1);
                currentRow.add(upRow.get(j - 1) + upRow.get(j));
            }
            // 每行最后一个是1
            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }

}