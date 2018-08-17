package com.leony.home;

public enum StudentGradeCategories {
    BAD(0, 49, "Bad"),
    BELOW_AVERAGE(50, 59, "Below average"),
    AVERAGE(60, 74, "Average"),
    ABOVE_AVERAGE(75, 84, " Above average"),
    EXCELLENT(85, 100, "Excellent");

    private int minGrade;
    private int maxGrade;
    private String description;

    StudentGradeCategories(int minGrade, int maxGrade, String description) {
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.description = description;
    }

    public int getMinGrade() { return minGrade; }
    public int getMaxGrade() { return maxGrade; }
    public String getDescription() { return description; }
}
