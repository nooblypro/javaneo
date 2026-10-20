import java.util.*;
public class Main {
    static class RecordHolder<T> {
        private T record;
        RecordHolder(T record) { this.record = record; }
        T getRecord() { return record; }
        void displayRecordInfo() {
            System.out.println(record);
        }
    }
    static class GradeRecord {
        String name;
        Double grade;
        GradeRecord(String name, Double grade) {
            this.name = name;
            this.grade = grade;
        }
        @Override
        public String toString() {
            return String.format("Grade for %s: %.2f", name, grade);
        }
    }
    static class EnrollmentRecord {
        String course;
        Integer id;
        EnrollmentRecord(String course, Integer id) {
            this.course = course;
            this.id = id;
        }
        @Override
        public String toString() {
            return String.format("Student %d is enrolled in %s", id, course);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        double grade = sc.nextDouble();
        String course = sc.next();
        int id = sc.nextInt();

        RecordHolder<GradeRecord> h1 = new RecordHolder<>(new GradeRecord(name, grade));
        RecordHolder<EnrollmentRecord> h2 = new RecordHolder<>(new EnrollmentRecord(course, id));

        h1.getRecord();
        h1.displayRecordInfo();
        h2.getRecord();
        h2.displayRecordInfo();
    }
}
