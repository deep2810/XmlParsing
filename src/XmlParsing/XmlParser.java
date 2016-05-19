package XmlParsing;

/**
 * @author Deep
 */

import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class XmlParser extends DefaultHandler {
  
  private Document document;
  private XmlComponet element;
  private Stack<Document> stack;
  
  public XmlParser() {
    stack = new Stack<Document>();
  }
  
  public Document parseXml(String fileName) {
    parseDataFromXmlFile(fileName);
    return document;
  }
  
  private void parseDataFromXmlFile(String fileName) {
    try {
      SAXParserFactory parserFactor = SAXParserFactory.newInstance();
      SAXParser parser = parserFactor.newSAXParser();
      parser.parse(fileName, this);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      throw new RuntimeException("Error while pasing json at: " + fileName + ", the error message is: " + e.getMessage(), e);
    }
  }
  
  @Override
  public void startDocument() throws SAXException {
      super.startDocument();
  }
  
  @Override
  public void endDocument() throws SAXException {
      super.endDocument();
  }
  
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if ("CS635Document".equals(qName)) {
      document = new Document();
      document.setTabIndex(stack.size());
      stack.push(document);
    } else if ("header".equals(qName)) {
      element = new Header();
      element.setTabIndex(stack.size());
    } else if ("text".equals(qName)) {
      element = new Text();
      element.setTabIndex(stack.size());
    }
  }
  
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);
    String text = String.valueOf(ch, start, length);
    if (text != null && text.trim().length() != 0) {
      element.setText(text);
    }
  }
  
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if ("CS635Document".equals(qName)) {
      Document element = stack.pop();
      if (!stack.isEmpty()) {
        Document doc = stack.peek();
        doc.addXmlComponent(element);
      } else {
        this.document = element; // root element
      }
    } else if ("header".equals(qName) || "text".equals(qName)) {
      Document doc = stack.peek();
      doc.addXmlComponent(element);
    }
  }
  
  public static void main(String[] args) {
    XmlParser xmlParser = new XmlParser();
    Document doc = xmlParser.parseXml("/Users/gowthambalasubramanian/Documents/sample.txt");
    
    System.out.println("-----------------------------");
    System.out.println("Using HeaderVisitor\n");
    HeaderVisitor headerVisitor = new HeaderVisitor();
    String docStr = doc.accept(headerVisitor);
    System.out.println(docStr);
    
    System.out.println("-----------------------------");
    System.out.println("Using HtmlVisitor\n");
    HtmlVisitor htmlVisitor = new HtmlVisitor();
    docStr = doc.accept(htmlVisitor);
    System.out.println(docStr);
    
    System.out.println("-----------------------------");
    System.out.println("Print the list of html using composite pattern and sax parser\n");
    docStr = doc.getData();
    System.out.println(docStr);
  }
}
