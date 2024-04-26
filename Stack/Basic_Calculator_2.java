
// Basic Calculator 2

// String will contain number '+', '-', '*' & '/'

// Note - Given string can have spaces

import java.util.Stack;

class Basic_Calculator_2 {

    public static int calculate(String str){

        char sign = '+';

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
                while(i<str.length() && Character.isDigit(str.charAt(i))){
                    value = value * 10 + (str.charAt(i) - '0');
                    i++;
                }

                i--; // Decrement i

                if(sign == '+')
                  st.push(value);

                else if(sign == '-')
                  st.push(-value);

                else if (sign == '*')
                    st.push(st.pop()*value); // 1st '*' & divide will be solved

                else if (sign == '/')
                    st.push(st.pop()/value);    
                
            }

            // If character is operator
            else{
                sign = c;
            }

        }

        // Now stack will only have integers
        int answer = 0;
        while(!st.isEmpty()){
            answer += st.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        
        String str = " 31 + 22 *4 /3  -2 / 2 -1  *3 ";
        System.out.println(calculate(str));
    }

    
}
