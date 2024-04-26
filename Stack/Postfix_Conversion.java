import java.util.Stack;

class Postfix_Conversion {

    public static String infix(String str){

        Stack<String> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                st.push(c+""); // Convert into string & then push
            }
            else{
                String num2 = st.pop();
                String num1 = st.pop();
                st.push("("+num1+c+num2+")");
            }
        }

       return st.peek(); 
    }

    public static String prefix(String str){

        Stack<String> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                st.push(c+""); // Convert into string & then push
            }
            else{
                String num2 = st.pop();
                String num1 = st.pop();
                st.push(c+num1+num2);
            }
        }

       return st.peek(); 
    }
    
    public static void main(String[] args) {
        
        String str = "264*8/+3-";
        System.out.println(infix(str));
        System.out.println(prefix(str));

    }
}
