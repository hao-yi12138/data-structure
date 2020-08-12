import java.util.Stack;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-08-12 09:58
 **/
public class TestDemo {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //来源：力扣（LeetCode）
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '('||ch=='['||ch=='{'){
                stack.push(ch);
            }else{
                if(stack.empty()){
                    System.out.println("右括号多！");
                    return false;
                }
                char ch2 = stack.peek();
                if(ch2=='('&&ch==')'||ch2=='['&&ch==']'||ch2=='{'&&ch=='}'){
                    stack.pop();
                }else{
                    System.out.println("左右括号不匹配!");
                    return false;
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多！");
            return false;
        }
        return true;
    }
}
