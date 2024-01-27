package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReverseFileContentServiceTest {

    @InjectMocks
    ReverseFileContentService reverseFileContentService;
    public static final String SRC_TEST_RESOURCES_TEST_CONTENT_TXT = "src/test/resources/testContent.txt";
    public static final String SRC_TEST_RESOURCES_TEST_OUTPUT_CONTENT_TXT = "src/test/resources/testOutputContent.txt";

    @Test
    public void testReadFile() {

        List<String> content = reverseFileContentService.readFile(SRC_TEST_RESOURCES_TEST_CONTENT_TXT);
        assertEquals(2, content.size());

        assertEquals("This is first line", content.get(0));
        assertEquals("This is second line", content.get(1));

    }

    @Test
    public void testWriteFile() {

        List<String> writeData = new ArrayList<>();
        writeData.add("This is output first line");
        writeData.add("This is output second line");
        writeData.add("This is output third line");

        reverseFileContentService.writeFile(SRC_TEST_RESOURCES_TEST_OUTPUT_CONTENT_TXT, writeData);

        List<String> readWrittenContent = reverseFileContentService.readFile(SRC_TEST_RESOURCES_TEST_OUTPUT_CONTENT_TXT);
        assertEquals(3, readWrittenContent.size());

        Boolean isDataEqual = writeData.containsAll(readWrittenContent);
        assertEquals(true, isDataEqual);

        assertEquals(writeData.get(0), readWrittenContent.get(0));
        assertEquals(writeData.get(1), readWrittenContent.get(1));
        assertEquals(writeData.get(2), readWrittenContent.get(2));
    }

    @Test
    public void testReverseContent() {
        List<String> reverseData = new ArrayList<>();
        reverseData.add("ABC DEF");
        reverseData.add("GHI JKL");
        reverseData.add("MNO PQR");
        List<String> content = reverseFileContentService.reverseFileContent(reverseData);
        assertEquals(3, content.size());


        assertEquals("RQP ONM", content.get(0));
        assertEquals("LKJ IHG", content.get(1));
        assertEquals("FED CBA", content.get(2));

    }


}
