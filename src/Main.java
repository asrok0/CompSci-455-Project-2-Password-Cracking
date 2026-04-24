import java.util.List;
import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) {

        // Stolen hashes
        String target1Hash = "a1337405aa016df43663b2853bffc091";
        String target2Hash = "eb20c9abc2e597b1e03c6200cfe1de08";

        RainbowTable rainbowTable = new RainbowTable();
        int totalPasswords = 0;
        long startTime = System.currentTimeMillis();

        // Generate possible passwords for first target
        List<String> target1Passwords = PasswordGenerator.generateTarget1Passwords();

        for (String password : target1Passwords) {
            rainbowTable.addPassword(password);
            totalPasswords++;
        }

        // Generate possible passwords for second target
        List<String> target2Passwords = PasswordGenerator.generateTarget2Passwords();

        for (String password : target2Passwords) {
            rainbowTable.addPassword(password);
            totalPasswords++;
        }

        // Get CSV version of rainbow table
        rainbowTable.exportCSV("rainbow_table.csv");

        // Crack hashes
        String target1Cracked = rainbowTable.crackHash(target1Hash);
        String target2Cracked = rainbowTable.crackHash(target2Hash);

        long endTime = System.currentTimeMillis();

        // Results
        System.out.println("--------------------");
        System.out.println("RESULTS");
        System.out.println("--------------------");

        if (target1Cracked != null) {
            String generatedHash = MD5Util.md5(target1Cracked);

            System.out.println("Password found for Target 1: " + target1Cracked);
            System.out.println("Known hash: " + target1Hash);
            System.out.println("Generated has: " + generatedHash + "\n");
        }
        else {
            System.out.println("No password found for Target 1!\n");
        }

        if (target2Cracked != null) {
            String generatedHash = MD5Util.md5(target2Cracked);

            System.out.println("Password found for Target 2: " + target2Cracked);
            System.out.println("Known hash: " + target2Hash);
            System.out.println("Generated hash: " + generatedHash + "\n");
        }
        else {
            System.out.println("No password found for Target 2!\n");
        }

        System.out.println("Passwords Tested: " + totalPasswords);
        System.out.println("Runtime: " + (endTime - startTime) + "ms");
    }
}