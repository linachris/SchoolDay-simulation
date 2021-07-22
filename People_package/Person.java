package People_package;

public abstract class Person {
    protected String name;
    protected int floorNum;
    protected int classroomNum;
    protected int rateOfExhaust;   // how much a person's exhaustion is gonna be affected with every hour passing by
    protected int exhaustionCounter;
    protected boolean inTheClassroom;

    public Person(String name, int floorNum, int classroomNum, int rateOfExhaust) {
        this.name = name;
        this.floorNum = floorNum;
        this.classroomNum = classroomNum;
        this.rateOfExhaust = rateOfExhaust;
        this.exhaustionCounter = 0;
        this.inTheClassroom = false;
    }
    public String getName() { return name; }
    public int getFloorNum() { return floorNum; }
    public int getClassroomNum() { return classroomNum; }
    public int getExhaustion() { return exhaustionCounter; }
    public boolean isInTheClassroom() { return inTheClassroom; }
    public void setPosInClsrm(boolean pos) { inTheClassroom = pos; }
    public abstract void print();
}
