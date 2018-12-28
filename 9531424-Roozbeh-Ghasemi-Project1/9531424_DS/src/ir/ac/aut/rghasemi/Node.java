package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/09/2017.
 */
public class Node {
    Node next = null;
    String data;
    Node SubNode = null;
    String type;

    /**
     * This is the constructor of this class.
     * @param d this is the string of data for service nodes.
     * @param t this is the string of type for service nodes.
     */
    public Node(String d, String t) {
        data = d;
        type = t;
    }
}