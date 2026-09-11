/*
Module: CI1151 Introduction to Programming
Group Number: 2
Group Members:
1. Name: Khairul Sufi Bin Khairul Ariffin 				Student ID: B20260183
2. Name: Ammar Abdul Hafiz Bin Haji Ahmad Nizam 		Student ID: B20260161
3. Name: Ahmad Arsad Baqi Safwan Bin Haji Hasnan 	  	Student ID: B20260664
4. Name: Mohammad Airel Riezuan Bin Mohammad Nazre 		Student ID: B20260478
*/

import java.util.Scanner;

public class assessmentAnalyzer {
    private static String[] studentIDs;
    private static String[] studentNames;
    private static int[] testMarks;
    private static int[] labMarks;
    private static int[] assignmentMarks;
    private static int[] overallMarks;
    private static String[] grades;
    private static int numStudents = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        numStudents = inputNumberOfStudents(input);

        studentIDs = new String[numStudents];
        studentNames = new String[numStudents];
        testMarks = new int[numStudents];
        labMarks = new int[numStudents];
        assignmentMarks = new int[numStudents];
        overallMarks = new int[numStudents];
        grades = new String[numStudents];

        inputStudentData(input);

        int choice;
        do {
            displayMenu();
            choice = input.nextInt();

            while (choice < 1 || choice > 6) {
                System.out.print("Invalid option! Please enter a number between 1 and 6: ");
                choice = input.nextInt();
            }

            switch (choice) {
                case 1:
                    displayAllResults();
                    break;

                case 2:
                    searchStudent(input);
                    break;

                case 3:
                    displayStatistics();
                    break;

                case 4:
                    displayByGrade(input);
                    break;

                case 5:
                    performanceAnalysis();
                    break;

                case 6:
                    System.out.print("Thank you for using the program!");
                    break;

                default:
                    System.out.print("\nInvalid choice. Please try again.");
                    break;


            }
        } while (choice != 6);
        input.close();
    }


    //Question 1
    private static int inputNumberOfStudents(Scanner input) {
        int numStudents;

        do {
            System.out.print("Enter number of students (5-30): ");
            numStudents = input.nextInt();

            if (numStudents < 5 || numStudents > 30) {
                System.out.println("Invalid number. Please enter between 5 and 30.");

            }

        } while (numStudents < 5 || numStudents > 30);
        return numStudents;

    }

    //Question 2
    private static void inputStudentData(Scanner input) {
        for (int i = 0; i < numStudents; i++) {

            System.out.print("Student " + ( i+ 1));
            //Student ID
            System.out.print("\nStudent ID: ");
            studentIDs[i] = input.next();

            //Student Name
            input.nextLine();
            System.out.print("Student Name: ");
            studentNames[i] = input.nextLine();

            //Test Mark
            do {
                System.out.print("Test mark (0-30): ");
                testMarks[i] = input.nextInt();

                if (testMarks[i] < 0 || testMarks[i] > 30) {
                    System.out.println("Invalid mark entered. Please enter a mark between 0 and 30.");
                }

            } while (testMarks[i] < 0 || testMarks[i] > 30);


            //Lab Mark
            do {
                System.out.print("Lab mark (0-30): ");
                labMarks[i] = input.nextInt();

                if (labMarks[i] < 0 || labMarks[i] > 30) {
                    System.out.println("Invalid mark entered. Please enter a mark between 0 and 30.");
                }

            } while (labMarks[i] < 0 || labMarks[i] > 30);


            //Assignment Mark
            do {
                System.out.print("Assignment mark (0-40): ");
                assignmentMarks[i] = input.nextInt();

                if (assignmentMarks[i] < 0 || assignmentMarks[i] > 40) {
                    System.out.println("Invalid mark entered. Please enter a mark between 0 and 40.");
                }

            } while (assignmentMarks[i] < 0 || assignmentMarks[i] > 40);

            overallMarks[i] = calculateOverallMark(testMarks[i], labMarks[i], assignmentMarks[i]);
            grades[i] = determineGrade(overallMarks[i]);

            System.out.println("Overall Mark: " + overallMarks[i] + " | Grade: " + grades[i]);

        }

        System.out.println("\nAll student data has been entered successfully.");

    }

    //Question 3
    private static int calculateOverallMark(int test, int lab, int assignment) {
        return test + lab + assignment;
    }


    //Question 3
    private static String determineGrade(int overall) {

        if (overall >= 85) {
            return "A+";
        } else if (overall >= 75) {
            return "A";
        } else if (overall >= 70) {
            return "B+";
        } else if (overall >= 65) {
            return "B";
        } else if (overall >= 60) {
            return "C+";
        } else if (overall >= 55) {
            return "C";
        } else if (overall >= 50) {
            return "D+";
        } else if (overall >= 45) {
            return "D";
        } else if (overall >= 40) {
            return "E";
        } else
            return "F";
    }





//Question 4
private static void displayMenu() {
    System.out.print("\nSTUDENT ASSESSMENT ANALYZER\n");
    System.out.print("1. Display All Student Results\n");
    System.out.print("2. Search for a Student\n");
    System.out.print("3. Display Class Statistics\n");
    System.out.print("4. Display Students by Grade\n");
    System.out.print("5. Performance Analysis\n");
    System.out.print("6. Exit\n");

    System.out.print("\nPlease enter an option (integer only): ");

}

//Question 5
private static void displayAllResults() {
    System.out.println("\nALL STUDENT RESULTS");

    System.out.printf("%-12s %-20s %-8s %-8s %-12s %-8s %-6s%n",
            "Student ID", "Student Name", "Test", "Lab",
            "Assignment", "Overall", "Grade");

    for (int i = 0; i < numStudents; i++) {
        System.out.printf("%-12s %-20s %-8d %-8d %-12d %-8d %-6s%n",
                studentIDs[i],
                studentNames[i],
                testMarks[i],
                labMarks[i],
                assignmentMarks[i],
                overallMarks[i],
                grades[i]);
    }
}

