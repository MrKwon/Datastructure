package michael.dsalgo.Chapter05.HTMLTagMatching;

import michael.dsalgo.Chapter05.LinkedListStack.NodeStack;
import michael.dsalgo.Chapter05.LinkedListStack.Stack;

import java.io.IOException;
import java.util.Scanner;

public class HTML {
    public static String stripEnds(String t) {
        if (t.length() <= 2) return null;
        return t.substring(1, t.length() - 1);
    }

    public static boolean isOpeningTag(String tag) {
        return (tag.length() == 0) || (tag.charAt(0) != '/');
    }

    public static boolean areMatchTags(String tag1, String tag2) {
        return tag1.equals(tag2.substring(1));
    }

    public static boolean isHTMLMatched(String[] tag) {
        Stack<String> stack = new NodeStack<String>();

        for (int i = 0; (i < tag.length) && (tag[i] != null); i++) {
            if (isOpeningTag(tag[i]))
                stack.push(tag[i]);
            else {
                if (stack.isEmpty())
                    return false;
                if (!areMatchTags(stack.pop(), tag[i]))
                    return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public final static int CAPACITY = 1000;

    public static String[] parseHTML(Scanner s) {
        String[] tag = new String[CAPACITY];
        int count = 0;
        String token;
        while (s.hasNextLine()) {
            while ((token = s.findInLine("<[^>]*>")) != null)
                tag[count++] = stripEnds(token);
            s.nextLine();
        }
        return tag;
    }

    public static void main(String[] args) throws IOException {
        if (isHTMLMatched(parseHTML(new Scanner(System.in))))
            System.out.println("The input file is a matched HTML document.");
        else
            System.out.println("The input file is not a matched HTML document");
    }
}
