
import java.util.Stack;

class Infix_Conversion {

    public static String prefix(String str){

        Stack<String> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

            if(c == '+' || c == '-' || c == '*' || c == '/'){

                while(!op.empty() && op.peek() != '(' && precedence(c) <= precedence(op.peek())){

                    char o = op.pop();
                    String num2 = num.pop();
                    String num1 = num.pop();
                    String s = o+num1+num2;
                    num.push(s);
                }

              op.push(c);

            }

            else if(c == '(' || c == ')'){
                if(c == '(')
                  op.push(c);
                else{
                    while(op.peek() != '('){
                      char o = op.pop();
                      String num2 = num.pop();
                      String num1 = num.pop();
                      String s = o+num1+num2;
                      num.push(s);
                    }
                   op.pop(); 
                }  

            }

            else{ // If number then convert that char in string & push that in number stack
                num.push(c+"");
            }
        }

        //If iteration of string has ended & there stack has operators
        while(op.size()>0)
        {
            char o = op.pop();
            String num2 = num.pop();
            String num1 = num.pop();
            String s = o+num1+num2;
            num.push(s);
        }

       return num.peek(); 
    }

    public static String postfix(String str){

        Stack<String> num = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

            if(c == '+' || c == '-' || c == '*' || c == '/'){

                while(!op.empty() && op.peek() != '(' && precedence(c) <= precedence(op.peek())){

                    char o = op.pop();
                    String num2 = num.pop();
                    String num1 = num.pop();
                    String s = num1+num2+o;
                    num.push(s);
                }

              op.push(c);

            }

            else if(c == '(' || c == ')'){
                if(c == '(')
                  op.push(c);
                else{
                    while(op.peek() != '('){
                      char o = op.pop();
                      String num2 = num.pop();
                      String num1 = num.pop();
                      String s = num1+num2+o;
                      num.push(s);
                    }
                   op.pop(); 
                }  

            }

            else{ // If number then convert that char in string & push that in number stack
                num.push(c+"");
            }
        }

        //If iteration of string has ended & there stack has operators
        while(op.size()>0)
        {
            char o = op.pop();
            String num2 = num.pop();
            String num1 = num.pop();
            String s = num1+num2+o;
            num.push(s);
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


    public static void main(String[] args) {
        String str = "(M+N)*(P*Q-O)*R/G";
        System.out.println(prefix(str));
        System.out.println(postfix(str));
    }
    
}
