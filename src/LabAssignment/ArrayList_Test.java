package LabAssignment;

/**
 * Created by admin on 12/16/2017.
 */

import java.util.*;
public class ArrayList_Test {
    public static void main(String []args){
        ArrayList<Integer> arrayList=new <Integer>ArrayList();
        Scanner x=new Scanner(System.in);

        while (true){
            System.out.println("Give Numbers:");
            int k=x.nextInt();
            if (k!=0)
                arrayList.add(k);
            else
                break;
        }

        /*arrayList.add(100);
        arrayList.add(59);
        arrayList.add(34);
        arrayList.add(200);
        arrayList.add(10);
        arrayList.add(20);*/
        System.out.println("Before sorting");
        for(int k:arrayList){
            System.out.println(k);
        }
        System.out.println("After sorting");
        int temp;
        for(int i=0;i<arrayList.size()-1;i++){
            for(int j=i+1;j<arrayList.size();j++){
                if(arrayList.get(i)>arrayList.get(j)){
                    temp=arrayList.get(i);
                    arrayList.set(i,arrayList.get(j));
                    arrayList.set(j,temp);

                }
            }
        }
        for(int k:arrayList){
            System.out.println(k);
        }
        FindDivisors FD_obj= new FindDivisors();
        System.out.println("Divisors of all sorted numbers are given below:");
        for(int k:arrayList){
            FD_obj.Divisors(k);

        }

    }
}
