
// Minimum Removal To Make Parentheses Valid

/*
Input -> a)(b((c)d)
Output -> ab((c)d)

Note - While removing the parentheses give priority to outermost parentheses
*/

/*
Approach -

In this, we don't have to just count the minimum no. of removal. We've to remove & create the answer and which
parentheses will be removed, that is also important. So, we'll convert the given string to a char array, so that every
character can be identified with an index.
*/

import java.util.Stack;

class Minimum_Removal_To_Make_Parentheses_Valid {

    public static String remove(String str){

        char c[] = str.toCharArray();
        Stack<Integer> st = new Stack<>(); // Will put index

        for(int i=0; i<c.length; i++){

            if(c[i] == '('){
                st.push(i);
            }

            else if(c[i] == ')'){

                if(st.isEmpty())
                    c[i] = '@'; // To identify the index of invalid ')'

                else
                  st.pop();

            }
        }

        // Now, index of invalid opening bracket will be there in stack
        while(!st.isEmpty()) {

            c[st.pop()] = '@'; // To identify the index of invalid '('
            
        }

        // Now in all invalid parentheses position there will be '@'
        String ans = "";
        for(int i=0; i<c.length; i++){

            if(c[i] != '@')
              ans = ans + c[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        String str = "(a(b(c)d)";
        System.out.println(remove(str));      
    }   
}
