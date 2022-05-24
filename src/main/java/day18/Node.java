package day18;

public class Node {
    private int number;
    private Node leftSon;
    private Node rightSon;

    public Node(int number) {
        this.number = number;
        leftSon = null;
        rightSon = null;
    }

    public int getNumber() {
        return number;
    }

    public Node getLeftSon() {
        return leftSon;
    }

    public Node getRightSon() {
        return rightSon;
    }

    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    public void setRightSon(Node rightSon) {
        this.rightSon = rightSon;
    }
}
