package tree;

/**
 * @className: NormalTreeNode
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/9 17:00
 * @version: 1.0
 */
public class NormalTreeNode {

    private Object element;

    private NormalTreeNode firstChild;

    private NormalTreeNode nextSibling;

    public NormalTreeNode (Object element) {
        this.element = element;
    }

    public NormalTreeNode (Object element, NormalTreeNode child, NormalTreeNode sibling) {
        this.element = element;
        this.firstChild = child;
        this.nextSibling = sibling;
    }

    public void print(NormalTreeNode normalTreeNode) {
        if (normalTreeNode != null) {
            if (normalTreeNode.element instanceof Folder) {
                System.out.println(((Folder) normalTreeNode.element).getName());
            } else {
                System.out.println(((File) normalTreeNode.element).getName());
            }
            if (normalTreeNode.getNextSibling() != null) {
                print(normalTreeNode.getNextSibling());
            }
            if (normalTreeNode.getFirstChild() != null) {
                print(normalTreeNode.getFirstChild());
            }
        }
    }

    public void getObject(String name, NormalTreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.element instanceof Folder && ((Folder) treeNode.element).getName().equals(name)) {
                System.out.println(((Folder) treeNode.element).getName());
            } else if ((treeNode.element instanceof File && ((File) treeNode.element).getName().equals(name))) {
                System.out.println(((File) treeNode.element).getName());
            }
            if (treeNode.getNextSibling() != null) {
                getObject(name, treeNode.getNextSibling());
            }
            if (treeNode.getFirstChild() != null) {
                getObject(name, treeNode.getFirstChild());
            }
        }
    }

    public NormalTreeNode getFirstChild() {
        return firstChild;
    }

    public NormalTreeNode getNextSibling() {
        return nextSibling;
    }

    public void addChild(NormalTreeNode child) {
        this.firstChild = child;
    }

    public void addSibling(NormalTreeNode sibling) {
        this.nextSibling = sibling;
    }

    public static void main(String[] args) {
        NormalTreeNode normalTreeNode = new NormalTreeNode(new Folder("folder1"));
        normalTreeNode.addChild(new NormalTreeNode(new Folder("folder2")));
        normalTreeNode.addSibling(new NormalTreeNode(new File("file1")));
        NormalTreeNode firstChild = normalTreeNode.getFirstChild();
        firstChild.addSibling(new NormalTreeNode(new Folder("folder3")));
        NormalTreeNode nextSibling = normalTreeNode.getNextSibling();
        nextSibling.addChild(new NormalTreeNode(new Folder("folder2")));
        normalTreeNode.getObject("file1", normalTreeNode);
    }
}
