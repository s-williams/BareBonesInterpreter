/**
 * Reads the file
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Reader {
    private String fileName = null;
    private int numberOfLines;


//    Constructor
    public Reader(String fileInput) {
        fileName = fileInput;
    }



    public String ReadTheLine(int lineNumber) throws IOException {

        String Line = Files.readAllLines(Paths.get(fileName)).get(lineNumber);
        return Line;

    }


//    Counts the number of Lines in the file

    public int countLines(String fileName) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(fileName));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

//    Setters

    public void setNumberOfLines(int setNumberOfLinesInput) {
        numberOfLines = setNumberOfLinesInput;
    }

    public void setFileName(String setFileNameInput) {
        fileName = setFileNameInput;
    }

//    Getters

    public int getNumberOfLines() {
        return numberOfLines;
    }
    public String getFileName() {
        return fileName;
    }

}