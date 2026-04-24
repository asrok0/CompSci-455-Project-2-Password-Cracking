import java.util.ArrayList;
import java.util.List;

// Generates possible passwords using the info from the social engineering
public class PasswordGenerator {

    /* Generate possible passwords for the first target
       Rules for Target 1 password:
       - 5-10 characters
       - Can only be alphanumeric
     */
    public static List<String> generateTarget1Passwords() {
        List<String> passwords = new ArrayList<>();

        // Info form social engineering
        String[] words = {"Sarah", "Tom", "Emma", "Noah", "Yellow", "Aurora", "Teacher"};
        String[] numbers = {"87", "1987", "85", "2015", "2018", "18"};

        // Generate combos
        for (String word : words) {
            passwords.add(word);

            for (String num : numbers) {
                passwords.add(word + num);
                passwords.add(num + word);
            }
        }

        // Possible manual guesses
        passwords.add("Emma2015");
        passwords.add("Noah2018");
        passwords.add("Yellow87");
        passwords.add("Sarah87");
        passwords.add("Tom1985");
        passwords.add("Emma18");

        // Remove generated passwords that are outside the length restriction
        passwords.removeIf(p -> p.length() < 5 || p.length() > 10);

        return passwords;
    }


    /* Generate possible passwords for the second target
       Rules for Target 2 password:
       - 12-18 characters
       - Uppercase required
       - Lowercase required
       - Number required
     */
    public static List<String> generateTarget2Passwords() {
        List<String> passwords = new ArrayList<>();

        // Info from social engineering (some possibilities based around football and Wisconsin)
        String[] words = {"Badgers", "Packers", "CampRandall", "BigTen", "Madison", "Football", "Wisco", "BadgerBowl", "Nintendo"};
        String[] numbers = {"1990", "2024", "22", "1", "90"};

        for (String word : words) {
            for (String num : numbers) {
                passwords.add(word + num);
                passwords.add(num + word);
                passwords.add("Go" + word + num);
                passwords.add(word + "Go" + num);
            }
        }

        // Remove generated passwords that are outside the length restriction
        passwords.removeIf(p -> p.length() < 12 || p.length() > 18);

        return passwords;
    }
}