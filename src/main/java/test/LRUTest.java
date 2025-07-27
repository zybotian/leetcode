package test;


import D0725.LRUCache;

public class LRUTest {
    public static void main(String[] args) {

        case1();

//        case2();
    }

    private static void case2() {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));

        lruCache.put(2, 6);

        System.out.println(lruCache.get(1));

        lruCache.put(1, 5);
        lruCache.put(1, 2);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    private static void case1() {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));//1

        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));//-1

        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));// -1
        System.out.println(lruCache.get(3));// 3
        System.out.println(lruCache.get(4));// 4

    }
}
