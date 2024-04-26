
// Exclusive Time of Functions  

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Exclusive_Time_Of_Function {

    static class Triplet{
        int id;
        int startime;
        int childtime;
    }
    public static int[] exclusiveTime(int n, List<String> log){

        Stack<Triplet> st = new Stack<>();
        int ans[] = new int[n];

        for (String s : log) {
            String logs[] = s.split(":"); // 0 -> id, 1-> start/end & 2 -> time

            if(logs[1].equals("start")){ // Will push in Stack

                Triplet t = new Triplet();
                t.id = Integer.parseInt(logs[0]);
                t.startime = Integer.parseInt(logs[2]);
                t.childtime = 0; // Initially '0'
                st.push(t);

            }
            else{ // If end

                Triplet t = st.pop();
                int interval = Integer.parseInt(logs[2]) - t.startime +1;
                int time = interval - t.childtime;
                ans[t.id] += time;

                if(!st.isEmpty()){
                    st.peek().childtime += interval;
                }
            }
        }
        
       return ans; 
    }

    public static void main(String[] args) {

        int n = 2;
        List<String> log = new ArrayList<>();
        log.add("0:start:0");
        log.add("1:start:2");
        log.add("1:end:5");
        log.add("0:end:6");

        int ans[] = exclusiveTime(n,log);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }  
    }  
}
