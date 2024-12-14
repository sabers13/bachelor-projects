package Car_Management_System;

import java.util.ArrayList;

/*
 * @author Allan J. Fret-Cruz
 * Date: April 29, 2020
 */
public class Node {

    public int value;
    public String name;
    public int agencyValue;
    public String agencyName;
    public String carModel;
    public String customerInstruction;
    public String agencyInstruction;
    public double cost;
    public Node next;
    ArrayList<String> subservices = new ArrayList<String>();
ArrayList<Integer> agenciesID = new ArrayList<Integer>();
ArrayList<Integer> servicesID = new ArrayList<Integer>();
    public Node(int value, String name, String carModel, String customerInstruction,
            String agencyInstruction, double cost,ArrayList<Integer> agenciesID,ArrayList<String> subservices) {
        this.value = value;
        this.name = name;
        this.carModel = carModel;
        this.customerInstruction = customerInstruction;
        this.agencyInstruction = agencyInstruction;
        this.cost = cost;
        this.subservices = subservices;
        this.agenciesID = agenciesID;

    }
public Node(int agencyValue,String agencyName,ArrayList<Integer> servicesID){
    this.agencyValue = agencyValue;
        this.agencyName = agencyName;
        this.servicesID = servicesID;
}
    public void setSubservices(ArrayList<String> subservices) {
        this.subservices = subservices;
    }
    public void setAgenciesID(ArrayList<Integer> agenciesID) {
        this.agenciesID = agenciesID;
    }
    public ArrayList<Integer> getAgenciesID() {
        
        return this.agenciesID ;
    }
    public void setServicesID(ArrayList<Integer> agenciesID) {
        this.servicesID = agenciesID;
    }
    public ArrayList<Integer> getServicesID() {
        
        return this.servicesID ;
    }
    public ArrayList<String> getSubservices() {
        
        return this.subservices ;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
