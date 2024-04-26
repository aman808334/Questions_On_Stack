
// Trapping Rain Water

public class Trapping_Rain_Water2 {

    public static int trapping(int arr[]){

        int lmax = 0;
        int rmax = 0;
        int l = 0; // Will find left max
        int r = arr.length-1; // Will find right max
        int totalwater = 0;

        while(l<r){
            lmax = Math.max(lmax, arr[l]);
            rmax = Math.max(rmax, arr[r]);

            // Smaller one will hold water & move
            if(lmax<rmax){
                totalwater += lmax-arr[l];
                l++;
            }

            else{
                 totalwater += rmax-arr[r];
                 r--;
            }
        }

        return totalwater;
    }

    public static void main(String[] args) {
        
        int arr[] = {4,1,0,2,1,0,1,3,2,1,2,1}; 
        System.out.println(trapping(arr));
    }    
}