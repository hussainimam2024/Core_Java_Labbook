package org.example.Datadriven_Framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Readconfig {
    public String getproperties() throws IOException{
        Properties prop = new Properties();
        InputStream input = new FileInputStream("C:\\Users\\imam.hussain\\IdeaProjects\\newporjects\\Ascendion\\src\\main\\java\\org\\example\\Datadriven_Framework\\testdata\\application.properties");
        prop.load(input);
        String browsername = prop.getProperty("browsername");
        return browsername;

    }

}

