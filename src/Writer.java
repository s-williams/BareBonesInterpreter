/**
 * Writes the file
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Writer {

    private String fileName;


    public Writer() {

    }

    //Writes a single line in the

    public void WriteTheLine(ArrayList<String> inputArrayList, int inputNumberOfLines) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream(new File(fileName));
        for (int k = 0; k < inputNumberOfLines; k++) {
            fileStream.println(inputArrayList.get(k));
        }
//        Scanner scanner = new Scanner();
//        scanner.
    }

    //setters

    public void setFileName(String setFileNameInput) {
        fileName = setFileNameInput;
    }
}
