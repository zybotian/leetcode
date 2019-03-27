package design;

/**
 * @author tianbo
 * @date 2019-03-25
 */

// 击败7.82%,效率太低
public class MyHashSet {

    int[] array = new int[8];

    int capacity = 8;

    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {

    }

    public void add(int key) {
        if (!contains(key)) {
            if (size < capacity) {
                array[size++] = key;
            } else {
                capacity = capacity << 1;
                int[] tmp = new int[capacity];
                System.arraycopy(array, 0, tmp, 0, size);
                tmp[size] = key;
                size++;
                array = tmp;
            }
        }
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                System.arraycopy(array, i + 1, array, i, size - 1 - i);
                size--;
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        for (int i = 0; i < size; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(2));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);

        System.out.println(myHashSet);

        myHashSet.remove(13);
        System.out.println(myHashSet);

        myHashSet.add(3);
        System.out.println(myHashSet);

        myHashSet.remove(2);
        System.out.println(myHashSet);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i] + ",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
