import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String str = "";
        try {
            System.out.println("Enter a string to find all possible English words: ");
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dictionary dict = new Dictionary(new WebAPI());
        for (String word : removeDuplicates(getAllPossibleStringComb(str))) {
            if (dict.isEnglishWord(word))
                System.out.println(word);
        }
    }

    static ArrayList<String> getAllPossibleStringComb(String s) {
        ArrayList<String> combString = new ArrayList<String>();
        ArrayList<String> permutedString = new ArrayList<String>();
        getCombinationString("", s, combString);
        for (String str : combString) {
            getPermutedString("", str, permutedString);
        }
        return permutedString;
    }

    static void getCombinationString(String prefix, String s, ArrayList<String> strArray) {
        int N = s.length();
        strArray.add(prefix);
        for (int i = 0; i < N; i++)
            getCombinationString(prefix + s.charAt(i), s.substring(i + 1), strArray);
    }

    static void getPermutedString(String prefix, String s, ArrayList<String> strArray) {
        int N = s.length();
        if (N == 0) {
            strArray.add(prefix);
        }
        for (int i = 0; i < N; i++)
            getPermutedString(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N), strArray);
    }
    static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        ArrayList<T> newList = new ArrayList<T>();

        for (T element : list) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
        return newList;
    }
}
