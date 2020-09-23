//import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Helper_Class implements RelativePath
{
    public WebDriver mydriver;
    public WebDriver Startbrowser() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(Properties_File_path);
        prop.load(fis);
        String SelectedBrowser = prop.getProperty("browser");
        if(SelectedBrowser.equals("Firefox"))
        {
            System.setProperty(Firefox_prop,Firefox_Driver_path);
            mydriver = new FirefoxDriver();
        }
        else if(SelectedBrowser.equals("Edge"))
        {
            System.setProperty(Edge_prop,Edge_Driver_path);
            mydriver = new EdgeDriver();
        }
        else
            System.out.println("Please enter Valid Browser name");
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return mydriver;
    }
}
