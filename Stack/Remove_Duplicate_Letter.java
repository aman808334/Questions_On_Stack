
// Remove Duplicate Letter

/*
U r given a string
Remove duplicate letters from the given string so that every letter appears only once.
The result should be the smallest in lexicographical order among all possible options.

Example -

Input -> "cbacdcbc"
Output -> "acdb"

Input -> "bcabc"
Output -> "abc"
*/

import java.util.HashMap;
import java.util.Stack;

class Remove_Duplicate_Letter {

    public static String remove(String str){

        // Creating frequency HM of the given string
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        //Creating a boolean HM
        HashMap<Character,Boolean> hmm = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            hmm.put(str.charAt(i), true);
        }

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0)-1); // Decrease the freq. to char that is push in stack

            while(!st.isEmpty() && st.peek()>c && hm.get(st.peek())>=1 && hmm.get(c) == true){ // = b/c  bbcaac

                hmm.put(st.peek(), true); // This line will be written 1st
                st.pop();     
            }

            if(hmm.get(c) == true){
                st.push(c);
                hmm.put(str.charAt(i), false);

            }
        }

       Stack<Character> stt = new Stack<>();
       while(!st.isEmpty())
         stt.push(st.pop());

       String ans ="";
       while(!stt.isEmpty())
        ans += stt.pop();

       return ans;
    }

    public static void main(String[] args) {

        String str = "abacb";
        System.out.println(remove(str));
    }
} 
