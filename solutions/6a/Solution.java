class GradeValidator {
    public static void validateGrade(int grade) throws IllegalArgumentException {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
}
