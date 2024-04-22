package config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    /**
     * Reads the base URI from the configuration file.
     *
     * @return The base URI read from the configuration file.
     */
    public ConfigReader() throws JsonProcessingException {
    }

    public static String readBaseURI() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/test/resources/config/config.json")) {
            Config config = gson.fromJson(reader, Config.class);
            return config.baseURI;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static class Config {
        String baseURI;
    }
}