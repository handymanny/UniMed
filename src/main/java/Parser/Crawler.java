package Parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Crawler {

    public static void main (String [] args) {

        String base = "https://generated.photos/faces";
        System.setProperty("webdriver.chrome.driver", "/home/emmanuel/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(base);

        List<WebElement> images = driver.findElements(By.className("card-image"));

        int index = 0;
        for (WebElement ele : images) {
            WebElement a = ele.findElement(By.tagName("a"));
            WebElement img = a.findElement(By.tagName("img"));
            index++;

            downloadImage(img.getAttribute("src"), index);
        }
    }

    public static void downloadImage (String src, int index) {

        String fileName = String.format("%04d", index);

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new URL(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outputfile = new File("/home/emmanuel/UniMed/src/main/resources/Images/"+fileName+".png");
        try {
            ImageIO.write(bufferedImage, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
