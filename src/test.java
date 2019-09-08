import java.util.Stack;

public class test {
    public boolean matching(String expression)
    {
        if (expression==null||expression=="")
            System.out.println("输入的字符串不能为空");
        Stack<Character> stack=new Stack<Character>();
        for (int index = 0; index<expression.length();index++)
            switch(expression.charAt(index)){
        case '(':
        stack.push(expression.charAt(index)) ;
        break ;
        case '{':
        stack.push(expression.charAt(index)) ;
        break ;
        case ')':
        if(!stack.empty()&&stack.peek()=='(')
        {
            stack.pop() ;
        }
        break ;

        case '}':
        if(!stack.empty()&&stack.peek()=='{')
        {
            stack.pop();
        }
        }
        if(stack.empty())
            return true ;
        return false ;
    }
    public static void main(String[] args){

    }
}