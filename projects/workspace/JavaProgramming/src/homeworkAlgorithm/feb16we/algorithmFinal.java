package homeworkAlgorithm.feb16we;

import java.util.Scanner;

public class algorithmFinal {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      
      String[] arrayStringNumber = input.nextLine().split(", ");
      int sum = 0;
      int minNumber = 0;
      int number = 0;
      
      for(int i = 0; i<arrayStringNumber.length; i++) {
         number = Integer.parseInt(arrayStringNumber[i]);
         if(number % 2 == 1) {
            sum += number;
            if(minNumber == 0 || minNumber > number) {
               minNumber = number;
            }
         }
      }
      
      if (sum != 0) {
         System.out.println(sum);
         System.out.println(minNumber);
      } else {
         System.out.println(-1);
      }
   }

}
