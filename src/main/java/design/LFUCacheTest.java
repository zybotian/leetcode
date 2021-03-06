package design;

/**
 * @author tianbo
 * @date 2019-04-15
 */
public class LFUCacheTest {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(1 == cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(-1 == cache.get(2));       // returns -1 (not found)
        System.out.println(3 == cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(-1 == cache.get(1));       // returns -1 (not found)
        System.out.println(3 == cache.get(3));       // returns 3
        System.out.println(4 == cache.get(4));       // returns 4
    }
}
