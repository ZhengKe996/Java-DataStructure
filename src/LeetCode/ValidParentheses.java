package LeetCode;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses{
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;

                char topChar = stack.pop();
                if(c == ')' && topChar != '(') return false;
                if(c == ']' && topChar != '[') return false;
                if(c == '}' && topChar != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
