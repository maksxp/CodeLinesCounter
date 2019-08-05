package kata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Source {

    private String pathToSource;

   public String getPathToSource() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathToSource = bufferedReader.readLine();
        bufferedReader.close();
        return pathToSource;
    }
}
