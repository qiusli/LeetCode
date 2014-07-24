
/**
 Regular Expression Matching

 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 Discuss


 */
public class S10 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));		// true
//        System.out.println(isMatch("aa", "a"));		// false
//        System.out.println(isMatch("aa", "aa"));	// true
//        System.out.println(isMatch("aaa", "aa"));	// false
//        System.out.println(isMatch("aa", "a*"));	//true
//        System.out.println(isMatch("aa", ".*"));	// true
//        System.out.println(isMatch("ab", ".*"));	// true
//        System.out.println(isMatch("aab", "c*a*b"));		// true
//
//        System.out.println(isMatch("", "bab"));			// false
//        System.out.println(isMatch("ab", ".*c"));		// false
//        System.out.println(isMatch("aaa", "a.a"));		// true
//        System.out.println(isMatch("a", "."));			// true
//        System.out.println(isMatch("a", "ab*"));		// true
//        System.out.println(isMatch("bb", ".bab"));		// false
//        System.out.println(isMatch("bb", "*"));			// false

    }

    public static boolean isMatch(String s, String p) {
        return isM(s, p, 0, 0);
    }

    public static boolean isM(String s, String p, int i, int j){
        if(j >= p.length()){			// pattern已经用光
            return i >= s.length();	// 如果s已经走完则匹配，否则不匹配
        }
        if(j == p.length()-1){	// 如果pattern的j已经走到最后一个字符，如果想匹配，则s的i也必须在最后一个，且相等
            return (i == s.length()-1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        }

        // 如果pattern的下一个字符(j+1)不是*
        if(j+1<p.length() && p.charAt(j+1) != '*'){
            if(i == s.length()){	// 如果s已经走完，则说明不匹配
                return false;
            }
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){	// 如果当前字符匹配
                return isM(s, p, i+1, j+1);		// 继续下一个字符判断
            }else{	// 如果当前字符不匹配，直接返回false
                return false;
            }
        }

        // 如果下一个字符(j+1)是* 且 当前字符匹配，则进行搜索：
        while(i<s.length() && j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')){
            // 因为*可以取0,1,2,...所以i=i,i+1,i+2,...对所有可能进行测试
            // 最后能否匹配取决于剩下的匹配是否成功
            if(isM(s, p, i, j+2)){	// 只要找到一个匹配成功即可
                return true;
            }
            i++;
        }

        // 如果下一个字符(j+1)是* 且 当前字符不匹配，则pattern跳过两个，继续比较
        // 还有一种情况到这里是上面的最后一次尝试（i==s.length()）
        return isM(s, p, i, j+2);
    }

}
