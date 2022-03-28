package homework.feb15th;

import java.util.Scanner;
public class Algorithm01 {

   public static void main(String[] args) {
      
      Scanner inputAppleNumScanner = new Scanner(System.in);
      Scanner inputScoresScanner = new Scanner(System.in);
      Scanner inputCylinderScanner1 = new Scanner(System.in);
      Scanner inputCylinderScanner2 = new Scanner(System.in);
      
      int appleNum = inputAppleNumScanner.nextInt();
      String inputScores = inputScoresScanner.nextLine();
      String strCylinder1 = inputCylinderScanner1.nextLine();
      String strCylinder2 = inputCylinderScanner2.nextLine();
      
      String[] scoreArray = inputScores.split(" ");
      String[] cylinderArray1 = strCylinder1.split("");
      String[] cylinderArray2 = strCylinder2.split("");
      
      int sum = 0;
      for(int i=0; i<appleNum; i++) {
         if(cylinderArray1[i].equalsIgnoreCase("O") && cylinderArray2[i].equalsIgnoreCase("O")) {
            sum += Integer.parseInt(scoreArray[i]);
         }
      }
      
      System.out.println("총 점수: " + sum);
   }

}