package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Property parameters.
 */
public class PropertyParameters {
    private final static Logger LOGGER = LogManager.getLogger(PropertyParameters.class);
    private final static PropertyParameters sInstance = new PropertyParameters();
    private final Properties properties = new Properties();
    private final String propertiesLocation = "env.properties";

    private PropertyParameters() {
        String filePath = propertiesLocation;
        LOGGER.info("Loading properties. Started. PropertyFilePath={}", filePath);
        try {
            loadProperties(filePath);
            LOGGER.info("Loading properties. Finished. PropertyFilePath={}, PropertiesCount={}", filePath,
                    properties.size());
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Failed to load property file. PropertyFilePath=%s", filePath), e);
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PropertyParameters getInstance() {
        return sInstance;
    }

    /**
     * Get string.
     *
     * @param propertyName the property name
     * @return the string
     */
    public String get(final String propertyName) {
        return properties.getProperty(propertyName);
    }

    private void loadProperties(final String propertyFilePath) throws IOException {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFilePath)) {
            final Properties props = new Properties();
            props.load(inputStream);
            properties.putAll(props);
        }
    }

}