import java.io.IOException;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	
	Queue<HtmlTag> tags;
	String filename = "C:/Users/Oguz/Desktop/test.html";
	
	tags = HtmlReader.getTagsFromHtmlFile(filename);
	
	System.out.println(HtmlValidator.isValidHtml(tags));

    }

}
