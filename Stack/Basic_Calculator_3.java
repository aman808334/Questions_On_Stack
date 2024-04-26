
// Basic Calculator 3

// String will contain number, '+', '-', '*', '/' & bracket

// Note - Given string can have spaces

import java.util.Stack;

class Basic_Calculator_3 {

    public static int calculate(String str){


        Stack<Integer> no = new Stack<>(); // For numbers
        Stack<Character> op = new Stack<>(); // For operator & '('

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

        
            if(Character.isDigit(c)){

              int value = 0;
              while(i<str.length() && Character.isDigit(str.charAt(i))){
                value = value * 10 + (str.charAt(i) -'0');
                i++;
              }

              i--; // Decrement i
              no.push(value); 

            }

            else if(c == '+' || c == '-' || c == '*' || c== '/'){

                while(!op.isEmpty() && op.peek()!='(' && precedence(c) <= precedence(op.peek())){ // Higher precedence operator should be solve 1st
                    int num2 = no.pop();
                    int num1 = no.pop();
                    char operator = op.pop();
                    int ans = calculate(num1,operator,num2);
                    no.push(ans);
                }

                op.push(c);

            }

            else if(c == '('){
                op.push(c);
            }

            else if(c == ')'){

                while(op.peek() != '('){
                    int num2 = no.pop();
                    int num1 = no.pop();
                    char operator = op.pop();
                    int ans = calculate(num1,operator,num2);
                    no.push(ans);
                }

                op.pop(); // Pop '('
            }

        }

        //If iteration of string has ended & the stack of operator isn't empty
        while(op.size()>0)
        {
            char o = op.pop();
            int num2 = no.pop();
            int num1 = no.pop();
            int ans = calculate(num1,o,num2);
            no.push(ans);
        }

       return no.peek();
    }

    public static int calculate(int num1, char op, int num2){

        int ans = 0;
        
        if(op == '+')
          ans = num1 + num2;
         
        else if(op == '-')
          ans = num1 - num2;
          
        else if(op == '*')
          ans = num1 * num2; 
          
        else if(op == '/')
          ans = num1 / num2;

       return ans;    
    }

    public static int precedence(char c){

        int p = 0;

        if(c =='*' || c == '/')
          p = 1;  

        return p;  
    }

    public static void main(String[] args) {
        
        String str = "  2 *  (5  + 5  *2)   /3  +(6/2   +8) ";
        System.out.println(calculate(str));      
    }
    
}
