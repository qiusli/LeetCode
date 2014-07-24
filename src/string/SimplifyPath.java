package string;

import java.util.Stack;

/**
 * Created by liqiushi on 7/20/14.
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println("/a/./b/../../c/" + " == >> " + simplifyPath("/a/./b/../../c/"));
        System.out.println("/home/" + " == >> " + simplifyPath("/home/"));
        System.out.println("/abc/cd/ee/../f" + " == >> " + simplifyPath("/abc/cd/ee/../f"));
        System.out.println("/" + " == >> " + simplifyPath("/.."));
        System.out.println("/" + " == >> " + simplifyPath("/"));
        System.out.println("///" + " == >> " + simplifyPath("///"));
        System.out.println("/." + " == >> " + simplifyPath("/."));
        System.out.println("/string/SimplifyPath.java" + " == >> " + simplifyPath("//."));
        System.out.println("/home/../../.." + " == >> " + simplifyPath("/home/../../.."));
        System.out.println("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///" + " " +
                "== >> " + simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }

    private static String simplifyPath(String path) {
        if (path == null)
            return null;

        String result = "";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < path.length(); ) {
            String str = "";

            i++;
            while (i < path.length() && path.charAt(i) == '/')
                i++;

            while (i < path.length() && path.charAt(i) != '/') {
                str += path.charAt(i);
                i++;
            }

            if (str.equals("") && stack.size() > 0) {
                stack.pop();
            }

            if (!str.equals(".") && !str.equals("")) {
                if (!str.equals(""))
                    stack.push(str);
            }
        }

        for (String str : stack)
            result += "/" + str;

        return result.equals("") ? "/" : result;
    }
}
