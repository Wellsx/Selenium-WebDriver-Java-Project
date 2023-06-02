package passwords;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("test@test.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message doesn't match.");

    }
}
