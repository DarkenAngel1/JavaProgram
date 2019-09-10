import java.util.*;
public class ExpStackMatching {
    public boolean matching(String expression){
        if (expression==null||expression==" ")
            System.out.println("表达式为空");
        if(expression.charAt(0)=='}'||expression.charAt(0)==']'||expression.charAt(0)==')')
            return false;
    Stack<Character> stack=new Stack<Character>();
        for(int index=0 ; index<expression.length();index++)
        {
            switch(expression.charAt(index))
            {
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
        }
        if(stack.empty())
            return true ;
        return false ;
    }
    public static void main(String[] args){
        String s="(])";
        ExpStackMatching a=new ExpStackMatching();
        boolean res=a.matching(s);
        System.out.println(res);
    }
}
