import java.util.Stack;

class Balanced_Bracket {

    public static boolean balanced(String str){

        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c==')'){
                if(st.empty() || st.peek()!='(')
                  return false;
                else
                  st.pop();  
            }

            else if(c==']'){
                if(st.empty() || st.peek()!='[')
                  return false;
                else
                  st.pop();  
            }

            else if(c=='}'){
                if(st.empty() || st.peek()!='{')
                  return false;
                else
                  st.pop();  
            }

            else if(c == '[' || c == '{' || c == '('){
                st.push(c);
            }

        }
        if(st.empty())
           return true;
        else
           return false;   


    }

    public static void main(String[] args) {
        String str = "[{(a+b)}]";
        System.out.println(balanced(str));
    }
    
}
