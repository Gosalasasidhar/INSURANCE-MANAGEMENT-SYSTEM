package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String propertyFileName) {
        Properties properties = new Properties();
        FileInputStream input = null;

        try {
            // Load the properties from the file
            input = new FileInputStream(propertyFileName);
            properties.load(input);

            // Construct the connection string
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            return url + "?user=" + username + "&password=" + password;
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null; // Return null in case of an error
        } finally {
            // Close the input stream
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
            }
        }
    }
}
