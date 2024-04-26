
// Minimum Add To Make Parentheses Valid

/*
 U will get a string consisting only '(' & ')' or u can get an empty string. The given string can be balanced or
 not.
 We have to say minimum number of brackets that must be added to a string to make it valid
*/

import java.util.Stack;

class Minimum_Add_To_Make_Parentheses_Valid {

    public static int makeValid(String str){

        int count = 0;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            
            if(str.charAt(i) == '('){
                st.push('(');
            }

            else{
                if(!st.empty() && st.peek() == '(')
                  st.pop();
                else
                  count ++;  
            }
        }

       return count + st.size(); 
    }

    public static void main(String[] args) {

        String str = "()))((";
        System.out.println(makeValid(str));    
    }   
}
