package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/09/2017.
 */
public class Node3 {
    Node3 next = null;
    Node2 agencyService;
    String Customer_Name;
    int level;

    /**
     * This is the constructor of this class.
     * @param ag The nodes of Agency Name for order of customers.
     * @param cn The string of customers name.
     * @param l  The integer of level orders.
     */
    public Node3(Node2 ag, String cn, int l) {
        agencyService = ag;
        Customer_Name = cn;
        level = l;
    }

}
