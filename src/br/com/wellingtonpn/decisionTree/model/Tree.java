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
}
