package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public class HeaderVisitor implements Visitor {
  
  @Override
  public String visit(Document document) {
    return (""); 
  }
  
  @Override
  public String visit(Header header) {
    return ( header.getText() + "\n");
    
  }
  
  @Override
  public String visit(Text text) {
    return (""); 
  }
  
}
