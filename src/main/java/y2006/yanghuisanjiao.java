package y2006;

import java.util.ArrayList;
import java.util.List;

public class yanghuisanjiao {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }

        // 依次构建每一行
        for (int line = 1; line <= numRows; line++) {
            List<Integer> preLine = null;
            if (line >= 2) {
                preLine = result.get(line - 2);
            }
            List<Integer> currentLine = buildLine(line, preLine);
            result.add(currentLine);
        }


        return result;
    }

    private List<Integer> buildLine(int line, List<Integer> preLine) {
        List<Integer> currentLine = new ArrayList<>();
        for (int j = 1; j <= line; j++) {
            if (j == 1) {// 当前行第一个元素
                currentLine.add(1);
            } else if (j == line) { // 当前行最后一个元素
                currentLine.add(1);
            } else {// 中间元素
                currentLine.add(preLine.get(j - 2) + preLine.get(j - 1));
            }
        }
        return currentLine;
    }

    public static void main(String[] args) {
        yanghuisanjiao yanghuisanjiao = new yanghuisanjiao();
        for (int i = 1; i <= 30; i++) {
            System.out.println(yanghuisanjiao.generate(i));
        }
    }
}
