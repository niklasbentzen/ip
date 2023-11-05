import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepTalk {
    public PepTalk() {
    }

    public static void main(String[] args) {
        PepTalk p = new PepTalk();

        Scanner s = new Scanner(System.in);
        String[] words = s.nextLine().split(" ");
        String space = "";

        for (String word : words) {
            System.out.print(space);
            System.out.print(p.pepIt(word));
            space = " ";
        }
    }

    private String pepIt(String word) {
        // finds each vowel and puts "()" around it
        word = word.replaceAll("[aeiouAEIOU]", "($0)");

        // finds consonants between ")" and "(" and splits the consonants in half with "-"
        Pattern findConsonants = Pattern.compile("\\)([^aeiouAEIOU]+)\\(");
        Matcher m1 = findConsonants.matcher(word);

        while (m1.find()) {
            String part = m1.group(1);
            String firstPart = part.substring(0,part.length() / 2);
            String lastPart = part.substring(part.length() / 2);
            part = firstPart + "-" + lastPart;
            word = word.replace(m1.group(), ")" + part + "(");
        }

        Pattern findTwoVowels = Pattern.compile("(\\))(\\()");
        Matcher m4 = findTwoVowels.matcher(word);

        while (m4.find()) {
            word = word.replace(m4.group(), m4.group(1) + "-" + m4.group(2));
        }

        // removes "()" around vowel (not needed anymore)
        word = word.replaceAll("[()]", "");

        // duplicates each syllable and replaces the first consonant with a "p"
        String[] arr = word.split("-");

        for (int i = 0; i < arr.length; i++) {
            String pepped = arr[i];

            if (pepped.matches("^[aeiouAEIOU].*")) {
                pepped = "p" + pepped;
            }
            else if (pepped.matches("^[^aeiouAEIOU].*")) {
                Pattern findFirstConsonant = Pattern.compile("^[^aeiouAEIOU]+");
                Matcher m3 = findFirstConsonant.matcher(pepped);

                while (m3.find()) {
                    pepped = m3.replaceFirst("p");
                }
            }
            arr[i] = arr[i] + "-" + pepped.toLowerCase();
        }

        word = "";
        for (String s : arr) {
            word += s;
        }

        // replaces "-" with nothing
        word = word.replaceAll("-", "");

        return word;
    }
}