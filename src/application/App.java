package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();

        System.out.println();

        for(int i = 0; i < n; i++){
            System.out.println("Data from eployee #" + (i+1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)){
                System.out.println("Id already taken!");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            System.out.println();

            Employee employee = new Employee(id, name, salary);

            list.add(employee);
        }

        System.out.print("Enter the employee that will have salary increase: ");
        int increaseId = sc.nextInt();

        Employee empIncrease = list.stream().filter(x -> x.getId() == increaseId).findFirst().orElse(null);

        if (empIncrease == null){
            System.out.println("Id does not exist!");
            System.out.println();
        }
        else {
            System.out.print("Percentage of increase:");
            double percentage = sc.nextDouble();
            empIncrease.increaseSalary(percentage);
            System.out.println();
        }

        System.out.println("List of employees:");
        for (Employee x : list){
            System.out.println(x);
        }
        sc.close();
    }

    public static boolean hasId(List<Employee> list, int Id){
        Employee emp = list.stream().filter(x -> x.getId() == Id).findFirst().orElse(null);
        return emp != null;
    }
}
