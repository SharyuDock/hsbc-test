package org.example;

import org.example.service.ReverseFileContentService;

public class App {
    public static void main(String[] args) {

        ReverseFileContentService service = new ReverseFileContentService();

        service.reverseFileContent();

    }


}
