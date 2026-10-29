class Student {
    private String name;
    private int roll;
    private int[] marks;

    public Student(String name, int roll, int[] marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public double getAverage() {
        if (marks.length == 0) return 0.0;
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 90) return 'A';
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    public String getName() { return name; }
    public int getRoll() { return roll; }
}
