package Areas_package;
import People_package.Student;

public class Stairs extends Area{
    public Stairs() { System.out.println("New Stairs have been created!"); }

    @Override
    public void enter(Student student) {
        studentList.add(student);                                       // add the student to the list
        System.out.println(student.getName() + " enters stairs!");
    }

    @Override
    public Student exit() {
        Student studToExit = studentList.get(0);                        // one student list
        System.out.println(studToExit.getName() + " exits stairs!");
        studentList.remove(0);                                          // removing the first student
        return studToExit;
    }
}
