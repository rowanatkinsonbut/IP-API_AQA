package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomFileReader {

    /**
     * Reads domains from a file located in the resources directory.
     *
     * @param fileName the name of the file to read
     * @return a list of domains read from the file
     * @throws RuntimeException if an I/O error occurs
     */
    public List<String> readDomainsFromFile(String fileName) {
        List<String> domains = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                domains.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return domains;
    }
}
