// Search in Sorted Matrix
// Company: Oracle
// Time complexity ===> Depand upon row or column. if row > colum O(n)
// Time complexity ===> Depand upon row or column. if row < colum O(m)
// Time complexity ===> O(m+n)

public class d_searchInSorted {
    public static boolean search(int nums[][], int x) {
        int n = nums.length-1; // total no. of rows
        int m = nums[0].length-1; // total no. of columns.
        
        int i = 0 , j = m; // i ---> row no. , j ---> column no.
        while(i<=n && j>=0) {
            if(nums[i][j] == x) {
                System.out.println("Found key at (" +i+ " , " +j+")");
                return true;
            }
            else if(nums[i][j] < x) {
                i++; // row++
            }
            else {
                j--; // colum++
            }
        }
        System.out.println("Key is not found");
        return false;
    }
    public static void main(String[] args) {
        int nums[][] = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50},
        };
        System.out.println("Key is found? ");
        System.out.println(search(nums, 48));
    }
}
