import java.util.Arrays;

public class Dictionary {
    private WebAPI api;

    public Dictionary(WebAPI api) {
        this.api = api;
    }

    public boolean isEnglishWord(String word) {
        String[] englishWords = api.getEnglishWords();
        return Arrays.asList(englishWords).contains(word);
    }

}
