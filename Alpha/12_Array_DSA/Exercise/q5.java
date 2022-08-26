public class q5 {

    // display
    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] solution(int arr[]) {
        int[] fact= new int[arr.length];
        for (int i = 0; i < fact.length; i++) {
            if(arr[i] <= 0) {
                fact[i] = arr[i];
                continue;
            }
            int temp = arr[i];
            int ans = 1;
            while(temp>=1) {
                ans = ans * temp;
                temp--;
            }
            fact[i] = ans;
        }
        // display(fact);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(i!=j && j!=k && j!=k) {
                        if(arr[i]+arr[j]+arr[k] == 0) {
                            int ans[] = {arr[i],arr[j],arr[k]};
                            return ans;
                        }
                    }
                }
            }
        }
        return fact;
    }
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        solution(nums);
        
    }
}
