package com.accenture.apiautomacao.controller;

import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author fernando.m.souza
 */
public class SeleniumHelper {

    public static void ValidaCertificadoSSL() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException e) {
            System.out.println(e);
        }
    }

//    private static byte[] readBytesFromImage(BufferedImage originalImage) {
//        try {
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(originalImage, "png", baos);
//            baos.flush();
//            byte[] imageInByte = baos.toByteArray();
//            baos.close();
//            return imageInByte;
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
    public static byte[] readBytesFromImage(WebDriver driver, WebElement webElement) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(getCaptcha(driver, webElement), "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;

        } catch (IOException e) {
            log.info("Erro ao obter os Bytes da Imagem.");
        }
        return null;
    }

    public static void waitValueNotNull(WebDriver driver, final WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String value = element.getAttribute("value");
                if (!value.equals("")) {
                    return true;
                }
                return false;
            }
        });
    }

    public static void waitValueEqual(WebDriver driver, final WebElement element, final String texto) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String value = element.getAttribute("value");

                if (value.equals(texto)) {
                    return true;
                }

                return false;
            }
        });
    }

    public static BufferedImage getCaptcha(WebDriver driver, WebElement captchaIMG) {

        BufferedImage eleScreenshot = null;

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(scrFile);

            // Obter a localização do elemento na página
            Point point = captchaIMG.getLocation();

            // Obter largura e altura do elemento
            int eleWidth = captchaIMG.getSize().getWidth();
            int eleHeight = captchaIMG.getSize().getHeight();

            // Recortar a imagem da tela inteira para obter apenas a captura de tela do elemento
            eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
                    eleWidth, eleHeight);
//            ImageIO.write(eleScreenshot, "png", scrFile);
//            //Salva o elemento no disco
//            FileUtils.copyFile(scrFile, new File("C:\\Automacoescg\\Java\\Triagem_Fixo\\Extracao_SIAC\\Extracao\\trunk\\screenshot.png"));

        } catch (IOException ex) {
            log.info("Erro ao obter o captcha da página.");
        }

        return eleScreenshot;
    }

    public static void ClickAndWaitPageLoad(WebDriver driver, Integer timeWait, String xpathWebElement) {
        driver.manage().timeouts().pageLoadTimeout(timeWait, TimeUnit.MINUTES);
        driver.findElement(By.xpath(xpathWebElement)).click();
    }

}
