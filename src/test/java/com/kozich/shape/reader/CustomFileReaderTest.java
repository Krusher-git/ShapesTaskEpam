package com.kozich.shape.reader;

import com.kozich.shape.exception.EllipseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomFileReaderTest {
    private static final String PATH = "data/resourceFile.txt";
    private CustomFileReader fileReader = new CustomFileReader();

    @Test
    public void readEllipsePointsTest() throws EllipseException {
        String expected = "(1.0, 2.3), (4.5, 8.4)";
        String actual = fileReader.readEllipsePoints(PATH);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = EllipseException.class)
    public void readEllipsePointsThrowableTest() throws EllipseException {
        fileReader.readEllipsePoints("");
    }
}
