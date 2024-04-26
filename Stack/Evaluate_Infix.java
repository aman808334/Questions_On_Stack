
import java.util.Stack;

class Evaluate_Infix {

    public static int evaluate(String str){

        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

            if(c == '+' || c == '-' || c == '*' || c == '/'){
            
              // Higher priority operators to be solved 1st
              while(!op.empty() && op.peek()!='(' && precedence(c) <= precedence(op.peek())){
                 char o = op.pop();
                 int num2 = num.pop();
                 int num1 = num.pop();
                 int ans = calculate(num1,o,num2);
                 num.push(ans);
              }

            op.push(c);

            }
            else if(c == '(' || c == ')'){
                if(c == '('){
                    op.push(c);
                }
                else{
                    while(op.peek()!='('){

                        char o = op.pop();
                        int num2 = num.pop();
                        int num1 = num.pop();
                        int ans = calculate(num1,o,num2);
                        num.push(ans);
                    }
                    op.pop();
                }

            }
            else{ // If number then convert that char in int & push that in number stack
                int no = c - '0';
                num.push(no);
            }

        }
        //If iteration of string has ended & the stack of operator isn't empty
        while(op.size()>0)
        {
            char o = op.pop();
            int num2 = num.pop();
            int num1 = num.pop();
            int ans = calculate(num1,o,num2);
            num.push(ans);
        }

       return num.peek();
    }

    public static int precedence(char c){
        if( c =='+' || c == '-')
          return 0;
        else if(c =='*' || c == '/')
          return 1;  

        return 0;  
    }

    public static int calculate(int num1, char o, int num2){

        if(o=='+')
         return num1+num2;
        if(o=='-')
         return num1-num2;
        if(o=='*')
         return num1*num2;
        if(o=='/')
         return num1/num2;
 
 
    return 0;

    }

    public static void main(String[] args) {
        String str = "2+6*4/8-3";
        System.out.println(evaluate(str));
    }
    
}
