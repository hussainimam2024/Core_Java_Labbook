package org.example.WebDriver_Selenium.Examples.Test_Pack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Login_MultiXML {
    public static void main(String[] args) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        File xmlfile = new File("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\application.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlfile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Login");

        for (int i = 0; i < nList.getLength(); i++) {
            Element element = (Element) nList.item(i);
            System.out.println("node name: " + element.getNodeName());

            String testUrl = element.getElementsByTagName("url").item(0).getTextContent();
            String Username = element.getElementsByTagName("username").item(0).getTextContent();
            String Password = element.getElementsByTagName("password").item(0).getTextContent();
            System.out.println("username: " + Username);
            System.out.println("password: " + Password);

            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            LOGIN_POM obj = PageFactory.initElements(driver, LOGIN_POM.class);

            driver.get(testUrl);
            driver.manage().window().maximize();
            Thread.sleep(2000);

            obj.enterusername(Username);
            Thread.sleep(2000);
            obj.enterpassword(Password);
            Thread.sleep(2000);
            obj.Loginbtn();
            Thread.sleep(2000);

        }
    }
}
