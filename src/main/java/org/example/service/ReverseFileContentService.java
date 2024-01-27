package org.example.service;

import org.example.utility.LoadParametersUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Logger;

public class ReverseFileContentService {
    private static final Logger logger = Logger.getLogger(ReverseFileContentService.class.getName());
    public static final String INPUTFILE = "inputfile";
    public static final String OUTPUTFILE = "outputfile";

    public void reverseFileContent() {
        logger.info("--> Enter reverseFileContent Logic");
        // Access specific properties from the application.yml file
        Map<String, Object> params = LoadParametersUtility.loadParameters();
        String inputFilePath = LoadParametersUtility.getProperty(params, INPUTFILE);
        String outputFilePath = LoadParametersUtility.getProperty(params, OUTPUTFILE);

        logger.info("inputFilePath : " + inputFilePath);
        logger.info("outputFilePath : " + outputFilePath);

        // Read the contents of the file and generate content to write
        List<String> inputFileContent = readFile(inputFilePath);
        logger.info("inputFileContent : " + inputFileContent.toString());

        // Reverse the lines read and even its contents
        List<String> reversedContent = reverseFileContent(inputFileContent);
        logger.info("reversedContent : " + reversedContent);

        // Write to output file
        writeFile(outputFilePath, reversedContent);
        logger.info("--< Exit reverseFileContent Logic");
    }

    public void writeFile(String outputFile, List<String> reversedContent) {
        Path outputFilePath = Path.of(outputFile);

        try {
            // Write all lines to the file
            Files.write(outputFilePath, reversedContent, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            logger.severe("Exception occured " + e);
        }
    }

    public List<String> readFile(String inputFile) {
        Path path = Paths.get(inputFile);

        List<String> linesToWrite = new ArrayList<>();

        try {
            // Read all lines from the file into a List of Strings
            return Files.readAllLines(path);

        } catch (IOException e) {
            logger.severe("Exception occured " + e);
        }
        return linesToWrite;
    }

    public List<String> reverseFileContent(List<String> lines) {
        List<String> linesToWrite = new ArrayList<>();
        ListIterator<String> listIterator = lines.listIterator(lines.size());
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            String reversedContent = reversedString(element);
            linesToWrite.add(reversedContent);
        }
        return linesToWrite;
    }


    public String reversedString(String originalString) {
        return new StringBuilder(originalString).reverse().toString();
    }
}
