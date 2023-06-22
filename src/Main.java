import br.com.wellingtonpn.decisionTree.model.Tree;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<Integer>();
        tree.toAdd(10);
        tree.toAdd(8);
        tree.toAdd(5);
        tree.toAdd(9);
        tree.toAdd(7);
        tree.toAdd(18);
        tree.toAdd(13);
        tree.toAdd(20);

        System.out.println("\n\nEm-ordem");
        tree.inOrder(tree.getSource());



    }
}
