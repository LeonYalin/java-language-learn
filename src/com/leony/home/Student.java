package com.leony.home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student>, Iterable<Student> {
    private String firstName;
    private String lastName;
    private String fullName;
    private int grade;
    private int year;
    protected String hobby = "Swimming";

    // initialization block
    {
        System.out.println("Creating a student..");
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setFullName();
    }

    public Student(String firstName, String lastName, int year, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setFullName();
    }

    public Student(Student anotherStudent) {
        this(anotherStudent.firstName, anotherStudent.lastName);
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public int getGrade() { return this.grade; }

    public void setGrade(int grade) { this.grade = grade; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    private Syllabus syllabus = new Syllabus();

    public Syllabus getSyllabus() { return syllabus; }

    public void printSyllabus() {
        System.out.println("Sunday courses: " + this.getSyllabus().getSundayCourses());
        System.out.println("Tuesday courses: " + this.getSyllabus().getTuesdayCourses());
        System.out.println("Friday courses: " + this.getSyllabus().getFridayCourses());
    }

    private void setFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    public int getAvg() {
        return IStudent.AVG;
    }

    public String getStudentGradeCategory() {
        for (StudentGradeCategories category : StudentGradeCategories.values()) {
            if (grade >= category.getMinGrade() && grade <= category.getMaxGrade()) {
                return category.getDescription();
            }
        }
        return null;
    }

    public void testGradeExceptions() {
        try {
            int dividedGrade = 100 / grade; // exception if grade is 0
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("It's illegal to divide by 0");
        }
    }

    public void getStudentGradeFromFile() {
        BufferedReader reader = null;
        String localPath = new File("").getAbsolutePath();
        String[] pathParts = localPath.split("\\\\");
        String folderPath = "src" + File.separator + "com" + File.separator + "leony" + File.separator + "resources" + File.separator + "grades.txt";
        localPath = String.join(File.separator, pathParts);
        localPath += File.separator + folderPath;
        List<Integer> gradesFromFile = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(localPath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                gradesFromFile.add(Integer.valueOf(line));
            }
            if (gradesFromFile.size() == 0) {
                throw new StudentException("failed to get grades from file");
            } else {
                this.setGrade(gradesFromFile.get(0));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception when Reading file \n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("other exception in file reading process happened" + e.getMessage());
        } finally {
            try {
                closeReader(reader);
            } catch (Exception e){
                System.out.println("File close exception\n" + e.getMessage());
            }
            try {
                throwCustomException();
            } catch (Exception e) {
                System.out.println("Use custom exception: catch block");
            }
        }
    }

    public static void swapNames(Student firstStudent, Student secondStudent) {
        String tempFirstName = firstStudent.firstName;
        String tempLastName = firstStudent.lastName;
        firstStudent.firstName = secondStudent.firstName;
        firstStudent.lastName = secondStudent.lastName;
        secondStudent.firstName = tempFirstName;
        secondStudent.lastName = tempLastName;
        firstStudent.setFullName();
        secondStudent.setFullName();
    }

    public static void swapNames(Student... students) {
        Student.swapNames(students[0], students[1]);
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void sortAndPrintStudents(Student[] students) {
        Arrays.sort(students);
        printStudents(students);
    }

    @Override
    public String toString() {
        return this.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;

        Student student = (Student) obj;
        return this.firstName == student.firstName && this.lastName == student.lastName;
    }

    public String getFullName() {
        return this.fullName;
    }

    private void closeReader(BufferedReader reader) throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    private void throwCustomException() throws StudentException {
        throw new StudentException("test exception");
    }

    @Override
    public int compareTo(Student s) {
        if (year > s.year) return -1;
        else if (year < s.year) return 1;
        else return (grade - s.getGrade());
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            private int index = 0;
            private GoodStudent goodStudent = new GoodStudent("Leon", "Yalin", 82, 3);
            private BadStudent badStudent = new BadStudent("Nelly", "Yalin", 73, 1);

            @Override
            public boolean hasNext() {
                return index < IStudent.TOTAL_STUDENTS_FOR_ITERATOR;
            }

            @Override
            public Student next() {
                return index++ == 0 ? goodStudent : badStudent;
            }
        };
    }

    /**
     * Implementation of iterator as an inner class
     */
//    private class StudentIterator implements Iterator<Student> {
//        int index = 0;
//        private GoodStudent goodStudent;
//        private BadStudent badStudent;
//
//        public StudentIterator(GoodStudent goodStudent, BadStudent badStudent) {
//            this.goodStudent = goodStudent;
//            this.badStudent = badStudent;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return index < IStudent.TOTAL_STUDENTS_FOR_ITERATOR;
//        }
//
//        @Override
//        public Student next() {
//            return index++ == 0 ? goodStudent : badStudent;
//        }
//    }

    public static class Syllabus {
        private String[] sundayCourses;
        private String[] tuesdayCourses;
        private String[] fridayCourses;

        public Syllabus(){}

        public Syllabus(String[] sundayCourses, String[] tuesdayCourses, String[] fridayCourses) {
            this.sundayCourses = sundayCourses;
            this.tuesdayCourses = tuesdayCourses;
            this.fridayCourses = fridayCourses;
        }

        public String[] getSundayCourses() { return sundayCourses; }
        public void setSundayCourses(String[] sundayCourses) { this.sundayCourses = sundayCourses; }
        public String[] getTuesdayCourses() { return tuesdayCourses; }
        public void setTuesdayCourses(String[] tuesdayCourses) { this.tuesdayCourses = tuesdayCourses; }
        public String[] getFridayCourses() { return fridayCourses; }
        public void setFridayCourses(String[] fridayCourses) { this.fridayCourses = fridayCourses; }
    }
}
