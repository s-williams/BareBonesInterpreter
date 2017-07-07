/**
 * Start
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Toolbox myToolbox = new Toolbox();


//        Creates ArrayList for all lines of Barebone code
        ArrayList<String> listOfLines = new ArrayList<String>();
        ArrayList<String> convertedLines = new ArrayList<String>();

//        Get file name and set it in reader

        System.out.println("Whats the name of the file?");
        System.out.println("e.g. Counting.txt Multiplying.txt, MultiplyingFix.txt, /NotHalting.txt, /Today2Tomorrow.txt,");
        String fileNameInput = myToolbox.readStringFromCmd();
        Reader ThisReaderReadsTheFile = new Reader(fileNameInput);


//        Find number of lines and store in reader

        System.out.println("Counting Lines...");

        int numberOfLinesTemp = ThisReaderReadsTheFile.countLines(fileNameInput);
        ThisReaderReadsTheFile.setNumberOfLines(numberOfLinesTemp);

        System.out.println("Number of lines = " + ThisReaderReadsTheFile.getNumberOfLines());
        System.out.println("Reading the file...");

//        Adds each line to its own array listOfLines

        for (int i = 0; i <= ThisReaderReadsTheFile.getNumberOfLines(); i++){
            listOfLines.add(i,ThisReaderReadsTheFile.ReadTheLine(i));
        }

        System.out.println("File has been read");
        System.out.println("Printing Line Array...");
        System.out.println(listOfLines);

        System.out.println("Converting...");

        String convertee;

//        Reads each line in listOfLines
//        Converts it to Java
//        Puts Java in its own array convertedLines

        for (int i = 0; i <=ThisReaderReadsTheFile.getNumberOfLines(); i++) {
            convertee = listOfLines.get(i);

//            Puts each section of the line into its own array
            String[] parts = convertee.split(" ");

            String inputString;

//            Consider making this all its own class
//            Checks line has any five of the five possibilities. In each case it converts it to Java
            if (Objects.equals(parts[0], "while")) {

//                If the variable in the while loop has not been previously initialised, do this, if not, do the other. If this doesnt work just use the top loop
//                if (!(convertedLines.contains(("int " + parts[1]) + " = 0; System.out.println( \" " + parts[1] + " = \" + " + parts[1] + " );"))) {

                    inputString = (("while ( " + parts[1] + " != " + parts[3]) + ") {");
                    convertedLines.add(i, inputString);

//                } else {
//
//                    inputString = (("int " + parts[1] + " = 0; while ( " + parts[1] + " != " + parts[3]) + ") {");
//                    convertedLines.add(i, inputString);
//
//                }

            } else if (Objects.equals(parts[0], "end;")) {

                inputString = "}";
                convertedLines.add(i, inputString);

            }

//            This else says that it is either clear incr or decr and so will be printed
            else {

                String variable = removeLastChar(parts[1]);

                if (Objects.equals(parts[0], "clear")) {

                    inputString = ("int " + variable + " = 0; System.out.println( \" " + variable + " = \" + " + variable + " );");
                    convertedLines.add(i, inputString);

                } else if (Objects.equals(parts[0], "incr")) {

                    inputString = (variable + " = " + variable + " + 1; System.out.println( \" " + variable + " = \" + " + variable + " );");
                    convertedLines.add(i, inputString);

                } else if (Objects.equals(parts[0], "decr")) {


                    inputString = (variable + " = " + variable + " - 1; System.out.println( \" " + variable + " = \" + " + variable + " );");
                    convertedLines.add(i, inputString);

                }
            }
        }
        System.out.println("File has been converted");
        System.out.println("Printing converted array...");
        System.out.println(convertedLines);

//        Making sure java file name is appropiate

        String newFileName = (removeLastChar(ThisReaderReadsTheFile.getFileName(), 4) + "Java.java");

        System.out.println("Named the file " + newFileName);

//        Adding the wrappers to the Java
        convertedLines.add(0,"public class " + removeLastChar(newFileName,5) + " { public static void main(String[] args) {");
        convertedLines.add("} }");

        System.out.println("Printing converted array again...");
        System.out.println(convertedLines);

        System.out.println("Saving to file");

        Writer ThisWriterWritesTheFile = new Writer();
        ThisWriterWritesTheFile.setFileName(newFileName);

//        Calls the magic method
        ThisWriterWritesTheFile.WriteTheLine(convertedLines,convertedLines.size());

        System.out.println("Done!");

//        compile and run the new program

        System.out.println("Compiling and running the program...");
        try {
            runProcess("javac " + newFileName);
            runProcess("java " + removeLastChar(newFileName, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
    private static String removeLastChar(String str, int howManyChar) {
        return str.substring(0,str.length()-howManyChar);
    }

//    These things needed to run a program inside another program
    private static void printLines(String name, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
        System.out.println(name + " " + line);
    }
}

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }
}