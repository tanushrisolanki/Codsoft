import java.util.*;
import java.util.Scanner;

public class Codsoft2 {
    public static void GradeCalculator(){
        float averagePerc;
        int totalSubjects;
        int totalMarks = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of subjects :");
        totalSubjects = sc.nextInt();

        for(int i = 0;i < totalSubjects;i++){
            System.out.println("Enter marks of subject"+(i+1)+":");
            totalMarks += sc.nextFloat();
        }
        sc.close();
        averagePerc = totalMarks/totalSubjects ;
        System.out.println("The Student's average percentage is : "+averagePerc) ;

        if(averagePerc >= 80){
            System.out.println("Grade of student : A");
        }else if(averagePerc >= 60 && averagePerc < 80){
            System.out.println("Grade of student : B");
        }else if(averagePerc >= 40 && averagePerc < 60){
            System.out.println("Grade of student : C");
        }else{
            System.out.println("Grade of student : D");
        }

    }
    public static void main(String args[]){
        GradeCalculator();
    }
}
