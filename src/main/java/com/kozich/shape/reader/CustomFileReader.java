package com.kozich.shape.reader;

import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String ERROR_MESSAGE_LINE = "No matching lines";
    private static final String ERROR_MESSAGE_FILE = "File is not valid";

    public String readEllipsePoints(String path) throws EllipseException {
        ClassLoader classLoader = CustomFileReader.class.getClassLoader();
        URL temp = classLoader.getResource(path);
        String filePath = new File(temp.getFile()).getAbsolutePath();
        if (!DataValidator.isValidFile(filePath)) {
            throw new EllipseException(ERROR_MESSAGE_FILE);
        }
        Path streamPath = Paths.get(filePath);
        String pointsString = null;
        try (Stream<String> fileLines = Files.lines(streamPath)) {
            pointsString = fileLines.filter(DataValidator::isValidString)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            logger.log(Level.ERROR, e);
            throw new EllipseException(e);
        }
        if (pointsString == null) {
            throw new EllipseException(ERROR_MESSAGE_LINE);
        }
        return pointsString;
    }
}