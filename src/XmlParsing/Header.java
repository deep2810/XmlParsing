package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public class Header implements XmlComponet {
  private String text;
  private int tabIndex;
  
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
  
  public String getTab(int tabIndex) {
    String str = "";
    for (int i = 0; i < tabIndex; i++) {
      str += "\t";
    }
    return str;
  }
  
  @Override
  public String getData() {
    String tab = getTab(tabIndex);
    
    StringBuilder builder = new StringBuilder();
    builder.append(tab  + text ).append("\n");
    return builder.toString();
  }
  
  @Override
  public void setTabIndex(int tabIndex) {
    this.tabIndex = tabIndex;
    
  }
  
  @Override
  public int getTabIndex() {
    return tabIndex;
  }
}
