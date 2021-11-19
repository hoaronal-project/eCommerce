package com.cmc;

public class Main {
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;

    @Override
    public int hashCode() {
        return employeeId;
    }

    public boolean equals(Main e) {
        return this.employeeId == e.employeeId;
    }

    public static void main(String[] args) {
        Main one = new Main();
        one.employeeId = 101;
        Main two = new Main();
        two.employeeId = 101;
        if (one.equals(two)) System.out.println("Success");
        else System.out.println("Failure");

    }
}