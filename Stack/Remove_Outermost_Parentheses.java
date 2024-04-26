
// Remove Outermost Parentheses

/*
U will get a string consisting only '(' & ')' or u can get an empty string. The given string is balanced.
*/

import java.util.Stack;

class Remove_Outermost_Parentheses {

    public static String remove(String str){

        String ans = "";
        int start = 0;
        boolean flag = true;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == '(')
              st.push('(');
            else
              st.pop();
              
            flag = false;
            
            if(flag == false && st.isEmpty()){ // Flag b/c, stack is empty initially also

                // Part of an answer is to be formed
                ans = ans + str.substring(start+1, i);
                start = i+1;
                flag = true;
            }
              
        }

       return ans;
    }

    public static void main(String[] args) {

        String str = "(()())(())(()(()))";
        System.out.println(remove(str));
    }
    
}
