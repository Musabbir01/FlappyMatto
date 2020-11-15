package Assignment;

/**
 * Created by admin on 12/16/2017.
 */
import java.lang.reflect.Array;
import java.util.*;
public class Prob_1 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        while (true) {
            System.out.println("Give Numbers:");
            int k = x.nextInt();
            if (k != 0)
                arrayList.add(k);
            else
                break;
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }

    }

    }

