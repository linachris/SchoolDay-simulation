package Areas_package;
import People_package.Student;
import People_package.Teacher;

public class Classroom extends Area {
    private final int capacity;
    private final int number;       // [1,6]
    Teacher teacher;

    public Classroom(int Cclass, int number) {
        System.out.println("Classroom " + number + " has been created!");
        this.capacity = Cclass;
        this.number = number;
    }

    @Override
    public void enter(Student student) {
        if (studentList.size() < capacity-1) {
            studentList.add(student);                                       // add the student to the list
            student.setPosInClsrm(true);                                    // and update the stud's position in the classroom
            System.out.println(student.getName() + " enters classroom!");
        }
    }

    public void place(Teacher teacher) {
        this.teacher = teacher;
        this.teacher.setPosInClsrm(true);  // is in the classroom
    }

    public void operate() {
        // the teacher is teaching and the students(from the classroom's list) are attending the lesson
        teacher.teach();
        for (Student stud : studentList)
            stud.attend();
    }

    public void print() {
        System.out.println("People in class \"" + number + "\" are: ");
        System.out.print("    ");
        if (TeacherHere())
            teacher.print();
        else System.out.println("No teacher here");

        for (Student stud : studentList) {
            System.out.print("    ");
            stud.print();
        }
    }

    @Override
    public Student exit() {
        Student studToExit = studentList.get(0);                        // one student list
        studToExit.setPosInClsrm(false);                                // is out of the classroom now
        System.out.println(studToExit.getName() + " exits classroom!");
        studentList.remove(0);                                     // removing the first student
        return studToExit;
    }

    public void teacher_out() {
        teacher.setPosInClsrm(false);                                   // is out of the classroom now
        teacher.print();
        System.out.println("--> teacher is out!");
    }

    public boolean noStudentsHere() { return (studentList.size() == 0);}

    public boolean TeacherHere() {
        if (teacher != null)
            return teacher.isInTheClassroom();
        return false;
    }
}
