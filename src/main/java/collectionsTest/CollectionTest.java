package collectionsTest;

import java.util.*;

/**
 * @className: CollectionTest
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/9 10:24
 * @version: 1.0
 */
public class CollectionTest {

    List<String> list = new ArrayList<>();

    List<Integer> integerList = new ArrayList<>();

    public void printLots(Collection collection, Collection collection1) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer) iterator.next();
            if (collection1 instanceof ArrayList) {
                if (collection1.size() - 1 >= integer) {
                    System.out.println(((ArrayList) collection1).get(integer));
                }
            } else if (collection1 instanceof LinkedList) {
                if (collection1.size() - 1 >= integer) {
                    System.out.println(((LinkedList) collection1).get(integer));
                }
            }
        }
    }

    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.integerList.add(1);
        collectionTest.integerList.add(3);
        collectionTest.integerList.add(4);
        collectionTest.list.add("test1");
        collectionTest.list.add("test2");
        collectionTest.list.add("test3");
        collectionTest.list.add("test4");
        collectionTest.list.add("test5");
        collectionTest.list.add("test6");
        collectionTest.printLots(collectionTest.integerList, collectionTest.list);
    }
}
