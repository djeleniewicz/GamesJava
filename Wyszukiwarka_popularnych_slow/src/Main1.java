import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main1 {

    static public void main(String[] args) {

        String[] ignoreElements = {"ponieważ ", "oraz "};

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        Connection connect2 = Jsoup.connect("http://www.interia.pl/");
        Connection connect3 = Jsoup.connect("http://www.wp.pl/");


        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            Document document2 = connect2.get();
            Elements links2 = document2.select("a.news-a");
//            Document document3 = connect3.get();
//            Elements links3 = document3.select("span.title");

            FileWriter file = new FileWriter("popular_words.txt", false);
            for (Element elem : links) {
                file.append(elem.text() + "\n");
            }
            for (Element elem : links2) {
                file.append(elem.text() + "\n");
            }
//            for (Element elem : links3) {
//                plik.append(elem.text() + "\n");
//            }
            file.close();

            String tokens = "";


            FileReader file1 = new FileReader("popular_words.txt");
            FileWriter file3 = new FileWriter("filtered_popular_words.txt", false);

            String line = "";


            Scanner scan = new Scanner(file1);

                while (scan.hasNextLine()) {
                    String end = "";
                    line = scan.nextLine();
                    StringTokenizer strToken = new StringTokenizer(line, ",. ");
                        while (strToken.hasMoreTokens()) {
                            tokens = strToken.nextToken();
                            if(tokens.length() < 4) {
                                tokens = "";
                            } else {
                            for (int i = 0; i < ignoreElements.length; i++) {
                                if (tokens.equalsIgnoreCase(ignoreElements[i])) {
                                    tokens = "";
                                }
                            }
                            }
                            end += tokens + " ";
                        }

                        file3.append(end + "\n");
                    }
            file3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }


    }
}
