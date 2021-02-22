import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Scrabble {

    private final String word;

    private static final String ONE_POINT_LETTERS = "AEIOULNRST";
    private static final String TWO_POINTS_LETTERS = "DG";
    private static final String THREE_POINTS_LETTERS = "BCMP";
    private static final String FOUR_POINTS_LETTERS = "FHVWY";
    private static final String FIVE_POINTS_LETTERS = "K";
    private static final String EIGHT_POINTS_LETTERS = "JX";
    private static final String TEN_POINTS_LETTERS = "QZ";

    private static final Map<Integer, String> valueLetterMap = new HashMap<>();

    public Scrabble(String word) {
        this.word = word;
        valueLetterMap.put(1, ONE_POINT_LETTERS);
        valueLetterMap.put(2, TWO_POINTS_LETTERS);
        valueLetterMap.put(3, THREE_POINTS_LETTERS);
        valueLetterMap.put(4, FOUR_POINTS_LETTERS);
        valueLetterMap.put(5, FIVE_POINTS_LETTERS);
        valueLetterMap.put(8, EIGHT_POINTS_LETTERS);
        valueLetterMap.put(10, TEN_POINTS_LETTERS);
    }

    int getScore() {

        int score = 0;
        char[] letters = word.toUpperCase(Locale.ENGLISH).toCharArray();

        for (char letter:letters) {
            score += valueLetterMap.entrySet().stream()
                    .filter(entry -> entry.getValue().indexOf(letter) != -1)
                    .mapToInt(Map.Entry::getKey).sum();
        }

        return score;
    }
}
