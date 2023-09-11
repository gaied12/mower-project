package fr.mowltNow.utils;

import fr.mowltnow.exception.AppException;
import fr.mowltnow.model.Lawn;
import fr.mowltnow.utils.DataParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataParserTest {

    private DataParser dataParser;

    @Before
    public void setUp() {
        dataParser = DataParser.getInstance();
    }

    @Test
    public void testReadMowingDataFromFile() {
        String filePath = "src/test/resources/mower";

        Lawn result = dataParser.readMowingDataFromFile(filePath);

        assertNotNull(result);
        assertEquals(5, result.getGridMaxSize().getX());
        assertEquals(5, result.getGridMaxSize().getY());


    }

    @Test(expected = AppException.class)
    public void testReadMowingDataFromFileWithInvalidPath() {
        String filePath = "path/to/your/invalidfile.txt";

        dataParser.readMowingDataFromFile(filePath);
    }
    @Test(expected = AppException.class)
    public void testReadMowingDataFromFileWithEmptyFile() {
        String filePath = "src/test/resources/emptyFile";

        dataParser.readMowingDataFromFile(filePath);
    }
    @Test(expected = AppException.class)
    public void testReadMowingDataFromFileWithWrongData() {
        String filePath = "src/test/resources/wrong_data";

        dataParser.readMowingDataFromFile(filePath);
    }


}
