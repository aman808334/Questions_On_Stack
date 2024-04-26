
// Reverse Substring B/w Each Pair of Parentheses

import java.util.Stack;

class Reverse_Substring_Between_Parentheses {

    public static String solve(String str){

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) != ')'){
                st.push(str.charAt(i));
            }

            else{

                String s = "";

                while(st.peek() != '('){ // Empty condition won't be there b/c string in balanced
                  s = s + st.pop();
                }
                st.pop();

                for(int j=0; j<s.length(); j++){
                    st.push(s.charAt(j));
                }
              
            }
        }
        //Now the iteration of the given string is over. Stack will have answer
        return st.toString();
    }

    public static void main(String[] args) {      
        String str = "(ni(pc(do))ep)g";
        System.out.println(solve(str));
    } 
}
