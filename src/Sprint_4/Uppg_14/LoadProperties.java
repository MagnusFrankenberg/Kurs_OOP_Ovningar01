package Sprint_4.Uppg_14;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {

   // String filename = "src/Sprint_4/Uppg_14/MyXmlProperties.xml";   //ladda med loadfromXML() istf load()
    String filename = "src/Sprint_4/Uppg_14/MyProperties.properties";
    Properties prop;

    public LoadProperties() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));   //loadfromXML när man använder xml-fil som properties-fil
            System.out.println("loaded");
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
