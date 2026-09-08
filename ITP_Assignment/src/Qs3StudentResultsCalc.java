import java.util.Scanner;

public class Qs3StudentResultsCalc {
    public static void main(String[] args){

        //don't forget to remove the results in numbers (line 24)


        double test, lab, asg, mark;

        Scanner obj = new Scanner(System.in);

        System.out.print("Please enter Test marks: ");
        test = obj.nextDouble();

        System.out.print("Please enter Lab marks: ");
        lab = obj.nextDouble();

        System.out.print("Please enter Assignment marks: ");
        asg = obj.nextDouble();

        mark = (test + lab + asg) / 3;

        System.out.println(mark);

        if (mark > 100){
            System.out.print("Invalid mark");

        }else if(mark >= 85){
            System.out.print("Grade: A+");

        }else if(mark >= 75){
            System.out.print("Grade: A");

        }else if(mark >= 70){
            System.out.print("Grade: B+");

        }else if(mark >= 65){
            System.out.print("Grade: B");

        }else if(mark >= 60){
            System.out.print("Grade: C+");

        }else if(mark >= 55){
            System.out.print("Grade: C");

        }else if(mark >= 50){
            System.out.print("Grade: D+");

        }else if(mark >= 45){
            System.out.print("Grade: D");

        }else if(mark >= 40){
            System.out.print("Grade: E");

        }else if(mark <= 39){
            System.out.print("Grade: F");

        }



        obj.close();
    }
}
