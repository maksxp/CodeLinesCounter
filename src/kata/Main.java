package kata;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	System.out.println("Input file or folder name and press Enter");
	Source source = new Source();
	String pathToSource = source.getPathToSource();
	File file = new File(pathToSource);
    LineCounterInFolder lineCounterInFolder = new LineCounterInFolder();
    System.out.println(file.getName()+ " : "+ lineCounterInFolder.countLinesInFolder(file));
    }
}