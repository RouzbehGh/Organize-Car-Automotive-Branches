package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/09/2017.
 */
public class Node2 {
    Node2 next = null;
    Node agency;
    Node service = null;
    /**
     * This is the constructor of this class.
     * @param a this is the string of agency for Agency nodes.
     * @param b this is the string of services for Agency nodes.
     */
    public Node2(Node a, Node b) {
        agency = b;
        service = a;
    }

}

