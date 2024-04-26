
// Basic Calculator

// String will contain number, '+', '-' & bracket

// Note - Given string can have spaces

import java.util.Stack;

class Basic_Calculator_1 {

    public static int calculate(String str){

        int sign = +1; // To handle unary operator
        int sum = 0;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

           // If character is space 
           if(c == ' '){

               // Do Nothing
           }

           // If character is digit 
           else if(Character.isDigit(c)){

            int value = 0;
            
            // To handle if number if more than one digit
            while(i<str.length() && Character.isDigit(str.charAt(i))){
                value = value*10 + (str.charAt(i) - '0');
                i++;
            }
            
            i--; // Decrement i
            value = value * sign; // To handle unary operator
            sum += value;
            sign = 1; // Reset the sign

           }
           
           // If character is opening bracket
           else if(c == '('){

            st.push(sum);
            st.push(sign);

            // Now reset sum & sign
            sum = 0;
            sign = 1;

           }

           // If character is closing bracket
           else if(c == ')'){
            sum = sum * st.pop(); // sign
            sum = sum + st.pop();
           }

           // If character is negative sign
           else if(c == '-'){
            sign = sign * -1;
           }
        }

        return sum;
    }

    public static void main(String[] args) {
        
        String str = " -312 +  -1 - ( -3+1 + ( +8 - - 1) -1) + - 2";
        System.out.println(calculate(str));
    }
}