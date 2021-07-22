package Areas_package;
import People_package.Student;

public class Yard extends Area{
    public Yard() { System.out.println("A New Yard has been created!"); }

    @Override
    public void enter(Student student) {
        studentList.add(student);                                             // add the student to the list
        System.out.println(student.getName() + " enters schoolyard!");
    }

    @Override
    public Student exit() {
        Student studToExit = studentList.get(0);                             // one student list
        System.out.println(studToExit.getName() + " exits schoolyard!");
        studentList.remove(0);                                               // removing the first student
        return studToExit;
    }
}
