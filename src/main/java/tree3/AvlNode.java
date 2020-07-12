package tree2;

/**
 * @className: Node
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/10 15:58
 * @version: 1.0
 */
public class AvlNode {

    private Integer number;

    public AvlNode parentNode;

    public AvlNode left;

    public AvlNode right;

    public AvlNode (Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

}
