package test;

import kata.LineCounterInFile;
import kata.LineCounterInFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// all files for tests should be located at d:\CodeLinesCounterTestFiles\
class LineCounterInFileTest {

    @org.junit.jupiter.api.Test
    void countLinesInEmptyFile() throws IOException {
        File emptyFile = new File("d:\\CodeLinesCounterTestFiles\\empty.java");
      int linesInEmptyFile = LineCounterInFile.countLinesInFile(emptyFile);
      assertEquals(0, linesInEmptyFile,"should be created an empty file \"empty.java\"");
    }
    @org.junit.jupiter.api.Test
    void countLinesInFileWithoutComments() throws IOException {
        File fileWithoutCommentsAndOneString = new File("d:\\CodeLinesCounterTestFiles\\fileWithoutCommentsAndOneString.java");
        File fileWithoutCommentsAndTwoStrings = new File("d:\\CodeLinesCounterTestFiles\\fileWithoutCommentsAndTwoStrings.java");
        File fileWithoutCommentsAndThreeStrings = new File("d:\\CodeLinesCounterTestFiles\\fileWithoutCommentsAndThreeStrings.java");
        int linesInfileWithoutCommentsAndOneString = LineCounterInFile.countLinesInFile(fileWithoutCommentsAndOneString);
        int linesInfileWithoutCommentsAndTwoStrings = LineCounterInFile.countLinesInFile(fileWithoutCommentsAndTwoStrings);
        int linesInfileWithoutCommentsAndThreeStrings = LineCounterInFile.countLinesInFile(fileWithoutCommentsAndThreeStrings);
        assertAll(
                () ->    assertEquals(1,linesInfileWithoutCommentsAndOneString, "check if \"fileWithoutCommentsAndOneString.java\" is correct and exist"),
                () ->    assertEquals(2,linesInfileWithoutCommentsAndTwoStrings, "check if \"fileWithoutCommentsAndTwoStrings.java\" is correct and exist"),
                () ->    assertEquals(3,linesInfileWithoutCommentsAndThreeStrings, "check if \"fileWithoutCommentsAndThreeStrings.java\" is correct and exist")
        );
    }

    @org.junit.jupiter.api.Test
    void countLinesInFileWithAllPossibleTypesOfComments() throws IOException {
        File fileWithAllPossibleTypesOfComments = new File("d:\\CodeLinesCounterTestFiles\\fileWithAllPossibleTypesOfComments.java");
        int linesInFileWithAllPossibleTypesOfComments = LineCounterInFile.countLinesInFile(fileWithAllPossibleTypesOfComments);
        // one line in tested file will be with comment inside this line
        assertEquals(1, linesInFileWithAllPossibleTypesOfComments,"should be created a file \"fileWithAllPossibleTypesOfComments.java\"");
    }
    @org.junit.jupiter.api.Test
    void countLinesInSubfolders() throws IOException {
        File folderWithSubfolders = new File("d:\\CodeLinesCounterTestFiles\\folderWithSubfolders");
        int linesInfolderWithSubfolders = LineCounterInFolder.countLinesInFolder(folderWithSubfolders);
        // root folder (folderWithSubfolders in our case) should contain: subfolder1, subfolder2 and two files with one code line in each file
        // both subfolder1 and subfolder2 should contain: subSubfolder1, subSubfolder2 and two files with one code line in each file
        // both subSubfolder1 and subSubfolder2 should contain: two files with one code line in each file
        assertEquals(14, linesInfolderWithSubfolders,"should be created a file \"fileWithAllPossibleTypesOfComments.java\"");
    }
}