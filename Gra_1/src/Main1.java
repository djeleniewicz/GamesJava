import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    static public void main(String[] args) {

        int number1 = 0;
        for(int i = 0; ; i++) {
            try {
                System.out.println("Zgadnij liczbę");
                Scanner scan = new Scanner(System.in);
                number1 = scan.nextInt();
                Random rand = new Random();
                int random = rand.nextInt(100)+1;
                System.out.println(random);

                if(number1 < random) {
                    System.out.println("Za mało!");
                }
                else if(number1 > random) {
                    System.out.println("Za dużo!");
                }
                else {
                    System.out.println("Zgadłeś!");
                    break;
                }



            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba");
            }

        }
    }

}
