package design.v2;


public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
//        System.out.println("before1:" + lruCache.get(1));
        lruCache.put(1, 1);
        System.out.println("after1:" + lruCache.get(1));

//        System.out.println("before2:" + lruCache.get(2));
        lruCache.put(2, 2);
        System.out.println("after2:" + lruCache.get(2));

//        System.out.println("before3:" + lruCache.get(3));
        lruCache.put(3, 3);
        System.out.println("after3:" + lruCache.get(3));

//        System.out.println("before4:" + lruCache.get(4));
        lruCache.put(4, 4);
        System.out.println("after4:" + lruCache.get(4));
        System.out.println("after3:" + lruCache.get(3));
        System.out.println("after2:" + lruCache.get(2));
        System.out.println("after1:" + lruCache.get(1));

    }
}
