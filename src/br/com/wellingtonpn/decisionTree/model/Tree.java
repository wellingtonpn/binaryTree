package br.com.wellingtonpn.decisionTree.model;
public class Tree<TYPE extends Comparable>{

    private Node<TYPE> source;

    public Tree() {
        this.source = null;
    }

    public void toAdd(TYPE value)
    {
        Node<TYPE> newNode = new Node<TYPE>(value);
        if( this.source == null )
        {
            this.source = newNode;
        }
        else
        {
            Node<TYPE> actualNode = this.source;
            while( true )
            {
                if( newNode.getValue().compareTo(actualNode.getValue()) == -1 )
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

    public void inOrder(Node<TYPE> actualNode)
    {
        if( actualNode != null )
        {
            this.inOrder(actualNode.getLeft());
            System.out.println("node: " + actualNode.getValue());
            this.inOrder(actualNode.getRight());
        }

    }

    public void preOrder(Node<TYPE> actualNode)
    {
        if( actualNode != null )
        {
            System.out.println("node: " + actualNode.getValue());
            this.preOrder(actualNode.getLeft());
            this.preOrder(actualNode.getRight());
        }
    }

    public void postOrder(Node<TYPE> actualNode)
    {
       if ( actualNode != null )
       {
           this.postOrder(actualNode.getLeft());
           this.postOrder(actualNode.getRight());
           System.out.println("node: " + actualNode.getValue());
       }
    }

    public boolean remove(TYPE value){
        //search for node element in a tree
        Node<TYPE> actual = this.source;
        Node<TYPE> actualDaddy = null;
        while(actual != null){
            if (actual.getValue().equals(value)){
                break;
            }else if (value.compareTo(actual.getValue()) == -1){ //value find is minor than the actual value
                actualDaddy = actual;
                actual = actual.getLeft();
            }else{
                actualDaddy = actual;
                actual = actual.getRight();
            }
        }
        //verify if exist node element
        if (actual != null){

            //node element have 2 sons or node element have just sons on right side
            if (actual.getRight() != null){

                Node<TYPE> substitute = actual.getRight();
                Node<TYPE> substituteDaddy = actual;
                while(substitute.getLeft() != null){
                    substituteDaddy = substitute;
                    substitute = substitute.getLeft();
                }
                substitute.setLeft(actual.getLeft());
                if (actualDaddy != null){
                    if (actual.getValue().compareTo(actualDaddy.getValue()) == -1){ //actual < actualDaddy
                        actualDaddy.setLeft(substitute);
                    }else{
                        actualDaddy.setRight(substitute);
                    }
                }else{ //if there's no actualDaddy, then it is a source
                    this.source = substitute;
                    substituteDaddy.setLeft(null);
                    this.source.setRight(substituteDaddy);
                    this.source.setLeft(actual.getLeft());
                }

                //remove the node element of tree
                if (substitute.getValue().compareTo(substituteDaddy.getValue()) == -1){ //substitute < substituteDaddy
                    substituteDaddy.setLeft(null);
                }else{
                    substituteDaddy.setRight(null);
                }

            }else if (actual.getLeft() != null){ //had son just on left
                Node<TYPE> substituto = actual.getLeft();
                Node<TYPE> paiSubstituto = actual;
                while(substituto.getRight() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getRight();
                }
                if (actualDaddy != null){
                    if (actual.getValue().compareTo(actualDaddy.getValue()) == -1){ //actual < actualDaddy
                        actualDaddy.setLeft(substituto);
                    }else{
                        actualDaddy.setRight(substituto);
                    }
                }else{ //if it s a source
                    this.source = substituto;
                }

                //remove the node element of tree
                if (substituto.getValue().compareTo(paiSubstituto.getValue()) == -1){ //substitute < substituteDaddy
                    paiSubstituto.setLeft(null);
                }else{
                    paiSubstituto.setRight(null);
                }
            }else{ //there's no son
                if (actualDaddy != null){
                    if (actual.getValue().compareTo(actualDaddy.getValue()) == -1){ //actual < actualDaddy
                        actualDaddy.setLeft(null);
                    }else{
                        actualDaddy.setRight(null);
                    }
                }else{ //is a source
                    this.source = null;
                }
            }

            return true;
        }else{
            return false;
        }
    }
    public Node<TYPE> getSource() {
        return this.source;
    }
}
