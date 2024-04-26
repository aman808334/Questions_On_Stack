
// Score Of Parentheses

/*

U'll be given a balanced string containing only '(' & ')'

Rule of Score -

-> () -> 1
-> ()() -> Addition will be used in this case i.e. 1+1
-> (()) -> Score * 2 

*/

import java.util.Stack;

class Score_Of_Parentheses {

    public static int score(String str){

        Stack<String> st = new Stack<>(); // Will push opening bracket & score. String b/c score can be of more than one digits

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == '('){
                st.push("(");
            }

            else{
                if(st.peek() == "("){
                    st.pop();
                    st.push("1");
                }

                else{ // It can be number i.e score
                    int x = 0;
                    while(st.peek() != "("){ // For this type of case - ( () () ) i.e In stack, (1 1
                       x =  x + Integer.parseInt(st.pop());
                    }
                    st.pop();
                    st.push(2*x+"");

                }
            }
        }
        
        /* Now, Iteration of given string is completed. Stack will contain number, one of multiple. 
        Multiple number if input is like - "()()", ()(()), etc.
        */ 
        int score = 0;
        while(!st.isEmpty()){
        score = score + Integer.parseInt(st.pop());
        }

       return score;
    }

    public static void main(String[] args) {
        String str = "()()(())";
        System.out.println(score(str));
    }
}
