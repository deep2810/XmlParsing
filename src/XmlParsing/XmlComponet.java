package XmlParsing;

/**
 * 
 * @author Deep
 *
 */

public interface XmlComponet extends XmlData {
  
	public String accept(Visitor visitor);
	public void setText(String text);
	public String getText();
    public void setTabIndex(int tabIndex);
    public int getTabIndex();
}
