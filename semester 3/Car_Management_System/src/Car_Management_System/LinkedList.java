package Car_Management_System;

import java.util.ArrayList;

/*
 *  @author: Allan J. Fret-Cruz
 *  Date: April 28, 2020
 */
public class LinkedList {

    Node head;
Node pos;
    public LinkedList(int value, String name, String carModel, String customerInstruction,
            String agencyInstruction, double cost,ArrayList<Integer> agenciesID,ArrayList<String> subservices) {
        head = new Node(value, name, carModel, customerInstruction,
                agencyInstruction, cost, agenciesID, subservices);
    }
    public LinkedList(int value, String name,ArrayList<Integer> servicesID) {
        head = new Node(value, name,servicesID);
    }

   
    public void add(int value, String name, String carModel, String customerInstruction,
            String agencyInstruction, double cost,ArrayList<Integer> agenciesID,ArrayList<String> subservices) {
        Node newNode = new Node(value, name, carModel, customerInstruction,
                agencyInstruction, cost, agenciesID, subservices);
        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }
    public void add(int value, String name,ArrayList<Integer> servicesID) {
        Node newNode = new Node(value, name,servicesID);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    
    
    public Node getNode(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                break;
            }
            temp = temp.next;
        }
        return temp;
        
    } 
    public int listSize() {
		Node temp = head;
		int size = 0;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	


}
