package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/09/2017.
 */
public class AgencyService {

    public Node2 head;
    public int listCount;

    public AgencyService() {
        head = new Node2(null, null);
        listCount = 0;
    }

    /**
     * @param a the name of nodes that would be add(The Service name)
     * @param b the name of nodes that would be add(The Agency Name)
     * @return
     */
    public boolean add(Node a, Node b) {
        Node2 end = new Node2(a, b);
        Node2 current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        System.out.println("offer is added");
        listCount++;

        return true;
    }
    /**
     * @param a the name of nodes that would be find(The Service name)
     * @param b the name of nodes that would be find(The Agency Name)
     * @return
     */
    public Node2 find(Node a, Node b) {

        Node2 current = head;

        while (current != null && current.service != a && current.agency != b) {
            current = current.next;
        }
        if (current == null)
            System.out.println("test!");
        return current;
    }
    /**
     * @param a the name of nodes that would be delete(The Service name)
     * @param b the name of nodes that would be delete(The Agency Name)
     * @return
     */
    public Node2 delete(Node a, Node b) {

        Node2 current = head, y = head;

        while (current != null && current.service != a && current.agency != b) {
            y = current;
            current = current.next;
        }

        if (current != null) {
            y.next = y.next.next;
            listCount--;
        }
        current = head;
        while (current != null && current.service != a) {
            current = current.next;
        }


        return current;
    }
}



