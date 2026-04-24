import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Stores password and hash mappings, can be viewed as a simplified rainbow table
public class RainbowTable {

    // Map hash to plaintext
    private Map<String, String> table = new HashMap<>();

    // Adds a password and its hash to the rainbow table
    public void addPassword(String password) {
        String hash = MD5Util.md5(password);
        table.put(hash, password);
    }


    // Tries to crack a given hash by looking it up in the rainbow table
    public String crackHash(String hash) {
        return table.get(hash);
    }


    // Puts the rainbow table created in a CSV
    public void exportCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Password, Hash");

            for (Map.Entry<String, String> entry : table.entrySet()) {
                String hash = entry.getKey();
                String password = entry.getValue();
                writer.write(password + "," + hash + "");
            }

            System.out.println("Rainbow table exported to " + filename + "\n");
        }
        catch (IOException e) {
            System.out.println("Error writing CSV file.\n");
            e.printStackTrace();
        }
    }
}