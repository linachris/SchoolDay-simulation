import Areas_package.*;
import People_package.*;
import Ids_package.ids;

import java.util.Random;

public class Main {

    // shuffling and array of students
    public static void shuffle(Student[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            Student temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }

    // shuffling and array of teachers
    public static void shuffle(Teacher[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            Teacher temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {

        if (args.length != 6) {
            System.err.println("Error!\nCorrect Usage is with args: <Classroom capacity> <Junior Student's exhaustion> <Senior Student's exhaustion> " +
                    "<Teacher's exhaustion> <School Hours>");
        }

        int Cclass = Integer.parseInt(args[0]);
        int Lj = Integer.parseInt(args[1]);
        int Ls = Integer.parseInt(args[2]);
        int Lt = Integer.parseInt(args[3]);
        int N = Integer.parseInt(args[4]);

        // Creating a school, for students and teachers to enter
        School school = new School(Cclass);

        // Creating students
        Student[] students = new Student[36];
        for (int i = 0; i < 36 ; i++) {
            if (ids.studentInfo[i].grade.equals("junior"))
                students[i] = new Junior(ids.studentInfo[i].name, ids.studentInfo[i].floor_num, ids.studentInfo[i].clsr_num, Lj);
            else if (ids.studentInfo[i].grade.equals("senior"))
                students[i] = new Senior(ids.studentInfo[i].name, ids.studentInfo[i].floor_num, ids.studentInfo[i].clsr_num, Ls);
        }

        System.out.println();

        // Creating teachers
        Teacher[] teachers = new Teacher[18];
        for (int i = 0; i < 18 ; i++)
            teachers[i] = new Teacher(ids.teacherInfo[i].name, ids.teacherInfo[i].floor_num, ids.teacherInfo[i].clsr_num, Lt);

        System.out.println();

        // Shuffling the arrays, for students and teachers to enter/place school randomly
        shuffle(students);
        shuffle(teachers);

        // Students enter the school & teachers are placed in the school randomly
        for (int i = 0; i < 36; i++) {
            school.enter(students[i]);
            if (i < 18)
                school.place(teachers[i]);
        }

        // School operating (teachers teaching & students attending the classes) for N hours
        for (int i = 0; i < N; i++)
            school.operate();

        System.out.println("\nPrinting School:...");
        school.print();

        // School is being emptied after N hours of operation
        school.empty();
    }
}
