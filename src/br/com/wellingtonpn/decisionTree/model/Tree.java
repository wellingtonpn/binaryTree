package br.com.wellingtonpn.decisionTree.model;
public class Tree<TYPE extends Comparable>{

    private Node<TYPE> source;

    public Tree() {
        this.source = null;
    }

    public void toAdd(TYPE value)
    {
        Node<TYPE> newNode = new Node<TYPE>(value);
        if(this.source == null)
        {
            this.source = newNode;
        }
        else
        {
            Node<TYPE> actualNode = this.source;
            while(true)
            {
                if(newNode.getValue().compareTo(actualNode.getValue()) == -1)
                {
                    if(actualNode.getLeft() != null)
                    {
                        actualNode = actualNode.getLeft();
                    }
                    else
                    {
                        actualNode.setLeft(newNode);
                        break;
                    }
                }
                else
                {
                    if(actualNode.getRight() != null)
                    {
                        actualNode = actualNode.getRight();
                    }
                    else
                    {
                        actualNode.setRight(newNode);
                        break;
                    }
                }
            }
        }

    }

    public void inOrder(Node<TYPE> actual)
    {
        if(actual != null)
        {
            this.inOrder(actual.getLeft());
            System.out.println("node: " + actual.getValue());
            this.inOrder(actual.getRight());
        }

    }

    public void preOrder(Node<TYPE> actual)
    {
        if(actual != null)
        {
            System.out.println("node: " + actual.getValue());
            this.preOrder(actual.getRight());
            this.preOrder(actual.getLeft());
        }
    }

    public Node<TYPE> getSource() {
        return this.source;
    }
}
