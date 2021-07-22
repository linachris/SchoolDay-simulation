package People_package;

public abstract class Student extends Person {
    public Student(String name, int floorNum, int classroomNum, int rateOfExhaust) {
        super(name, floorNum, classroomNum, rateOfExhaust);             // constructor of parent class
        System.out.println("A New Student has been created! :");
        System.out.println("Name: " + name + ", Floor: " + floorNum + ", Classroom: " + classroomNum);
    }

    @Override
    public void print() {
        System.out.println(name + " is that: " + exhaustionCounter + " tired.");
    }
    
    public void attend() { exhaustionCounter += rateOfExhaust; }
}
