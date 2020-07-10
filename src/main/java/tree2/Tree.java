package tree2;

/**
 * @className: Tree
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/10 16:23
 * @version: 1.0
 */
public class Tree {

    private Node node;

    public void add(Integer i, Object o) throws Exception {
        if (node.getNumber() == i) {
            throw new Exception("无法插入重复值");
        }

        if (this.node == null) {
            node = new Node(i, o);
            return;
        }

        while (node != null) {
            if (node.getNumber() > i) {

            }
        }
    }
}
