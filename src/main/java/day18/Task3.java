package day18;

public class Task3 {
    public static void main(String[] args) {
        Node root = new Node(20);
        addNode(18, root);
        addNode(15, root);
        addNode(22, root);
        addNode(20, root);
        addNode(16, root);
        addNode(11, root);
        addNode(14, root);
        addNode(24, root);
        addNode(23, root);
        addNode(8, root);
        addNode(5, root);
        addNode(150, root);
        addNode(150, root);
        addNode(27, root);
        dfs(root);
    }

    public static void addNode(int number, Node root) {
        if (number < root.getNumber()) {
            if (root.getLeftSon() == null) {
                root.setLeftSon(new Node(number));
            } else {
                addNode(number, root.getLeftSon());
            }
        } else {
            if (root.getRightSon() == null) {
                root.setRightSon(new Node(number));
            } else {
                addNode(number, root.getRightSon());
            }
        }
    }

    public static void dfs(Node root) {
        if (root.getLeftSon() == null) {
            System.out.print(root.getNumber() + " ");
        } else {
            dfs(root.getLeftSon());
            System.out.print(root.getNumber() + " ");
        }
        if (root.getRightSon() != null) {
            dfs(root.getRightSon());
        }
    }
}