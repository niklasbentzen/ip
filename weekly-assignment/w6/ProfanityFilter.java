import java.util.*;

public class ProfanityFilter {
    List<String> words;
    List<String> profanityWords;
    String marks = ",.!?";
    String[] replace = {"*","&","#","$","%"};

    public ProfanityFilter() {
        words = new ArrayList<>();
        profanityWords = new ArrayList<>();
    }

    public static void main(String[] args) {
        ProfanityFilter pF = new ProfanityFilter();
        pF.profanityScanner();
    }

    public void profanityScanner() {
        /*
        profanityScanner() scans for the first line to get all profanity words.
        Next it scan each coming line and filter() and censor() the profanity words.
        Last it prints the filtered words.
         */
        Scanner s = new Scanner(System.in);
        profanityWords = Arrays.asList(s.nextLine().toLowerCase().split(" "));

        while (s.hasNextLine()) {
            // takes each coming line
            words = Arrays.asList(s.nextLine().split(" "));
            List<String> wordsFiltered = filter(words, profanityWords);
            printLine(wordsFiltered);
        }
    }

    private List<String> filter(List<String> words, List<String> profanityWords) {
        /*
        Takes a List<> of words (the tweet) and profanityWords and find if a word is
        a profanityWord, then it censors any profanity words using censor().
        It takes into account that lastCharacter can contain punctuation marks.
         */
        ListIterator<String> itr = words.listIterator();
        while (itr.hasNext()) {
            String word = itr.next();
            if (!word.isEmpty()) {
                String lastCharacter = "";
                if (marks.contains(word.substring(word.length() - 1))) {
                    lastCharacter = word.substring(word.length() - 1);
                    word = word.substring(0, word.length() - 1);
                }
                if (profanityWords.contains(word.toLowerCase())) {
                    itr.set(censor(word) + lastCharacter);
                }
            }
        }
        return words;
    }

    private String censor(String word) {
        /*
        Takes a word. Then splits it up into each character and replaces it with
        the next censor character in order of "*&#$%".
        Returns the censored word.
         */
        List<String> characters = Arrays.asList(word.split(""));
        String censoredWord = "";
        int i = 0;
        ListIterator<String> itr = characters.listIterator();
        while (itr.hasNext()) {
            itr.next();
            censoredWord += replace[i];
            i++; if (i >= replace.length) i = 0;
        }
        return censoredWord;
    }

    private void printLine(List<String> wordsFiltered) {
        /*
        Prints the line and joins each element in the List<> by " ".
         */
        System.out.println(String.join(" ", wordsFiltered));
    }
}