//Question 6
private static void searchStudent(Scanner input) {
    System.out.print("\nEnter Student ID to search: ");
    String searchID = input.next();

    boolean found = false;

    for (int i = 0; i < numStudents; i++) {
        if (studentIDs[i].equalsIgnoreCase(searchID)) {
            System.out.println("\nSTUDENT FOUND");
            System.out.println("Student ID      : " + studentIDs[i]);
            System.out.println("Student Name    : " + studentNames[i]);
            System.out.println("Test Mark       : " + testMarks[i]);
            System.out.println("Lab Mark        : " + labMarks[i]);
            System.out.println("Assignment Mark : " + assignmentMarks[i]);
            System.out.println("Overall Mark    : " + overallMarks[i]);
            System.out.println("Grade           : " + grades[i]);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student ID not found.");
    }
}


//Question 7
private static void displayStatistics() {
    double avg = calculateAverage(overallMarks);
    int highestMark = findHighest(overallMarks);
    int lowestMark = findLowest(overallMarks);

    int passCount = 0;
    int failCount = 0;

    // Grade distribution for: A+, A, B+, B, C+, C, D+, D, E, F
    int[] gradeCounts = new int[10];
    String[] gradeLabels = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "E", "F"};

    for (int i = 0; i < numStudents; i++) {
        // Count pass and fail
        if (overallMarks[i] >= 40) {
            passCount++;
        } else {
            failCount++;
        }

        // Count grade distribution by comparing with gradeLabels
        for (int j = 0; j < gradeLabels.length; j++) {
            if (grades[i].equals(gradeLabels[j])) {
                gradeCounts[j]++;
                break;
            }
        }
    }

    System.out.println("\nCLASS STATISTICS");
    System.out.printf("Class Average: %.2f\n", avg);
    System.out.println("Highest Mark : " + overallMarks[highestMark] + " - " + studentNames[highestMark]);
    System.out.println("Lowest Mark  : " + overallMarks[lowestMark] + " - " + studentNames[lowestMark]);
    System.out.println("Pass : " + passCount);
    System.out.println("Fail : " + failCount);

    // Display grade distribution (how many students get that grade)
    System.out.println("\nGrade Distribution:");
    for (int i = 0; i < gradeLabels.length; i++) {
        System.out.println(gradeLabels[i] + " : " + gradeCounts[i]);
    }
}

//method to calculate average of an array
private static double calculateAverage(int[] marks) {
    int sum = 0;
    double avg = 0;
    for (int i = 0; i < marks.length; i++) {
        sum += marks[i];
    }
    avg = (double) sum / marks.length;
    return avg;
}

// Finds index of highest mark in an array
private static int findHighest(int[] marks) {
    int maxIndex = 0;
    for (int i = 1; i < marks.length; i++) {
        if (marks[maxIndex] < marks[i]) {
            maxIndex = i;
        }
    }
    return maxIndex;
}

// Finds index of lowest mark in an array
private static int findLowest(int[] marks) {
    int minIndex = 0;
    for (int i = 1; i < marks.length; i++) {
        if (marks[minIndex] > marks[i]) {
            minIndex = i;
        }
    }
    return minIndex;
}


//Question 8 - Using Scanner input instead of Scanner scanner
private static void displayByGrade(Scanner input) {
    input.nextLine(); // consume newline
    System.out.print("Enter grade (A+, A, B+, B, C+, C, D+, D, E, F): ");
    String targetGrade = input.nextLine().trim();

    // Validate the grade input
    String[] validGrades = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "E", "F"};
    boolean isValidGrade = false;
    for (int i = 0; i < validGrades.length; i++) {
        if (targetGrade.equals(validGrades[i])) {
            isValidGrade = true;
            break;
        }
    }

    if (!isValidGrade) {
        System.out.println("Invalid grade! Please enter one of: A+, A, B+, B, C+, C, D+, D, E, F");
        return;
    }

    boolean found = false;
    System.out.println("\nStudents with grade " + targetGrade + ":");
    System.out.println("ID\t\tName\t\tOverall");

    for (int i = 0; i < numStudents; i++) {
        // Compare using .equals() for String comparison
        if (grades[i].equals(targetGrade)) {
            System.out.println(studentIDs[i] + "\t" + studentNames[i] + "\t" + overallMarks[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No students found with grade " + targetGrade);
    }
}


//Question 9
private static void performanceAnalysis() {
    double avgTest = calculateAverage(testMarks);
    double avgLab = calculateAverage(labMarks);
    double avgAssignment = calculateAverage(assignmentMarks);
    double classAvg = calculateAverage(overallMarks);

    int above = 0;
    int equal = 0;
    int below = 0;


    for (int i = 0; i < numStudents; i++) {
        if (overallMarks[i] > classAvg) {
            above++;
        } else if (overallMarks[i] == classAvg) {
            equal++;
        } else {
            below++;
        }
    }

    System.out.println("\nPERFORMANCE ANALYSIS");
    System.out.printf("Average Test mark: %.2f\n", avgTest);
    System.out.printf("Average Lab mark: %.2f\n", avgLab);
    System.out.printf("Average Assignment mark: %.2f\n", avgAssignment);
    System.out.println("\nComparison with Class Average (" + String.format("%.2f", classAvg) + "):");
    System.out.println("Number of students above class average: " + above);
    System.out.println("Number of students equal to class average: " + equal);
    System.out.println("Number of students below class average: " + below);
    }
}

