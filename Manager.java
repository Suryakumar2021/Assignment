package com.example.java;

import java.util.ArrayList;

public class Manager extends Employee {


    private ArrayList<Salesperson> managingemployees;

    public Manager(String empid, String empname, ArrayList<Salesperson> employees) {
        super(empid, empname);
        this.managingemployees = employees;
    }

    public ArrayList<Salesperson> getManagingemployees() {
        return managingemployees;
    }

    public void setManagingemployees(ArrayList<Salesperson> managingemployees) {
        this.managingemployees = managingemployees;
    }
}