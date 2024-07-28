import java.util.Scanner;

public class Marks {
    private static final int MAX_STUDENTS = 100; // Maximum number of students
    private static final int NUM_SUBJECTS = 3;   // Number of subjects

    // Arrays to store student marks and whether a student exists
    private static int[][] studentMarks = new int[MAX_STUDENTS][NUM_SUBJECTS];
    private static boolean[] studentExists = new boolean[MAX_STUDENTS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (type 'help' for options):");
            String input = scanner.nextLine().trim();

            // Split input into parts
            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "add":
                    addStudentMarks(parts);
                    break;
                case "update":
                    updateStudentMarks(parts);
                    break;
                case "average_s":
                    getSubjectAverage(parts);
                    break;
                case "average":
                    getStudentAverage(parts);
                    break;
                case "total":
                    getTotalMarks(parts);
                    break;
                case "grades":
                    displayGrades();
                    break;
                case "help":
                    displayHelp();
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for options.");
            }
        }
    }

    private static void addStudentMarks(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: add [studentID]");
            return;
        }

        int studentID = stringToInt(parts[1]);

        if (studentID < 1 || studentID >= MAX_STUDENTS) {
            System.out.println("Student ID out of range.");
            return;
        }

        studentExists[studentID] = true;
        // Initialize marks to 0
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            studentMarks[studentID][i] = 0;
        }
        System.out.println("Student " + studentID + " added.");
    }

    private static void updateStudentMarks(String[] parts) {
        if (parts.length != 4) {
            System.out.println("Usage: update [studentID] [subjectID] [mark]");
            return;
        }

        int studentID = stringToInt(parts[1]);
        int subjectID = stringToInt(parts[2]);
        int mark = stringToInt(parts[3]);

        if (studentID < 1 || studentID >= MAX_STUDENTS || !studentExists[studentID] || subjectID < 1 || subjectID > NUM_SUBJECTS) {
            System.out.println("Invalid student ID or subject ID.");
            return;
        }

        studentMarks[studentID][subjectID - 1] = mark;
        System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " was updated to " + mark + ".");
    }

    private static void getSubjectAverage(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: average_s [studentID]");
            return;
        }

        int studentID = stringToInt(parts[1]);

        if (studentID < 1 || studentID >= MAX_STUDENTS || !studentExists[studentID]) {
            System.out.println("Invalid student ID.");
            return;
        }

        int total = 0;
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            total += studentMarks[studentID][i];
        }
        double average = total / (double) NUM_SUBJECTS;
        System.out.println("Student " + studentID + " has an average of " + average + ".");
    }

    private static void getStudentAverage(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: average [studentID]");
            return;
        }

        int studentID = stringToInt(parts[1]);

        if (studentID < 1 || studentID >= MAX_STUDENTS || !studentExists[studentID]) {
            System.out.println("Invalid student ID.");
            return;
        }

        int total = 0;
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            total += studentMarks[studentID][i];
        }
        double average = total / (double) NUM_SUBJECTS;
        System.out.println("Student " + studentID + " has an average of " + average + ".");
    }

    private static void getTotalMarks(String[] parts) {
        if (parts.length != 2) {
            System.out.println("Usage: total [studentID]");
            return;
        }

        int studentID = stringToInt(parts[1]);

        if (studentID < 1 || studentID >= MAX_STUDENTS || !studentExists[studentID]) {
            System.out.println("Invalid student ID.");
            return;
        }

        int total = 0;
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            total += studentMarks[studentID][i];
        }
        System.out.println("Student " + studentID + "'s total marks are " + total + ".");
    }

    private static void displayGrades() {
        System.out.println("Student ID | Subject 1 | Subject 2 | Subject 3");
        for (int studentID = 1; studentID < MAX_STUDENTS; studentID++) {
            if (studentExists[studentID]) {
                System.out.print("    " + studentID + "    | ");
                for (int i = 0; i < NUM_SUBJECTS; i++) {
                    System.out.print(getGrade(studentMarks[studentID][i]) + " | ");
                }
                System.out.println();
            }
        }
    }

    private static String getGrade(int mark) {
        if (mark >= 90) {
            return "A";
        } else if (mark >= 80) {
            return "B";
        } else if (mark >= 70) {
            return "C";
        } else if (mark >= 60) {
            return "D";
        } else {
            return "Fail";
        }
    }

    private static void displayHelp() {
        System.out.println("Commands:");
        System.out.println("add [studentID] - Add a student with the given ID.");
        System.out.println("update [studentID] [subjectID] [mark] - Update the mark for a student and subject.");
        System.out.println("average_s [studentID] - Get the average mark of the student for all subjects.");
        System.out.println("average [studentID] - Get the average mark of the student for all subjects.");
        System.out.println("total [studentID] - Get the total marks of the student.");
        System.out.println("grades - Display grades of all students.");
        System.out.println("help - Display this help message.");
        System.out.println("exit - Exit the program.");
    }

    // Manually convert a string to an integer
    private static int stringToInt(String str) {
        int result = 0;
        int i = 0;
        boolean negative = false;

        if (str.charAt(0) == '-') {
            negative = true;
            i = 1;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return 0; // Return 0 for invalid input
            }
            result = result * 10 + (c - '0');
        }

        return negative ? -result : result;
    }
}
