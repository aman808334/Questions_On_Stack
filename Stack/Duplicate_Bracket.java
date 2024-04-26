import java.util.Stack;

class Duplicate_Bracket {

    public static boolean duplicate(String str){

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c==')'){
                if(st.peek()=='(')
                  return true;
                else{
                    while(st.peek()!='(')
                      st.pop();

                   st.pop();   
                }  

            }
            else{
                st.push(c);
            }
        }

       return false; 

    }

    public static void main(String[] args) {
        String str = "((a+b)(a-c))";
        System.out.println(duplicate(str));
    }
    
}
