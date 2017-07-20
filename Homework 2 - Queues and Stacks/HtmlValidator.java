import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

	/* IMPLEMENT THIS METHOD! */
	HtmlTag currentTag;
	Stack<HtmlTag> tagStack = new Stack<>();
	while(!tags.isEmpty()) {
	    currentTag = tags.remove();
	    if (currentTag.isOpenTag() && !currentTag.isSelfClosing()){
		tagStack.push(currentTag);
	    } else if (!currentTag.isSelfClosing()) {
		if (tagStack.empty()) return null;
		if (currentTag.matches(tagStack.peek())) {
		    tagStack.pop();
		} else return tagStack;
	    }

	}

	return tagStack; // this line is here only so this code will compile if you don't modify it
    }


}

