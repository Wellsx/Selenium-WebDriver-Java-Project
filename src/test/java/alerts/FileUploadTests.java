package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        String filePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "cat.jpg";
        uploadPage.uploadFile(filePath);
        assertEquals(uploadPage.getUploadedFiles(), "cat.jpg", "Failed upload.");
    }

}
