package kata;

import java.io.File;
import java.io.IOException;

public class PrettyPrinter {

   public static String printDirectoryTree(File folder) throws IOException {
        if (!folder.isDirectory()&&folder.exists()) {
            return folder.getName()+" : "+LineCounterInFile.countLinesInFile(folder);
         } else {
            int indent = 0;
            StringBuilder sb = new StringBuilder();
            printDirectoryTree(folder, indent, sb);
            return sb.toString();
        }
    }

    private static void printDirectoryTree(File folder, int indent,
                                           StringBuilder sb) throws IOException {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("please enter correct address and name of file or folder");
        } else {
        LineCounterInFolder lineCounterInFolder = new LineCounterInFolder();
        sb.append(getIndentString(indent));
        sb.append("  ");
        sb.append(folder.getName() + " : " + lineCounterInFolder.countLinesInFolder(folder));
        sb.append("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }
    }
    }

    private static void printFile(File file, int indent, StringBuilder sb) throws IOException {
        LineCounterInFile LineCounterInFile = new LineCounterInFile();
        sb.append(getIndentString(indent));
        sb.append("  ");
        sb.append(file.getName()+" : "+LineCounterInFile.countLinesInFile(file));
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}