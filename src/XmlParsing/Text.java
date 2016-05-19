package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public class Text implements XmlComponet {
  private String text;
  private int index;
  
  @Override
  public String accept(Visitor visitor) {
    return visitor.visit(this);
  }
  
  @Override
  public void setText(String text) {
    this.text = text;
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

  public String getTab(int tabIndex) {
    String str = "";
    for (int i = 0; i < tabIndex; i++) {
      str += "\t";
    }
    return str;
  }
 
  @Override
  public String getData() {
    String tab = getTab(index);
    StringBuilder builder = new StringBuilder();
    builder.append(tab +  text ).append("\n");
    return builder.toString();
  }
}
