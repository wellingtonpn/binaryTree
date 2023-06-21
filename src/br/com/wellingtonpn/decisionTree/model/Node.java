package br.com.wellingtonpn.decisionTree.model;

public class Node<TYPE> {
    private TYPE value;
    private Node<TYPE> left;
    private Node<TYPE> right;

    public Node(TYPE value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TYPE getValue() {
        return value;
    }

    public void setValue(TYPE value) {
        this.value = value;
    }

    public Node<TYPE> getLeft() {
        return left;
    }

    public void setLeft(Node<TYPE> left) {
        this.left = left;
    }

    public Node<TYPE> getRight() {
        return right;
    }

    public void setRight(Node<TYPE> right) {
        this.right = right;
    }
}

