import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class Main1 {
    static public void main(String[] args) {

        int n = 6;
        int guessed = 0;


            try {
                Integer[] arrNum = new Integer[n];
                Scanner scan = new Scanner(System.in);

                for(int i = 0; i < arrNum.length; i++) {
                    System.out.println("Podaj typowaną liczbę");
                    arrNum[i] = scan.nextInt();
                        if (arrNum[i] > 49 || arrNum[i] < 1) {
                            System.out.println("Wpisano liczbe spoza zakresu 1-49");
                            i--;
                            }
                    for (int j = 0; j < i; j++) {
                        try {
                            if (arrNum[j] == arrNum[i]) {
                                System.out.println("Wpisano juz taka liczbe");
                                i--;
                            }
                        } catch (Exception e) {
                            System.out.println("Wpisano juz taka liczbe");
                        }

                    }
                }


                    Arrays.toString(arrNum);
                    Arrays.sort(arrNum);

                    System.out.println("Wytypowane liczby");
                    System.out.println(Arrays.toString(arrNum));

                    Integer[] arr = new Integer[49];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = i + 1;
                    }

                    Collections.shuffle(Arrays.asList(arr));

                    Arrays.toString(arr);
                    Integer[] arrNew = Arrays.copyOf(arr,6);
                    Arrays.sort(arrNew);
                    String arrDrawn = Arrays.toString(arrNew);
                System.out.println("Wylosowane liczby");
                    System.out.println(arrDrawn);

                    for(int i = 0; i < arrNum.length; i++) {
                        for(int j = 0; j < arrNew.length; j++) {
                            if(arrNum[i] == arrNew[j]) {
                            guessed++;
                            }
                        }
                    }
                    if(guessed >= 3) {
                        System.out.println("Trafiłeś conajmniej trójkę!");
                    }
                    else if(guessed == 6) {
                        System.out.println("Trafiłeś szóstkę!!!!!!!!!!!!!!!!");
                    }



//                    for (int i = 0; i < 6; i++) {
//                        wylosowane += arr[i] + " ";
//                    }
//                    System.out.println("Wylosowane liczby");
//                    System.out.println(wylosowane);

            } catch (InputMismatchException e) {
                System.out.println("Nie podano liczby");
            }


    }
}
