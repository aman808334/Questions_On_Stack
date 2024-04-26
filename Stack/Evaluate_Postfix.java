import java.util.Stack;

class Evaluate_Postfix{

    public static int evaluate(String str){

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);
            
            if(Character.isDigit(c)){
                st.push(c-'0'); // Convert character number to integer & push it to the stack
            }
            else{
                int num2 = st.pop();
                int num1 = st.pop();
                int answer = calculate(num1, c, num2);
                st.push(answer);
            }
        }

       return st.peek();
    }

    public static int calculate(int num1, char o, int num2){

        if(o=='+')
         return num1+num2;
        if(o=='-')
         return num1-num2;
        if(o=='*')
         return num1*num2;
        if(o=='/')
         return num1/num2;
 
 
    return 0;

    }

    public static void main(String[] args) {
        String str ="264*8/+3-";
        System.out.println(evaluate(str));
    }
}