package XmlParsing;

/**
 * @author Deep
 */
import java.util.ArrayList;
import java.util.List;

public class Document implements XmlComponet {
  
  private String text;
  private int index;
  private List<XmlComponet> xmlComponent;
  
  public Document() {
    xmlComponent = new ArrayList<>();
  }
  
  public List<XmlComponet> getXmlComponent() {
    return xmlComponent;
  }
  
  public void setXmlComponent(List<XmlComponet> xmlComponent) {
    this.xmlComponent = xmlComponent;
  }
  
  public void addXmlComponent(XmlComponet xmlComponent) {
    this.xmlComponent.add(xmlComponent);
  }
    
  public String getTab(int index) {
    String str = "";
    for (int i = 0; i < index; i++) {
      str += "\t";
    }
    return str;
  }
  
  @Override
  public void setText(String text) {
    this.setText(text);
    
  }
  
  @Override
  public String getText() {
    return text;
  }
  
  @Override
  public void setTabIndex(int index) {
    this.index = index;
    
  }
  
  @Override
  public int getTabIndex() {
    return index;
  }
  
  @Override
  public String getData() {
    String tab = getTab(index);
    StringBuilder builder = new StringBuilder(); 
    builder.append(tab ).append("\n");
   
    for (XmlData component : xmlComponent) {
      builder.append(component.getData());
    }
    builder.append(tab ).append("\n");
    
    return builder.toString();
  }
  
  @Override
  public String accept(Visitor visitor) {
    StringBuilder builder = new StringBuilder();
    builder.append(visitor.visit(this));
    
    for (XmlComponet xmlContent : xmlComponent) {
      builder.append(xmlContent.accept(visitor));
    }
    
    return builder.toString();
  }

  
}
