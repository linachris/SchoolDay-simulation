package Ids_package;

public class ids {
    public static class ArrayPersonData {
        public String name;
        public int floor_num;
        public int clsr_num;
        public String grade;

        public ArrayPersonData(String name, int floor_num, int clsr_num, String grade) {
            this.name = name;
            this.floor_num = floor_num;
            this.clsr_num = clsr_num;
            this.grade = grade;
        }
    }

    // Each Classroom: 2Students - each Floor: 6Classrooms - School: 3Floors
    // Students in classrooms[1,3]->juniors, [4,6]->seniors
    public static ArrayPersonData[] studentInfo = {
            new ArrayPersonData("Amelia", 1, 1, "junior"),
            new ArrayPersonData("Atticus", 1, 1, "junior"),
            new ArrayPersonData("Cora", 1, 2, "junior"),
            new ArrayPersonData("Felix", 1, 2, "junior"),
            new ArrayPersonData("Luna", 1, 3, "junior"),
            new ArrayPersonData("Matthew", 1, 3, "junior"),
            new ArrayPersonData("Arizona", 1, 4, "senior"),
            new ArrayPersonData("Sebastian", 1, 4, "senior"),
            new ArrayPersonData("Maeve", 1, 5, "senior"),
            new ArrayPersonData("Ethan", 1, 5, "senior"),
            new ArrayPersonData("Caroline", 1, 6, "senior"),
            new ArrayPersonData("William", 1, 6, "senior"),
            new ArrayPersonData("Phoebe", 2, 1, "junior"),
            new ArrayPersonData("Elijah", 2, 1, "junior"),
            new ArrayPersonData("Maisie", 2, 2, "junior"),
            new ArrayPersonData("Tobias", 2, 2, "junior"),
            new ArrayPersonData("Rebecca", 2, 3, "junior"),
            new ArrayPersonData("Nathaniel", 2, 3, "junior"),
            new ArrayPersonData("Genevieve", 2, 4, "senior"),
            new ArrayPersonData("Jacob", 2, 4, "senior"),
            new ArrayPersonData("Hazel", 2, 5, "senior"),
            new ArrayPersonData("Isaac", 2, 5, "senior"),
            new ArrayPersonData("Evelyn", 2, 6, "senior"),
            new ArrayPersonData("Owen", 2, 6, "senior"),
            new ArrayPersonData("Maia", 3, 1, "junior"),
            new ArrayPersonData("Wesley", 3, 1, "junior"),
            new ArrayPersonData("Esme", 3, 2, "junior"),
            new ArrayPersonData("Nathan", 3, 2, "junior"),
            new ArrayPersonData("Naomi", 3, 3, "junior"),
            new ArrayPersonData("Harry", 3, 3, "junior"),
            new ArrayPersonData("Kristen", 3, 4, "senior"),
            new ArrayPersonData("Oliver", 3, 4, "senior"),
            new ArrayPersonData("Abigail", 3, 5, "senior"),
            new ArrayPersonData("Callum", 3, 5, "senior"),
            new ArrayPersonData("Jade", 3, 6, "senior"),
            new ArrayPersonData("Miles", 3, 6, "senior"),
    };

    public static ArrayPersonData[] teacherInfo = {
            new ArrayPersonData("Daenerys", 1, 1, "teacher"),
            new ArrayPersonData("Jaime", 1, 2, "teacher"),
            new ArrayPersonData("Cersei", 1, 3, "teacher"),
            new ArrayPersonData("Ned", 1, 4, "teacher"),
            new ArrayPersonData("Rhaegar", 1, 5, "teacher"),
            new ArrayPersonData("Sansa", 1, 6, "teacher"),
            new ArrayPersonData("Aerys", 2, 1, "teacher"),
            new ArrayPersonData("Tyrion", 2, 2, "teacher"),
            new ArrayPersonData("Tywin", 2, 3, "teacher"),
            new ArrayPersonData("Arya", 2, 4, "teacher"),
            new ArrayPersonData("Bran", 2, 5, "teacher"),
            new ArrayPersonData("Sandor", 2, 6, "teacher"),
            new ArrayPersonData("Aegon", 3, 1, "teacher"),
            new ArrayPersonData("Joffrey", 3, 2, "teacher"),
            new ArrayPersonData("Euron", 3, 3, "teacher"),
            new ArrayPersonData("Theon", 3, 4, "teacher"),
            new ArrayPersonData("Oberyn", 3, 5, "teacher"),
            new ArrayPersonData("Jorah", 3, 6, "teacher"),
    };
}
