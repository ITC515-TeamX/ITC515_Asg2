package datamanagement;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class XmlFileManager {
  private static XmlFileManager self_ = null;

  private Document document_;
  private String xmlFile_;
  
  
  
  public static XmlFileManager getInstance() {
    if (self_ == null)
      self_ = new XmlFileManager();
    return self_;
  }

  private XmlFileManager() {
    init();

  }

  public void init() {
    Properties properties = AppProperties.getInstance().getProperties();
    xmlFile_ = properties.getProperty("XMLFILE");
    try {
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities(true);
      document_ = builder.build(xmlFile_);
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
    try (FileWriter fout = new FileWriter(xmlFile_)) {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      outputter.output(document_, fout);
      fout.close();
    } 
    catch (IOException ioe) {
      System.err.printf("%s\n", "DBMD : XMLManager : saveDocument : Error saving XML to " + xmlFile_);
      throw new RuntimeException("DBMD: XMLManager : saveDocument : error writing to file");
    }
  }
}
