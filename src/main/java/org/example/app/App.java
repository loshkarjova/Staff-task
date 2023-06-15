package org.example.app;

import org.example.app.services.ReadService;
import org.example.app.utils.Constants;

public class App {

    public static void main(String[] args) {
        String path = Constants.BASE_PATH + "staff.json";
        ReadService readService = new ReadService();
        readService.readData(path);
    }
}
