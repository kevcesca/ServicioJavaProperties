package com.PJMX.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Map;
import java.util.Properties;

@RestController
public class PropertiesController {

    @PostMapping("/saveProperties")
    public String saveProperties(@RequestBody Map<String, String> properties) {
        try (OutputStream output = new FileOutputStream("config.properties")) {
            Properties prop = new Properties();
            prop.putAll(properties);
            prop.store(output, null);
            return "Archivo properties guardado correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo properties: " + e.getMessage();
        }
    }
}

