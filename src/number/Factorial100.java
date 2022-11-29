package number;

import java.math.BigInteger;

public class Factorial100 {

    //1. JAVA program segítségével számold ki és írd ki a képernyőre a 100! (száz faktoriális) értékét.
    //

    //only works with small numbers
    public static int factorial(int f){
        int fact;
        fact = 1;
        for (int i = 2; i <= f; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static BigInteger bigfactorial(int N){
 // Initialize result 
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE 
  
        // Multiply f with 2, 3, ...N 
        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    }


    public static int digitsOfFactorial(int x){
        double digits = 0;
        for (int i=2; i<=x; i++)
            digits += Math.log10(i);
        return (int)(Math.floor(digits)) + 1;
    }



    public static int[] bigFactorial(int x){
        int[] number = new int[digitsOfFactorial(x)];
        //adding 1 to arrey
        number[0] = 1;
        for (int i = 2; i <= x; i++){
            //multiply and store in arrey
            multiply(i, number, digitsOfFactorial(i));
        }
        return number;
    }

    public static void multiply(int x, int[] number, int digits){
        int carry=0;

        for (int i = 0; i < digits; i++){
            //multyply
            number[i] = number[i] * x + carry;
            //get remainder
            carry = number[i] / 10;
            //leave only last digit
            number[i] = number[i] % 10;
        }

        //add remainder
        while (carry!=0)
        {
            number[digits] = carry % 10;
            carry = carry / 10;
        }
    }

    public static void main(String[] args) {
        int[] result = bigFactorial(100);

        //Print in reverse
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }

        System.out.println();
        System.out.println (bigfactorial(100));
        
        //small factorials;
        for (int i = 1; i < 20; i++)
            System.out.println(i + "!: " +factorial(i));
    }

}
