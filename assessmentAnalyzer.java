public class assessmentAnalyzer{
    public static void main(String[] args){
        System.out.print("Hello, world)");
        

    }
}

/*
VARIABLES USED FROM PREVIOUS QUESTIONS:
- numStudents     : From Question 1
- studentNames[]  : From Question 2
- grades[]        : From Question 3
- overallMarks[]  : From Question 3
*/

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
    for (int i = 0; i < marks.length; i++) {
        sum += marks[i];
    }
    return (double) sum / marks.length;
}

// Finds index of highest mark in an array
private static int findHighest(int[] marks) {
    int maxIndex = 0;
    for (int i = 1; i < marks.length; i++) {
        if (marks[i] > marks[maxIndex]) {
            maxIndex = i;
        }
    }
    return maxIndex;
}

// Finds index of lowest mark in an array
private static int findLowest(int[] marks) {
    int minIndex = 0;
    for (int i = 1; i < marks.length; i++) {
        if (marks[i] < marks[minIndex]) {
            minIndex = i;
        }
    }
    return minIndex;
}

/*
VARIABLES USED FROM PREVIOUS QUESTIONS:
- grades[]        : From Question 3 
- studentIDs[]    : From Question 2 
- studentNames[]  : From Question 2 
- overallMarks[]  : From Question 3 
- numStudents     : From Question 1
*/

//Question 8 - Using Scanner input instead of Scanner scanner
private static void displayByGrade(Scanner input) {  // Changed from scanner to input
    input.nextLine(); // consume newline
    System.out.print("Enter grade (A+, A, B+, B, C+, C, D+, D, E, F): ");
    String targetGrade = input.nextLine().trim();  // Changed scanner to input
    
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


/* VARIABLES USED FROM PREVIOUS QUESTIONS:
- testMarks[]        : From Question 2 
- labMarks[]         : From Question 2 
- assignmentMarks[]  : From Question 2
- overallMarks[]     : From Question 3 
- numStudents        : From Question 1
 */

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
