package com.leony.home;

public class BadStudent extends Student implements IStudent {
    private int avg = 60;

    public BadStudent(String firstName, String lastName, int grade ,int year) {
        super(firstName, lastName, grade, year);
    }

    @Override
    public int getAvg() {
        return avg;
    }


    @Override
    public String getSpecialization() {
        return "Smoking and drinking";
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm a bad bad student :)");
    }
}
