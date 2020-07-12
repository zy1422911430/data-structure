package tree3;

import tree2.AvlNode;
import tree2.Node;

/**
 * @className: AvlTree
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/12 9:26
 * @version: 1.0
 */
public class AvlTree {

    private AvlNode node;

    private static final Integer MAX_LEFT = 2;

    private static final Integer MAX_RIGHT = -2;

    public boolean add(Integer i, Object o) throws Exception {
        if (this.node == null) {
            node = new AvlNode(i);
            return true;
        }
        AvlNode node1 = this.node;
        while (node1 != null) {
            if (node1.getNumber() == i) {
                throw new Exception("无法插入重复值");
            }
            if (node1.getNumber() > i) {
                if (node1.left != null) {
                    node1 = node1.left;

                } else if (node1.left == null) {
                    node1.left = new AvlNode(i);
                    return true;
                }
            }

            if (node1.getNumber() < i) {
                if (node1.right != null) {
                    node1 = node1.right;
                } else if (node1.right == null) {
                    node1.right = new AvlNode(i);
                    return true;
                }
            }
        }
        return false;
    }

    private int calcNodeBalanceValue(AvlNode node) {
        if (node == null) {
            return 0;
        }
        return getHeightByNode(node);
    }

    private int getHeightByNode(AvlNode node) {
        if (node == null) {
            return 0;
        }
        return getChildDepth(node.left) - getChildDepth(node.right);
    }

    private int getChildDepth(AvlNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getChildDepth(node.left), getChildDepth(node.right));
    }
}
