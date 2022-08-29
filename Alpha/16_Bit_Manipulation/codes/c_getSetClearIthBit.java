public class c_getSetClearIthBit {
    public static  int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static  int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n|bitMask;
    }

    public static  int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n&bitMask;
    }

    public static int updateIthBit(int n , int i, int newBit) {
        // Another method.
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // }
        // else {
        //     return setIthBit(n, i);
        // }

        // clear bit.
        n = clearIthBit(n, i); // first clear n at particular ith position.
        int bitMask = newBit << i;
        return n|bitMask;
    }
    public static void main(String[] args) {
        System.out.println(getIthBit(10, 2)); // at ith = 2 , bit is 0. ans: 0
        System.out.println(getIthBit(10, 3)); // at ith = 3 , bit is 1. ans: 1

        System.out.println(setIthBit(10, 2)); // at ith = 2 , ith bit now become 1. So Binary is: 1110. So ans: 14


        System.out.println(clearIthBit(10, 1)); // at ith = 1 , ith bit now become 0. So Binary is: 1000. So ans: 8

        System.out.println(updateIthBit(10, 2, 1)); // ans: 14
    }
}
