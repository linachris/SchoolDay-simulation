package Areas_package;
import People_package.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class Area {
    protected List<Student> studentList;

    public Area() { this.studentList = new ArrayList<>(1); }
    public abstract void enter(Student student);
    public abstract Student exit();
}
