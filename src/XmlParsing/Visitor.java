package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public interface Visitor {
  String visit(Document document);
  String visit(Header header);
  String visit(Text text);
}
