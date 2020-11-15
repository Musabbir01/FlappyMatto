package LabAssignment;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by admin on 12/16/2017.
 */
public class FindDivisors  {

    public void Divisors(int num){

        System.out.println("Divisors of "+num+" are:");

        for(int i=1;i<=num;i++){
            if(num%i==0){
                System.out.println(i);

            }


        }

    }
}
