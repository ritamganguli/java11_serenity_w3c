package starter.setup;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

//import net.thucydides.core.util.EnvironmentVariables;
//import net.thucydides.core.environment.SystemEnvironmentVariables;

public class Init {

  private static EnvironmentVariables envVars;
 public static String getAppUrl() {
	  String appUrl=null;
     envVars = SystemEnvironmentVariables.createEnvironmentVariables();
     appUrl=System.getProperty("appUrl","").toString();
    if (appUrl.equals("")) {
    	appUrl =envVars.getProperty("appUrl");
	}
	return appUrl;
  }
  public static void captureScreenshot(String fileName) {
        if (driver == null) {
            initializeWebDriver();
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            File destinationFile = new File(fileName + "_" + timestamp + ".png");
            ImageIO.write(ImageIO.read(screenshot), "png", destinationFile);
            System.out.println("Screenshot saved to " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeWebDriver();
        driver.get(getAppUrl());
        captureScreenshot("screenshot");
        driver.quit();
    }
}
ß



}
