package org.example.utility;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadParametersUtilityTest {

    public static final String INPUTFILE = "inputfile";
    public static final String OUTPUTFILE = "outputfile";
    public static final String C_WORKSPACE_IO_CONTENT_TXT = "C:\\Workspace\\IO\\content.txt";
    public static final String C_WORKSPACE_IO_OUTPUTCONTENT_TXT = "C:\\Workspace\\IO\\outputcontent.txt";

    @Test
    public void testLoadParameters() {

        Map<String, Object> data = LoadParametersUtility.loadParameters();
        assert data != null;

        assertEquals(2, data.size());

        assertEquals(data.get(INPUTFILE), C_WORKSPACE_IO_CONTENT_TXT);
        assertEquals(data.get(OUTPUTFILE), C_WORKSPACE_IO_OUTPUTCONTENT_TXT);

        String inputVal = LoadParametersUtility.getProperty(data, INPUTFILE);
        assertEquals(inputVal, C_WORKSPACE_IO_CONTENT_TXT);

        String outputVal = LoadParametersUtility.getProperty(data, OUTPUTFILE);
        assertEquals(outputVal, C_WORKSPACE_IO_OUTPUTCONTENT_TXT);


    }
}
