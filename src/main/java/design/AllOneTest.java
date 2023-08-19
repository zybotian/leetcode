package design;

public class AllOneTest {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("key1");
        allOne.inc("key1");
        allOne.inc("key2");
        allOne.inc("key3");
        allOne.inc("key1");
        allOne.inc("key3");
        allOne.inc("key3");
        allOne.inc("key3");
        allOne.inc("key3");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.inc("key2");
        allOne.display();
        allOne.inc("key4");
        allOne.display();
        allOne.inc("key5");
        allOne.display();

        allOne.dec("key4");
        allOne.display();
        allOne.dec("key5");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key2");
        allOne.display();
        allOne.dec("key3");
        allOne.display();
        allOne.dec("key3");
        allOne.display();
        allOne.dec("key3");
        allOne.display();
        allOne.dec("key3");
        allOne.display();
        allOne.dec("key3");
        allOne.display();
    }
}
