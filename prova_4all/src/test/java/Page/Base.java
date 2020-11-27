package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public static WebDriver navegador = null;

    public static void AbrirNavegador(String navegador)
    {
        if (navegador == "chrome")
            AbrirChrome();
        else if(navegador== "firefox")
            AbrirFirefox();
    }

    static void AbrirChrome()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\ChromeDriver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://shopcart-challenge.4all.com/");
    }

    static void AbrirFirefox()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\FirefoxDriver\\geckodriver.exe");
        navegador = new FirefoxDriver();
        navegador.manage().window().maximize();
        navegador.get("https://shopcart-challenge.4all.com/");
    }

    public static void FecharNavegador(){
        navegador.close();
    }

    public static void Click(By locator){
        navegador.findElement(locator).click();
    }

}
