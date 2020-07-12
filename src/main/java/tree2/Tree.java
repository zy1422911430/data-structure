package tree2;

import tree.File;
import tree.Folder;
import tree.NormalTreeNode;

import java.util.HashSet;
import java.util.Random;

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
        if (this.node == null) {
            node = new Node(i, o);
            return;
        }
        Node node1 = this.node;
        while (node1 != null) {
            if (node1.getNumber() == i) {
                throw new Exception("无法插入重复值");
            }
            if (node1.getNumber() > i) {
                if (node1.left != null) {
                    node1 = node1.left;
                } else if (node1.left == null) {
                    node1.left = new Node(i, o);
                    return;
                }
            }

            if (node1.getNumber() < i) {
                if (node1.right != null) {
                    node1 = node1.right;
                } else if (node1.right == null) {
                    node1.right = new Node(i, o);
                    return;
                }
            }
        }
    }

    public void delete(Integer i) {
        Node node1 = this.node;
        while (node1 != null) {
            if (node1.left != null && node1.right != null && node1.getNumber() == i) {
                Node right = new Node(node1.right.getNumber(), node1.getObject());
                node1 = node.left;
                node1.right = right;
                return;
            }
            if (node1.left != null && node1.getNumber() > i) {
                node1 = node1.left;
            } else if (node1.left == null && node1.right == null && node1.getNumber() == i) {
                node1 = null;
                return;
            } else if (node1.left == null && node1.right != null && node1.getNumber() == i) {
                node1 = node1.right;
                return;
            }

            if (node1.right != null && node1.getNumber() < i) {
                node1 = node1.right;
            } else if (node1.right == null && node1.left == null && node1.getNumber() == i) {
                node1 = null;
                return;
            } else if (node1.right == null && node1.left != null && node1.getNumber() == i) {
                node1 = node1.left;
                return;
            }
        }
    }

    public void print(Node node) {
        if (node != null) {
            System.out.println(node.getNumber());
            if (node.left != null) {
                print(node.left);
            }
            if (node.right != null) {
                print(node.right);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        int[] ints = {5,4,18,17,10,3,1,8,15};
        for (int i = 0; i < ints.length; i++) {
            tree.add(ints[i], null);
        }
        tree.print(tree.node);
        tree.delete(4);
        tree.print(tree.node);
    }
}
