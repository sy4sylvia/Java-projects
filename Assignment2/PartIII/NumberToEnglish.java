import java.util.Scanner;

public class NumberToEnglish {
        public static String numberToEnglish(int num) {
                if (num == 0) return "zero";
                else if (num > 0) return helper(num);
                else return "negative " + helper(num * (-1));
        }

        private static String helper(int num) {
                String result = new String();
                String[] oneDigit = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
                String[] twoDigits = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
                String[] plusTens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

                if (num < 10) result = oneDigit[num];
                else if (num < 20) result = twoDigits[num % 10];
                else if (num < 100) result = plusTens[num / 10] +" " + helper(num % 10);
                else if (num < 1000) result = oneDigit[num / 100] + " hundred " +  helper(num % 100);
                else if (num < 1000000) result = helper(num / 1000) + " thousand " +  helper(num % 1000);
                else  result = helper(num / 1000000) + " million " +  helper(num % 1000000);
                return result;
        }
        
        public static void main(String[] args) {
                
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a number: " );
                
                int number = in.nextInt();
                
                System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number));
        
        }
}
