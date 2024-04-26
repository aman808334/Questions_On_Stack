
// Smallest number following pattern

/*
U r given a pattern of upto 8 length containing character 'i' & 'd'
'd' stands for decreasing & 'i' stands for increasing
U have to print the smallest no. using the digits 1 to 9 without repetition, such that the digit decreases following
'd' & increases following 'i' i.e. ³d²d¹i⁷d⁶d⁵d⁴i⁹d⁸

Input -> ddidddid
Output -> 321765498
*/

import java.util.ArrayList;
import java.util.Stack;

class Smallest_No_Following_Pattern {

    public static ArrayList<Integer> solve(String str){

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int num = 1;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='d'){
                st.push(num);
                num++;
            }
            else{
                st.push(num);
                num++;
                while(!st.empty())
                    ans.add(st.pop());
            }
        }
        
        st.push(num);
        while(!st.empty())
            ans.add(st.pop());
        
       return ans;
    }

    public static void main(String[] args) {
        
        String str = "ddidddid";
        System.out.println(solve(str));
    }
}
