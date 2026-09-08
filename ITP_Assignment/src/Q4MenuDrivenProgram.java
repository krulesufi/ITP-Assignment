import java.util.Scanner;

public class Q4MenuDrivenProgram {
    public static void main(String[] args){


        //just replace the System.out.print to whatever you need in your question.

        Scanner obj = new Scanner(System.in);

        int choice;

        System.out.print("\nSTUDENT ASSESSMENT ANALYZER\n");
        System.out.print("1. Display All Student Results\n");
        System.out.print("2. Search for a Student\n");
        System.out.print("3. Display Class Statistics\n");
        System.out.print("4. Display Students by Grade\n");
        System.out.print("5. Performance Analysis\n");
        System.out.print("6. Exit\n");

        System.out.print("\nPlease enter an option (integer only): ");
        choice = obj.nextInt();



        //just replace the System.out.print to whatever you need in your question.

        switch (choice){
            case 1:
                System.out.print("\n1");
                break;

            case 2:
                System.out.print("\n2");
                break;

            case 3:
                System.out.print("\n3");
                break;

            case 4:
                System.out.print("\n4");
                break;

            case 5:
                System.out.print("\n5");
                break;

            case 6:
                System.out.print("\n6");
                break;

            default:
                System.out.print("\nInvalid choice. Please try again.");
                break;

        }


        while(choice != 6){
            System.out.print("\nSTUDENT ASSESSMENT ANALYZER\n");
            System.out.print("1. Display All Student Results\n");
            System.out.print("2. Search for a Student\n");
            System.out.print("3. Display Class Statistics\n");
            System.out.print("4. Display Students by Grade\n");
            System.out.print("5. Performance Analysis\n");
            System.out.print("6. Exit\n");

            System.out.print("\nPlease enter an option(integer only): ");
            choice = obj.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("\n1");
                    break;

                case 2:
                    System.out.print("\n2");
                    break;

                case 3:
                    System.out.print("\n3");
                    break;

                case 4:
                    System.out.print("\n4");
                    break;

                case 5:
                    System.out.print("\n5");
                    break;

                case 6:
                    break;

                default:
                    System.out.print("\nInvalid choice. Please try again.\n");
                    break;


            }

        }

        obj.close();

    }
}
