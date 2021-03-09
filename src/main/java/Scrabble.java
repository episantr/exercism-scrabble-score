import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Scrabble {

    private final String word;

    private static final Map<Integer, String> valueLetterMap = new HashMap<>();

    public Scrabble(String word) {
        this.word = word;
        populateValueLetterMap();
    }

    private void populateValueLetterMap() {
        for (POINTS value : POINTS.values()) {
            Integer points = Integer.parseInt(value.name().substring(2));
            String letters = value.getLetters();
            valueLetterMap.put(points, letters);
        }
    }

    int getScore() {

        int score = 0;
        char[] letters = word.toUpperCase(Locale.ENGLISH).toCharArray();

        for (char letter : letters) {
            score += valueLetterMap.entrySet().stream()
                    .filter(entry -> entry.getValue().indexOf(letter) != -1)
                    .mapToInt(Map.Entry::getKey).sum();
        }

        return score;
    }

    private enum POINTS {
        P_1("AEIOULNRST"),
        P_2("DG"),
        P_3("BCMP"),
        P_4("FHVWY"),
        P_5("K"),
        P_8("JX"),
        P_10("QZ");

        private String letters;

        POINTS(String letters) {
            this.letters = letters;
        }

        public String getLetters() {
            return letters;
        }
    }
}
