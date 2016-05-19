package XmlParsing;

/**
 * @author Deep
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class XmlParserTest {

	@Test
	public void testParse() {
		String expectedOutput =  	"This is an example" +"Not much here" +"Just text here" ;						
		expectedOutput = expectedOutput.trim();
		XmlParser xmlParser = new XmlParser();
	    Document document = xmlParser.parseXml("F:/eclipse/storage/Assignment4_OOPS/src/core/sample.xml");
	    String actualOutput = document.getData();
	    actualOutput = actualOutput.replace("\t", "");
	    actualOutput = actualOutput.replace("\n", "").trim();
	    assertEquals(expectedOutput, actualOutput);
	}
	
	  @Test
	  public void testHeaderVisitor() {
	    String expectedOutput = "This is an example";  
	    expectedOutput = expectedOutput.trim();
	    XmlParser xmlParser = new XmlParser();
	    Document document = xmlParser.parseXml("F:/eclipse/storage/Assignment4_OOPS/src/core/sample.xml");
	    HeaderVisitor headerVisitor = new HeaderVisitor();
	    String actualOutput = document.accept(headerVisitor);
	    actualOutput = actualOutput.replace("\t", "");
	    actualOutput = actualOutput.replace("\n", "").trim();
	    assertEquals(expectedOutput, actualOutput);
	  }
	  
	  
	  @Test
	  public void testHtmlVisitor() {
	    String expectedOutput = "This is an example" + "Not much here" + "Just text here";
	    expectedOutput = expectedOutput.trim();
	    XmlParser xmlParser = new XmlParser();
	    Document document = xmlParser.parseXml("F:/eclipse/storage/Assignment4_OOPS/src/core/sample.xml");
	    HtmlVisitor htmlVisitor = new HtmlVisitor();
	    String actualOutput = document.accept(htmlVisitor);
	    actualOutput = actualOutput.replace("\t", "");
	    actualOutput = actualOutput.replace("\n", "").trim();
	    assertEquals(expectedOutput, actualOutput);
	  }
}
