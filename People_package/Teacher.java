package People_package;

public class Teacher extends Person {
    public Teacher(String name, int floorNum, int classroomNum, int rateOfExhaust) {
        super(name, floorNum, classroomNum, rateOfExhaust);             // constructor of parent class
        System.out.println("A New Teacher has been created! :");
        System.out.println("Name: " + name + ", Floor: " + floorNum + ", Classroom: " + classroomNum);
    }
    @Override
    public void print() {
        System.out.println("The teacher is : " + name + " and is that: " + exhaustionCounter + " tired.");
    }
    public void teach() { exhaustionCounter += rateOfExhaust; }
}