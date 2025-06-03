package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyManager {
        private static final Properties properties = new Properties();

        public static void load(String filePath) throws IOException {
            try (FileInputStream input = new FileInputStream(filePath)) {
                properties.load(input);
            }
        }

        public static String get(String key) {
            return properties.getProperty(key);
        }

        public static int getInt(String key) {
            return Integer.parseInt(properties.getProperty(key));
        }

        public static boolean getBoolean(String key) {
            return Boolean.parseBoolean(properties.getProperty(key));
        }

        public static Properties getAll() {
            return properties;
        }
    }

    

