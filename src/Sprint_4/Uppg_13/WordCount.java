package Sprint_4.Uppg_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WordCount {

    int[] wordcount = new int[50];
    int count;
    int index;

    public WordCount() throws IOException {
        URL englishWords = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(englishWords.openStream()));
        String aWord;

        while ((aWord = in.readLine()) != null) {
            index = aWord.length();
            wordcount[index]++;
            count++;

            if(aWord.length()==45)
                System.out.println("Längsta ordet är: "+aWord);
        }
        in.close();
        printStatistics();
    }

    public void printStatistics(){
        System.out.println("Hittade totalt "+count+" st ord");
        for (int i = 0; i < wordcount.length; i++) {
            if(wordcount[i]!=0)
            System.out.println("No of Words found with "+i+" No of letters: "+wordcount[i]);
        }
    }

    public static void main(String[] args)throws IOException {
        WordCount wc = new WordCount();
    }
}

