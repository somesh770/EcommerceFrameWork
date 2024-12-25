package Test_PACK;

import java.nio.file.Paths;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SendReport {

	@Test
    public void sendReport() {
        String recipient = "meron94416@cctoolz.com";
        String subject = "Test Execution Report";
        String messageBody = "Please find the attached test execution report for Edge browser.";
        String attachmentPath = Paths.get(System.getProperty("user.dir"), "test-output", "emailable-report.html").toString();

        Utility_PACK.EmailUtils.sendEmail(recipient, subject, messageBody, attachmentPath);
    }

}
