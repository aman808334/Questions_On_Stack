
// Check If Word Is Valid After Substitutions

/*
U'r given a string. Determine if it's valid or not.

A string s is valid if, starting with an empty string (""), you can transform the string into a string 's'
a/f performing the following operation any number of times -

Insert string "abc" into any position in the empty string. Then again repeat the same process & so on

Return true if s is a valid string, otherwise, return false.

Example -

Input: "aabcbc"
Output: true
Explanation: "" -> "abc" -> "aabcbc", thus, "aabcbc" is valid.
*/

import java.util.Stack;

class Check_If_Word_Is_Valid_After_Substitutions{

    public static boolean isValid(String str){

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == 'c'){

                if(st.size() >=2 && st.pop() == 'b' && st.peek()=='a'){ // Check empty condition won't work (Example - "babcc")
                    // Already popped
                }
                else{ // If there isn't 'a' & 'b' b/f 'c'.Then if we push that 'c' in stack. It will never be removed
                    return false;
                }
            }

            else{
                st.push(str.charAt(i));
            }
        }
       return st.isEmpty();
    }

    public static void main(String[] args) {
        
        String str = "babcc";
        System.out.println(isValid(str));
    }
}
