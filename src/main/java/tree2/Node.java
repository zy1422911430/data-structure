package tree2;

/**
 * @className: Node
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/10 15:58
 * @version: 1.0
 */
public class Node {

    private Integer number;

    private Object object;

    public Node left;

    public Node right;

    public Node (Integer number, Object o) {
        this.number = number;
        this.object = o;
    }

    public Integer getNumber() {
        return number;
    }

}
