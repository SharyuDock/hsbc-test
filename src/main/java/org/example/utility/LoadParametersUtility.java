package org.example.utility;

import org.example.App;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class LoadParametersUtility {
    private static final Logger logger = Logger.getLogger(LoadParametersUtility.class.getName());
    public static final String APPLICATION_YML = "application.yml";

    public static Map<String, Object> loadParameters() {

        // Read properties from the YAML file
        return readYamlFile(APPLICATION_YML);

    }

    private static Map<String, Object> readYamlFile(String yamlFilePath) {
        Yaml yaml = new Yaml();

        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream(yamlFilePath)) {
            if (inputStream != null) {
                // Load the YAML file into a Map
                return yaml.load(inputStream);
            } else {
                logger.severe("Unable to load the YAML file: " + yamlFilePath);
                return null;
            }
        } catch (Exception e) {
            logger.severe("Exception" + e);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProperty(Map<String, Object> map, String key) {
        return map != null && map.containsKey(key) ? (T) map.get(key) : null;
    }

}
