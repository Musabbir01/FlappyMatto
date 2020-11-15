package AssignmentTest;

/**
 * Created by admin on 12/16/2017.
 */
import java.util.*;
public class FindDivisor {

        int index, NoOfFactors;

        public FindDivisor(int i, int FindFactor)
        {
            index = i;
            NoOfFactors = FindFactor;
        }

        static int countFactors(int n)
        {
            int count = 0;
            for(int i=1;i<=n;i++){
                if(n%i==0)
                    count++;
            }

            return count;
        }

        static void printOnBasisOfFactors(int arr[], int n)
        {
            FindDivisor num[] = new FindDivisor[n];

            for (int i=0; i<n; i++)
            {
                num[i] = new FindDivisor(i,countFactors(arr[i]));
            }
            /*int temp;
            for(int i=0;i<num.length-1;i++){
                for(int j=i+1;j>num.length;j++){
                    if(num[i].no_of_fact<num[j].no_of_fact){
                        temp=num[i].index;
                        num[i].index=num[j].index;
                        num[j].index=temp;

                    }
                }
            }*/
            Arrays.sort(num,new Comparator<FindDivisor>() {

                @Override

                public int compare(FindDivisor e1, FindDivisor e2) {

                    if (e1.NoOfFactors == e2.NoOfFactors)
                        return e1.index > e2.index ? -1 : 1;

                    return e1.NoOfFactors < e2.NoOfFactors ? -1 : 1;
                }

            });

            for (int i=0; i<n; i++) {
                System.out.print(arr[num[i].index ]+ " ");
            }
        }

        // Driver program to test above
        public static void main(String[] args)
        {
            ArrayList<Integer> arrayList=new <Integer>ArrayList(1000);
            Scanner x=new Scanner(System.in);

            while (true) {

                int k = x.nextInt();
                if (k < 100000) {
                    if (k != 0)
                        arrayList.add(k);
                    else
                        break;
                }
            }
            int[] array = new int[arrayList.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = arrayList.get(i);
            }

            int arr[] = {5, 16, 3, 44, 35};

            printOnBasisOfFactors(array, array.length);
        }
    }

