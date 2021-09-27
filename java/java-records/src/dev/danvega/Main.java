package dev.danvega;

public class Main {

    public static void main(String[] args) {
	    Employee dan1 = new Employee(1,"Dan","Vega","danvega@gmail.com");
        System.out.println(dan1.toString());

        Employee dan2 = new Employee(1,"Dan","Vega","danvega@gmail.com");
        System.out.println("Employees are equal: " + dan2.equals(dan1));
    }
}
