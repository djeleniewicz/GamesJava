import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class Main1 {

    static public void main(String[] args) {


    throwDice("6D6");


    }

    static String[] throwDice(String throwDice) {

        int numberOfThrow = 0;
        int numberWhatDice = 0;
        int numberCorrection = 0;
        int throwedResult = 0;
        int resultThrowedResult = 0;
        int afterCorrect = 0;

        String[] numbersThrow = throwDice.split("D");

        if(throwDice.indexOf("D") == 0) {
            numberOfThrow = 1;
        }
        else {
            numberOfThrow = Integer.parseInt(numbersThrow[0]);
        }

        if(throwDice.contains("+")) {
            String[] correction = throwDice.split("\\+");
            numberCorrection = Integer.parseInt(correction[1]);
            System.out.println("Korekcja wynosi z dodawaniem: " + numberCorrection);
            String[] whatDice = numbersThrow[1].split("\\+");
            numberWhatDice = Integer.parseInt(whatDice[0]);
            System.out.println("Rzucamy kostką " + numberWhatDice + "-ścienną");

            for (int i = 0; i < numberOfThrow; i++) {
                Random rand = new Random();
                throwedResult = rand.nextInt(numberWhatDice) + 1;
                System.out.println("Wylosowano: " + throwedResult);
                resultThrowedResult += throwedResult;
            }
            System.out.println("Suma wyrzuconych oczek: " + resultThrowedResult);
            afterCorrect = resultThrowedResult + numberCorrection;
            System.out.println("Suma z korektą: " + afterCorrect);

        } else if (throwDice.contains("-")) {
            String[] correction = throwDice.split("-");
            numberCorrection = Integer.parseInt(correction[1]);
            System.out.println("Korekcja z odejmowaniem wynosi: " + correction[1]);

            String[] whatDice = numbersThrow[1].split("-");
            numberWhatDice = Integer.parseInt(whatDice[0]);
            System.out.println("Rzucamy kostką " + numberWhatDice + "-ścienną");

            for (int i = 0; i < numberOfThrow; i++) {
                Random rand = new Random();
                throwedResult = rand.nextInt(numberWhatDice) + 1;
                System.out.println("Wylosowano: " + throwedResult);
                resultThrowedResult += throwedResult;
            }

            System.out.println("Suma wyrzuconych oczek: " + resultThrowedResult);
            afterCorrect = resultThrowedResult - numberCorrection;
            System.out.println("Suma z korektą: " + afterCorrect);
        } else {
            String whatDice = numbersThrow[1];
            numberWhatDice = Integer.parseInt(whatDice);
            System.out.println("Rzucamy kostką " + numberWhatDice + "-ścienną");

            for (int i = 0; i < numberOfThrow; i++) {
                Random rand = new Random();
                throwedResult = rand.nextInt(numberWhatDice) + 1;
                System.out.println("Wylosowano: " + throwedResult);
                resultThrowedResult += throwedResult;
            }
            System.out.println("Suma wyrzuconych oczek: " + resultThrowedResult);
        }

        return numbersThrow;

    }

}
