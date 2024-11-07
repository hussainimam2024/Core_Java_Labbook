package org.example.Datadriven_Framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Readconfig {

    public String getbrowser() throws IOException {
        Properties prob = new Properties();
        InputStream input = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Datadriven_Framework\\testdata\\application.properties");
        prob.load(input);
        String browsername = prob.getProperty("browsername");
        System.out.println(browsername);
        return browsername;
    }

    public static String geturl() throws IOException {
        Properties prob = new Properties();
        InputStream input = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Datadriven_Framework\\testdata\\application.properties");
        prob.load(input);
        String Url = prob.getProperty("url");
        System.out.println("url"+Url);
        return Url;
    }

}


