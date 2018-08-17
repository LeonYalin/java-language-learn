package com.leony.app;

import com.leony.home.*;
import static com.leony.home.Student.swapNames;

public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("Leon", "Yalin", 1, 82),
                new Student(new Student("Nelly", "Yalin", 2, 84)),
                new Student("Liza", "Yalin", 3, 91)
        };

        System.out.println("");
        Student.printStudents(students);
        swapNames(students[0], students[1]); // static import
        System.out.println("*** after swap");
        Student.printStudents(students);
        System.out.println("");

        Student goodStudent = new GoodStudent("Liza", "Yalin");
        System.out.println("Getting the avg of a good student" + goodStudent.getAvg() + "\n");

        Student student3 = new Student("Leon", "Yalin");
        Student student4 = new Student("Leon", "Yalin");
        System.out.println("Students equality: " + student3.equals(student4));

        StringGames word = new StringGames("lalala");
        System.out.println("\nCreating a string games class with the word" + word);

        word.setWordUsingValueOf(111);
        System.out.println("Using valueOf(): " + word);

        word.setWordUsingConcat(" is COOL!");
        System.out.println("Using concat(): " + word);

        word.setWordUsingReplace("222");
        System.out.println("Using replace(): " + word);

        word.setWordToLowerCase();
        System.out.println("Using toLowerCase(): " + word);

        word.setWordToUpperCase();
        System.out.println("Using to upperCase(): " + word);

        word.setWord("   lalala   ");
        System.out.println("Using trim(): before - " + word);

        word.setWordAsTrim();
        System.out.println("Using trim(): after - " + word);

        word.setWord("111 222 333");
        System.out.println("Using split() and join(): before - " + word);

        word.setWordAsSplitAndJoin(" ", "-");
        System.out.println("Using split() and join(): after - " + word);

        String formattedWord =  word.setWordAsFormat("__I am the added word!__");
        System.out.println("Using format(): " + formattedWord);

        System.out.println("Using charAt(): position 2 - " + word.setWordAsCharAt(2));
        System.out.println("Using subString(): position 0-3 - " + word.setWordAsSubString(0, 3));

        String[] words = new String[] {"Hello", " there, "};
        System.out.println("Using StringBuilder class: " + word.setWordAsStringBuilder(words, 13));

        Student leonYalin = students[0];
        leonYalin.setGrade(82);
        System.out.println("Using getStudentGradeCategory(): " + leonYalin.getStudentGradeCategory());

        leonYalin.setGrade(0);
        leonYalin.testGradeExceptions();

        leonYalin.getStudentGradeFromFile();
        System.out.println("Using getStudentGradeFromFile(): " + leonYalin.getGrade());

        System.out.println("Using sortAndPrintStudents(): before");
        leonYalin.printStudents(students);
        System.out.println("Using sortAndPrintStudents(): after");
        Student.sortAndPrintStudents(students);

        for (Student student : leonYalin) {
            System.out.println("Using iterator:" + student);
        }

        System.out.println("Using the IStudent interface:");
        IStudent goodStudent1 = new GoodStudent("Nelly", "Yalin", 82, 3);
        IStudent badStudent1 = new BadStudent("Leon", "Yalin", 46, 5);
        IStudent[] goodAndBad = new IStudent[]{goodStudent1, badStudent1};
        for (IStudent student : goodAndBad) {
            student.sayHello();
            System.out.println("My specialization is: " + student.getSpecialization());
        }

        System.out.println("Using nested static classes:");
        Student.Syllabus leonYalinSyllabus = leonYalin.getSyllabus();
        leonYalinSyllabus.setSundayCourses(new String[] {"Discrete Math", "Statistics"});
        leonYalinSyllabus.setTuesdayCourses(new String[] {"Compilation", "Linear Math", "Algorithms"});
        leonYalinSyllabus.setFridayCourses(new String[] {"Logic Math", "Automates"});
        leonYalin.printSyllabus();
    }
}
