package Areas_package;
import People_package.Student;

public class Corridor extends Area {
    public Corridor() { System.out.println("A New Corridor has been created!"); }

    @Override
    public void enter(Student student) {
        studentList.add(student);                                       // add the student to the list
        System.out.println(student.getName() + " enters corridor!");
    }

    @Override
    public Student exit() {
        Student studToExit = studentList.get(0);                        // one student list
        System.out.println(studToExit.getName() + " exits corridor!");
        studentList.remove(0);                                          // removing the first student
        return studToExit;
    }
}
