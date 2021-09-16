package com.example.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String empId;
        String empName;
        int target;
        int days;
        Scanner scan = new Scanner(System.in);
        int salespersoncount;
        ArrayList<Salesperson> salesPersonList = new ArrayList<>();
        System.out.println("Enter number of salesperson");
        salespersoncount = scan.nextInt();
        for (int i = 0; i < salespersoncount; i++) {
            scan.nextLine();
            System.out.println("Enter the details of salesperson " + (i + 1));
            System.out.println("Enter Employee Id");
            empId = scan.nextLine();
            System.out.println("Enter Employee Name");
            empName = scan.nextLine();
            System.out.println("Enter sales target for a week");
            target = scan.nextInt();
            System.out.println("Enter number of days sales happened");
            days = scan.nextInt();
            scan.nextLine();
            ArrayList<ArrayList<Integer>> dailySalesList = new ArrayList<ArrayList<Integer>>();
            int c = 1;                                                                                                  //Prompt the day's number in the output
            for (int j = 0; j < (days / 7); j++) {
                ArrayList<Integer> weekSales = new ArrayList<Integer>();
                int sale;
                for (int k = 0; k < 7; k++) {
                    System.out.println("Enter Sales for day " + c);
                    sale = scan.nextInt();
                    weekSales.add(sale);
                    c++;
                }
                dailySalesList.add(weekSales);
            }
            ArrayList<Integer> finalWeekSales = new ArrayList<Integer>();
            for (int j = 0; j < days % 7; j++) {
                int sale;
                System.out.println("Enter Sales for day " + c);
                sale = scan.nextInt();
                finalWeekSales.add(sale);
                c++;
            }
            dailySalesList.add(finalWeekSales);
            salesPersonList.add(new Salesperson(empId, empName, target, dailySalesList));
            salesPersonList.get(i).totalWeeklySales();

        }
        int managercount;
        int empCount;
        String salesPersonEmpid;
        int d = 1;                                                                                                      //Number of salesperson under this manager
        ArrayList<Manager> managerList = new ArrayList<>();
        System.out.println("Enter number of Managers");
        managercount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < managercount; i++) {
            ArrayList<Salesperson> managingemployees = new ArrayList<>();
            System.out.println("Enter the details of Manager, " + (i + 1));
            System.out.println("Enter Employee ID");
            empId = scan.nextLine();
            System.out.println("Enter Employee Name");
            empName = scan.nextLine();
            System.out.println("Enter the number of salespersons working under him/her");
            empCount = scan.nextInt();
            scan.nextLine();
            for (int j = 0; j < empCount; j++) {
                System.out.println("Enter employee Id of salesperson " + d);
                salesPersonEmpid = scan.nextLine();
                for (Salesperson k : salesPersonList) {
                    if (k.getEmpid().equalsIgnoreCase(salesPersonEmpid)) {
                        managingemployees.add(k);
                    }
                }
                d++;
            }
            managerList.add(new Manager(empId, empName, managingemployees));
        }
        System.out.println("Salesperson details along with their managers");
        for (int i = 0; i < managerList.size(); i++) {
            System.out.println("The details of Manager " + (i + 1) + " are");
            System.out.println("Employee Id: " + managerList.get(i).getEmpid() +
                    " , Manager Name: " + managerList.get(i).getEmpname());
            System.out.println("The details of salespersons under this manager");
            for (int j = 0; j < managerList.get(i).getManagingemployees().size(); j++) {
                System.out.println("The details of salesperson " + (j + 1) + " are");
                System.out.println("Employee Id: " + managerList.get(i).getManagingemployees().get(j).getEmpid() +
                        " , Salesperson Name: " + managerList.get(i).getManagingemployees().get(j).getEmpname());
                System.out.println("The weekly sales done by the salesperson for the respective week is: ");
                System.out.println(managerList.get(i).getManagingemployees().get(j).getTotalweeklysales());
                System.out.println("The achievement status for this Salesperson is: ");
                //System.out.println(managerList.get(i).getManagingemployees().get(j).getAchievementstatus());
                for (int k = 0; k < managerList.get(i).getManagingemployees().get(j).getTotalweeklysales().size(); k++) {
                    ArrayList<Boolean> intermediate = new ArrayList<>();
                    intermediate = managerList.get(i).getManagingemployees().get(j).achievementStatus(managerList.get(i)
                            .getManagingemployees().get(j).getTotalweeklysales());
                    int n = 1;                                                                                           //track the week's number
                    for (boolean l : intermediate) {
                        if (l == true) {
                            System.out.println("Week " + n + ":" + "Achieved");
                        } else {
                            System.out.println("Week " + n + ":" + "Not Achieved");
                        }
                    }

                }
            }
        }
    }
}