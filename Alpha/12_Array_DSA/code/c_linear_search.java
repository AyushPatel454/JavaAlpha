// linear search

public class c_linear_search {
    public static int linearSearch(int numbers[],int key) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==key) {
                return i;
            }
        }
        return -1; // key is not found.
    }

    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10,12,14,16,18};
        int key = 10;

        int index_no = linearSearch(numbers, key);
        System.out.println(key+" is on index no:"+index_no);
    }
}
