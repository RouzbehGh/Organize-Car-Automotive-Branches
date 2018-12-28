package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/08/2017.
 */
public class AgencyServiceCustomer {
    public Node3 head;
    public int listCount;

    public AgencyServiceCustomer() {
        head = new Node3(null, "0", 0);
        listCount = 0;
    }

    /**
     * @param ag The node of agency.
     * @param cn the string of customer name.
     * @param l  the integer of level order.
     */
    public Node3 add(Node2 ag, String cn, int l) {
        Node3 end = new Node3(ag, cn, l);
        Node3 current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        listCount++;

        return end;
    }
}
