package datamanagement;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class XmlManager {
  private static XmlManager self_ = null;

  private Document document_;
  private String xmlFile;
  
  
  
  public static XmlManager getInstance() {
    if (self_ == null)
      self_ = new XmlManager();
    return self_;
  }

  private XmlManager() {
    init();

  }

  public void init() {
    Properties properties = AppProperties.getInstance().getProperties();
    xmlFile = properties.getProperty("XMLFILE");
    try {
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities(true);
      document_ = builder.build(xmlFile);
    }
    catch (JDOMException e) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught JDOMException\n");
      throw new RuntimeException("DBMD: XMLManager : init : JDOMException");
    } 
    catch (IOException e) {
      System.err.printf("%s", "DBMD: XMLManager : init : caught IOException\n");
      throw new RuntimeException("DBMD: XMLManager : init : IOException");
    }
  }


  
  public Document getDocument() {
    return document_;
  }


  
  public void saveDocument() {
    try (FileWriter fout = new FileWriter(xmlFile)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document_, fout);
      fout.close();
    } 
    catch (IOException ioe) {
      System.err.printf("%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlFile);
      throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
    }
  }
}
