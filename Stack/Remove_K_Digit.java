
// Remove 'k' digit

/*
U r given a string of digit & a no. 'k' 
U've to remove 'k' digit from given string such that number should be minimum

Note - 

. There shouldn't be a leading '0' in the answer. Example - "0200"
. If answer is empty then we've to return "0" 

*/

import java.util.Stack;

class Remove_K_Digit {

     public static String remove(String num, int k) {

        Stack<Character> st = new Stack<>();

        for(int i=0; i<num.length(); i++){

            while(!st.isEmpty() &&  (st.peek() - '0') > (num.charAt(i) - '0')){
                if(k>0){
                    st.pop();
                    k--;
                }

                if(k==0){
                    break; // Break is Compulsory, otherwise TLE
                }
                  
            }

            st.push(num.charAt(i));
        }

        /* It can happen that iteration is over but we haven't removed the 'k' digit.(Example - 10 & k = 2).
        In this case we will delete the remaining digits from ending*/
        while(!st.isEmpty() && k > 0 ){
            st.pop();
            k--;
        }
         
      // Taking another Stack so that number is reversed
      Stack<Character> st1 = new Stack<>();
      while(!st.isEmpty())
        st1.push(st.pop());

      //Removing '0' at starting Example - "0200".
      while(!st1.isEmpty() && st1.peek()=='0')
         st1.pop();

      String ans ="";
      while(!st1.isEmpty())
        ans += st1.pop();

      // If answer is empty then we've to return "0"
      if(ans == ""){
          return "0";
      }  

      return ans;  
    }

    public static void main(String[] args) {
        
        String num = "10200";
        int k = 1;
        System.out.println(remove(num,k));

    }  
}
