package com.epam.mjc.nio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String pathFile = file.getPath();
        Map<String, String> profileData = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(pathFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(": ");
                profileData.put(data[0].trim(), data[1].trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Profile(
                profileData.get("Name"),
                Integer.parseInt(profileData.get("Age")),
                profileData.get("Email"),
                Long.parseLong(profileData.get("Phone"))
        );
    }
}
