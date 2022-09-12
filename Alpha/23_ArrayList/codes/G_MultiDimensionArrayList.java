import java.util.ArrayList;

public class G_MultiDimensionArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        mainList.add(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        mainList.add(list2);

        System.out.println("List: "+list);
        System.out.println("List2: "+list2);
        System.out.println("Main List: "+mainList);

        // print main list all elements
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        
        System.out.println("=========================================");
        // <====== NEW CODE ======>

        ArrayList<ArrayList<Integer>> mainList2 = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            arr1.add(i*1);  // 1 2 3 4 5
            arr2.add(i*2);  // 2 4 6 8 10
            arr3.add(i*3);  // 3 6 9 12 15
        }

        arr2.remove(1);
        arr2.remove(0);
        
        mainList2.add(arr1);
        mainList2.add(arr2);
        mainList2.add(arr3);
        
        System.out.println("Main List 2: "+mainList2);

        // print main list 2 all elements
        for(int i = 0; i < mainList2.size(); i++ ) {
            ArrayList<Integer> current = mainList2.get(i);
            for (int j = 0; j < current.size(); j++) {
                System.out.print(current.get(j)+" ");
            }
            System.out.println();
        }
    }
}
