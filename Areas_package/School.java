package Areas_package;
import People_package.Student;
import People_package.Teacher;

public class School {
    private Yard yrd;
    private Stairs stair;
    private Floor[] flr;

    public School(int Cclass) {
        System.out.println("A New School has been created!");
        yrd = new Yard();
        stair = new Stairs();
        flr = new Floor[3];

        // Allocating space for each one of the 3 floors that the school consists of,
        // and giving them a number between [1,3]
        for (int i = 0; i < 3; i++)
            flr[i] = new Floor(Cclass, i+1);
    }

    public void enter(Student student) {
        System.out.println(student.getName() + " enters school!");

        yrd.enter(student);                            // enters & exits yard
        yrd.exit();

        stair.enter(student);                          // enters & exits stairs
        stair.exit();

        flr[student.getFloorNum()-1].enter(student);   // enters floor, enters/exits corridor, finally enters classroom
    }

    public void place(Teacher teacher) {
        flr[teacher.getFloorNum()-1].place(teacher);
    }

    public void empty () {
        for (int i = 0; i < 3; i++) {
            Student studToExit;
            while((studToExit = flr[i].exit()) != null) {   // while there are students in the floor to exit
                stair.enter(studToExit);                    // student enters & exits stairs
                stair.exit();
                yrd.enter(studToExit);                      // student enters & exits yard
                yrd.exit();
            }
            // else continue with the next floor
        }

        for (int i = 0; i < 3; i++)                         // all teachers exit each floor
            flr[i].teachers_out();
    }

    public void operate() {
        for (int i = 0; i < 3; i++)
            flr[i].operate();
    }

    public void print() {
        System.out.println("School life consists of: ");
        for (int i = 0; i < 3; i++)
            flr[i].print();
    }
}
