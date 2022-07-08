package offer;

public class VerifyPostorder {

    public static void main(String[] args) {
        VerifyPostorder postorder = new VerifyPostorder();
        System.out.println(postorder.verifyPostorder(new int[]{1, 6, 3, 2, 5}));
        System.out.println(postorder.verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int index = start;
        while (postorder[index] < postorder[end]) {
            index++;
        }
        int mid = index;
        while (postorder[index] > postorder[end]) {
            index++;
        }
        return index == end && verifyPostorder(postorder, start, mid - 1) && verifyPostorder(postorder, mid, end - 1);
    }
}
