import java.util.Scanner;

public class Main1 {

    static public void main(String[] args) {


        System.out.println("Wymyśl liczbę od 0 do 1000 a ja zgadnę ją w max 10 próbach, wpisz ok aby rozpocząć");

        int min = 0;
        int max = 1000;
        int attemps = 10;
        int guess = 0;

        String answer = "";

        System.out.println("Wpisz za dużo - gdy liczba jest za duża");
        System.out.println("Wpisz za mało - gdy liczba jest za mała");
        System.out.println("Wpisz za zgadłeś - gdy zgadłem liczbę");

        Scanner scan2 = new Scanner(System.in);
        if (scan2.nextLine().equalsIgnoreCase("ok")) {

            for (int i = 0; i <= attemps+2; i++) {

                if(i == 10) {
                    System.out.println("Nie oszukuj");
                    System.out.println("Zgaduje: " + guess);
                    break;
                }else {
                guess = ((max - min) / 2) + min;
                System.out.println("Zgaduje: " + guess);
                Scanner scan = new Scanner(System.in);
                answer = scan.nextLine();
                if (answer.equalsIgnoreCase("zgadłeś")) {
                    System.out.println("Wygrałem!!!!!!");
                    break;
                }else if (answer.equalsIgnoreCase("za dużo")) {
                    max = guess;
                } else if (answer.equalsIgnoreCase("za mało")) {
                    min = guess;
                }
                else{
                        i--;
                    }
                }
            }
        }
    }
}
