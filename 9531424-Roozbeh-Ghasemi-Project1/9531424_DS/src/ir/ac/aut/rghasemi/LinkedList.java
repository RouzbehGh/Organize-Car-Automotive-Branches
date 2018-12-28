package ir.ac.aut.rghasemi;

/**
 * Created by Roozbeh Ghasemi on 12/08/2017.
 */

import java.util.Scanner;

public class LinkedList {
    public Node head;
    public int listCount;

    /**
     * This is the constructor of this class.
     * Make own LinkedList with out use the library and make it with nodes.
     */
    public LinkedList() {
        head = new Node("0", "m");
        listCount = 0;
    }

    /**
     * @param current This node pass the current node that is using in this method.
     *                this method will show the data of the nodes.
     */
    public void show(Node current) {

        while (current != null) {
            System.out.print(current.data + "   ");


            if (current.SubNode != null) {
                System.out.print(" (");
                show(current.SubNode);
                System.out.print(" )");

            }
            current = current.next;
        }

    }

    /**
     * @param d this parameter gives the String from main,it means the name of tasks.
     */
    public boolean add(String d) {

        Node end = new Node(d, "m");
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        listCount++;
        System.out.println(d + " appended to tail!");
        return true;
    }

    /**
     * @param d       this string takes the string of the name of Services and will search.
     * @param current takes the current node.
     * @return this part is return the subnode, if the next node was null so it return null.
     */
    public Node findService(String d, Node current) {


        while (current != null && !current.data.equals(d)) {
            current = current.next;
        }
        if (current != null) {
            return current.SubNode;
        } else
            return null;
    }

    /**
     * @param d       this string takes the string of the name of services.
     * @param current this parameter takes the Current node.
     * @return this parameter return boolean values.
     */
    public Node find(String d, Node current) {


        while (current != null && !current.data.equals(d)) {
            current = current.next;
        }
        if (current != null) {
            return current;
        } else
            return null;
    }

    /**
     * @param d       this string takes the string of the name of subservices.
     * @param d1      this string takes the string of the name of services.
     * @param current this parameter takes the Current node.
     * @return this parameter return boolean values.
     */
    public boolean addSubService(String d, String d1, Node current) {


        while (current != null && !current.data.equals(d)) {
            current = current.next;
        }
        if (current != null) {
            Node end = new Node(d1, "s");
            if (current.SubNode != null) {
                current = current.SubNode;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = end;
            } else
                current.SubNode = end;
        } else {
            System.out.println("service not exist  ");
        }

        return true;
    }

    /**
     * @param d this parameter takes the node that would be delete.
     * @return this parameter return false is the node can't be delete or not found the Specified node.
     */

    public boolean deleteNodeWithAddress(Node d) {
        Node current = head.next, y = head;
        while (current != null) {
            if (current == d) {

                listCount--;
                y.next = current.next;
                break;

            }
            y = current;
            current = current.next;
        }
        System.out.println("Delete ");
        return false;
    }

    /**
     * The main gives task from user and process it and pass the needed
     */
    public static void main(String args[]) {

        LinkedList L = new LinkedList();
        LinkedList A = new LinkedList();
        AgencyService AS = new AgencyService();

        int[] MaxHeap = new int[100];
        int[] AgencyLevel = new int[100];
        String[] Customer = new String[100];
        String[] services = new String[100];
        int sizeMaxHeap = -1;
        AgencyServiceCustomer ASC = new AgencyServiceCustomer();
        Scanner scan = new Scanner(System.in);
        String a = "";
        while (!a.contains("exit")) {
            a = scan.nextLine();
            String[] parts = a.split(" ");
            if (a.contains("add service")) {
                if (L.find(parts[2], L.head) == null)
                    L.add(parts[2]);
                else
                    System.out.println("service exist ");


            } else if (a.contains("add subservice")) {

                L.addSubService(parts[4], parts[2], L.head);

            } else if (a.contains("list services from")) {
                L.show(L.findService(parts[3], L.head));

            } else if (a.contains("list services")) {
                L.show(L.head);

            } else if (a.contains("add agency")) {
                if (A.find(parts[2], A.head) == null)
                    A.add(parts[2]);
                else
                    System.out.println("agent exist ");


            } else if (a.contains("list agencies")) {
                A.show(A.head);

            } else if (a.contains("add offer")) {
                Node x, y;
                x = L.find(parts[2], L.head);
                y = A.find(parts[4], A.head);
                AS.add(x, y);
            } else if (a.contains("delete")) {
                Node x, y;
                x = L.find(parts[1], L.head);
                y = A.find(parts[3], A.head);
                if (AS.delete(x, y) == null) {
                    L.deleteNodeWithAddress(x);
                }

            } else if (a.contains("with")) {
                Node x, y;
                x = L.find(parts[1], L.head);
                y = A.find(parts[3], A.head);
                AS.find(x, y);
                ASC.add(AS.find(x, y), parts[5], Integer.parseInt(parts[7]));
                int level = Integer.parseInt(parts[7]);

                int j = 0;
                sizeMaxHeap++;
                int i = sizeMaxHeap;
                while (i > 0) {

                    if (MaxHeap[i / 2] < level) {
                        MaxHeap[i] = MaxHeap[i / 2];

                    }
                    i = i / 2;
                }
                MaxHeap[i] = level;
            } else if (a.contains("list orders")) {
                Node y;
                // y=A.findService(parts[2], A.head);
                Node3 current = ASC.head.next, y1 = ASC.head;
                int i = 0;

                while (current != null) {

                    if (current.agencyService.agency != null && current.agencyService.agency.data.equals(parts[2])) {
                        AgencyLevel[i] = current.level;
                        Customer[i] = current.Customer_Name;
                        services[i] = current.agencyService.service.data;
                        i++;
                        y1.next = current.next;
                        current = current.next;
                        //System.out.println("test!");
                    } else {
                        y1 = current;
                        current = current.next;
                    }
                }
                for (int j = 0; j <= sizeMaxHeap; j++) {
                    for (int k = 0; k < i; k++)
                        if (MaxHeap[j] == AgencyLevel[k]) {
                            System.out.println(Customer[k] + " " + AgencyLevel[k] + " " + services[k]);
                        }

                }


            }


        }


    }
}