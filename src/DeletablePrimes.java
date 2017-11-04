import java.math.BigInteger;
import java.util.Scanner;

public class DeletablePrimes {

    public static int count;

    public static void main(String[] args){
       deletablePrimes();
    }

    public static void deletablePrimes(){
        Scanner sc = new Scanner(System.in);

        System.out.print("input: ");
        String number = sc.next();

        int isDeletablePrime = countDeletablePrime(number, number.length());
        System.out.println(isDeletablePrime);
    }

    // counts ways of calculation deletable prime recursively
    public static int countDeletablePrime(String number, int lenght){
        if (lenght == 1 && isPrime(Long.parseLong(number))) {
            return count++;
        }

        for (int i = 0; i < lenght && lenght > 1; i++){
            Long removedNumber = removeNumber(number, i);
            if (isPrime(removedNumber)){
                countDeletablePrime(removedNumber.toString(), removedNumber.toString().length());
            }
        }

        return count;
    }

    //remove the given index digit in the number
    public static Long removeNumber(String number, int index){
        String convertedNumber = number.substring(0, index) + number.substring(index+1, number.length());
        Long newNumber = Long.parseLong(convertedNumber);

        return newNumber;
    }

    public static boolean isPrime(Long number){
        BigInteger n = BigInteger.valueOf(number);
        return n.isProbablePrime(10);

    /*    if (number <= 2)
            return false;

        for (int i = 2; i <= number/2; i++){
            if ( number % i == 0) {
                return false;
            }
        }
        return true;*/
    }
}
