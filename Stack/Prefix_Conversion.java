import java.util.Stack;

class Prefix_Conversion {

    public static String infix(String str){

        Stack<String> st = new Stack<>();

        for(int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                st.push(c+""); // Convert into string & then push
            }
            else{
                String num1 = st.pop();
                String num2 = st.pop();
                st.push("("+num1+c+num2+")");
            }
        }

       return st.peek(); 
    }

    public static String postfix(String str){

        Stack<String> st = new Stack<>();

        for(int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                st.push(c+""); // Convert into string & then push
            }
            else{
                String num1 = st.pop();
                String num2 = st.pop();
                st.push(num1+num2+c);
            }
        }

       return st.peek(); 
    }
    
    public static void main(String[] args) {
        
        String str = "-+2/*6483";
        System.out.println(infix(str));
        System.out.println(postfix(str));

    }
}
