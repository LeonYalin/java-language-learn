package com.leony.home;

public class GoodStudent extends Student implements IStudent {
    private int avg = 95;

    public GoodStudent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public GoodStudent(String firstName, String lastName, int grade, int year) {
        super(firstName, lastName, grade, year);
    }

    @Override
    public int getAvg() {
        return avg;
    }

    @Override
    public String getSpecialization() {
        return "Studying all the day long";
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, nice to meet U!");
    }
}
