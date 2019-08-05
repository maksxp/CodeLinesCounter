package kata;

import java.io.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class LineCounterInFile {
    private enum State {INSIDE_COMMENT, OUTSIDE_COMMENT}

    public static int countLinesInFile(File file) throws IOException {
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int count = 0;
        String line;
        State state = State.OUTSIDE_COMMENT;

        while ((line = bufferedReader.readLine()) != null){
            state = commentBeginning(line, state);
            count += isCountable(line, state) ? 1 : 0;
            state = commentEnding(line, state);
        }
        reader.close();
        bufferedReader.close();
        return count;
    }

    private static boolean isCountable(String line, State state) {
        return !line.trim().startsWith("//") && isNotBlank(line) && state == State.OUTSIDE_COMMENT;
    }

    private static State commentBeginning(String line, State state) {
        return line.trim().startsWith("/*") ? State.INSIDE_COMMENT : state;
    }

    private static State commentEnding(String line, State state) {
        return line.trim().contains("*/") ? State.OUTSIDE_COMMENT : state;
    }
}