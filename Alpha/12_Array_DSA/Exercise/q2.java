// ===> Panding.

public class q2 {
    public static int search(int[] nums, int target) {
        int starting = 0;
        int ending = nums.length-1;
        int mid;

        while(starting <= ending) {
            mid = (starting+ending)/2;

            if(nums[mid] == target) {
                return mid;
            }

            else if(nums[starting] < nums[ending]) {
                if(nums[mid] < target) {
                    starting = mid + 1;
                }
                else {
                    ending = mid - 1;
                }
            }

            else { // nums[starting] > nums[ending]
                if(nums[starting]<=target) {
                    if(nums[starting] == target) {
                        return starting;
                    }
                    else if(nums[mid]<target) {
                        starting = mid + 1;
                    }
                    else {
                        ending = mid - 1;
                    }
                }
                else{
                    if(nums[ending] == target) {
                        return ending;
                    }
                    else if(nums[mid]>target) {
                        // starting = mid + 1;
                        ending = mid - 1;
                    }
                    else {
                        // ending = mid - 1;
                        starting = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int nums2[] = {1,3};
        int nums3[] = {1};
        int nums4[] = {5,1,3}; 
        System.out.println(search(nums, 0)); // 4
        System.out.println(search(nums, 3)); // -1
        System.out.println(search(nums3, 0)); // -1
        System.out.println(search(nums2, 3)); // 1
        System.out.println(search(nums4, 3)); // 2
    }
}