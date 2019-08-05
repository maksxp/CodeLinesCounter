package kata;

import java.io.File;
import java.io.IOException;

import static kata.LineCounterInFile.countLinesInFile;

public class LineCounterInFolder {

    public static int countLinesInFolder(File file) throws IOException {
        int numberOfLines = 0;
        File[] arrayOfFiles;
        if (file.isDirectory()) {
            arrayOfFiles = file.listFiles();
            for (File f : arrayOfFiles) {
                if (f.isFile()) {
                    numberOfLines = numberOfLines + countLinesInFile(f);
                }
                else {
                    numberOfLines = numberOfLines + countLinesInFolder(f);
                }
            }
        }
        return numberOfLines;
    }
}