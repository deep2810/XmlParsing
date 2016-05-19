package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public class HtmlVisitor implements Visitor {
  
  @Override
  public String visit(Document document) {
    String text = (document.getText() == null) ? "" : document.getText();
    return ( text + "\n");
  }
  
  @Override
  public String visit(Header header) {
    String text = (header.getText() == null) ? "" : header.getText();
    return ( text + "\n");
  }
  
  @Override
  public String visit(Text text) {
    String myText = (text.getText() == null) ? "" : text.getText();
    return ( myText + "\n");
  }
}
