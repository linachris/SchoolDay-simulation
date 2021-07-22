package Areas_package;
import People_package.Student;
import People_package.Teacher;

public class Floor {
    private final int number;
    private Corridor corr;
    private Classroom[] clsroom;

    public Floor(int Cclass, int flrNum) {
        this.number = flrNum;
        System.out.println("Floor " + number + " has been created!");

        // Deals with the corridor and the classrooms
        corr = new Corridor();

        // Allocating space for each one of the 6 classrooms that the floor consists of,
        // and giving them a number between [1,6]
        clsroom = new Classroom[6];
        for (int i = 0; i < 6; i++)
            clsroom[i] = new Classroom(Cclass, i+1);
    }

    public void enter(Student student) {
        System.out.println(student.getName() + " enters floor!");   // the student enters floor - entering the corridor
        corr.enter(student);
        corr.exit();                                                // exiting the corridor
        clsroom[student.getClassroomNum()-1].enter(student);        // and entering the classroom
    }

    public void place(Teacher teacher) {
        clsroom[teacher.getClassroomNum()-1].place(teacher);
    }

    public void operate() {
        for (int i = 0; i < 6; i++)
        clsroom[i].operate();
    }

    public void print() {
        System.out.println("Floor \"" + number + "\" contains: ");
        for (int i = 0; i < 6; i++)
            clsroom[i].print();
        System.out.println();
    }

    public Student exit() {
        Student studToExit = null;                      // if no student is found -> null is returned
        // Searching for a student to exit a classroom
        for (Classroom clsrmToExit : clsroom) {
            if (!clsrmToExit.noStudentsHere()) {        // found one to exit - break the search
                studToExit = clsrmToExit.exit();
                System.out.println("- " + studToExit.getName() + " starts exiting!");
                break;
            }
            // else continues searching the rest classrooms, for a student to exit
        }
        // if a student was found
        if (studToExit != null) {
            corr.enter(studToExit);         // only one student at the corridor each time,
            corr.exit();                    // so the one entering the corridor, is the one exiting
        }
        return studToExit;
    }

    public void teachers_out() {
        // Removing all the teachers from each classroom
        for (Classroom clsrmToExit : clsroom)
            if (clsrmToExit.TeacherHere())     // found one to exit
                clsrmToExit.teacher_out();
    }
}
