package LabAssignment_02;

import java.util.*;
public class Main {

    private static ArrayList<Criminal>arrayList=new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while(true)
        {
            int id =scanner.nextInt();
            String name=scanner.next();
            String crime=scanner.next();
            int personCell=scanner.nextInt();
            int jailSentence=scanner.nextInt();

            if(id<0)break;
            Criminal criminal=new Criminal(id,name,crime,personCell,jailSentence);
            arrayList.add(criminal);
        }

        System.out.println("Query a :");
        Collections.sort(arrayList, new Comparator<Criminal>() {
            @Override
            public int compare(Criminal o1, Criminal o2) {
                if (o1.getJail_sentence_duration()> o2.getJail_sentence_duration()) {
                    return 1;
                } else if (o1.getJail_sentence_duration() < o2.getJail_sentence_duration()) {
                    return -1;
                } else {
                    if (o1.getId() > o2.getId()) {
                        return 1;
                    } else if (o1.getId() < o2.getId()) {
                        return -1;
                    }
                    return 0;
                }
            }
        });
        for(int i=0;i<arrayList.size();i++)
        {
            Criminal criminal=arrayList.get(i);
            System.out.println("Name: "+criminal.getName()+" ID: "+criminal.getId());
        }


        System.out.println("Query b :");

        HashMap<String,Integer>unique=new HashMap<>();
        for(int i=0;i<arrayList.size();i++)
        {
            Criminal criminal=arrayList.get(i);
            if(unique.containsKey(criminal.getCrime()))
            {
                int cnt=unique.get(criminal.getCrime());
                cnt++;
                unique.put(criminal.getCrime(),cnt);
            }
            else
            {
                unique.put(criminal.getCrime(),1);
            }

        }
        for (String name: unique.keySet()){

            String key =name.toString();
            int value = unique.get(name);
            System.out.println("Crime : "+key + " Criminals :" + value);
        }

        System.out.println("Query c :");

        HashMap<Integer,Integer>uniqueCell=new HashMap<>();
        for(int i=0;i<arrayList.size();i++)
        {
            Criminal criminal=arrayList.get(i);
            if(uniqueCell.containsKey(criminal.getPrison_Cell_No()))
            {
                int cnt=uniqueCell.get(criminal.getPrison_Cell_No());
                cnt++;
                uniqueCell.put(criminal.getPrison_Cell_No(),cnt);
            }
            else
            {
                uniqueCell.put(criminal.getPrison_Cell_No(),1);
            }

        }
        for (int cellNo: uniqueCell.keySet()){

            int key =cellNo;
            int value = uniqueCell.get(cellNo);
            System.out.println("Prison Cell : "+key + " Inmates:" + value);
        }

        System.out.println("Query d :");

        HashMap<Integer,ArrayList<Criminal>>uniqueCellCriminal=new HashMap<>();
        for(int i=0;i<arrayList.size();i++)
        {
            Criminal criminal=arrayList.get(i);
            if(uniqueCellCriminal.containsKey(criminal.getPrison_Cell_No()))
            {
                uniqueCellCriminal.get(criminal.getPrison_Cell_No()).add(criminal);
            }
            else
            {
                ArrayList<Criminal>list=new ArrayList<>();
                list.add(criminal);
                uniqueCellCriminal.put(criminal.getPrison_Cell_No(),list);
            }

        }
        for (int cellNo: uniqueCellCriminal.keySet()){

            int key =cellNo;
            System.out.print("Prison Cell : "+key + " Inmates: ");
            ArrayList<Criminal> value = uniqueCellCriminal.get(cellNo);
            for(int i=0;i<value.size();i++)
            {
                System.out.print(value.get(i).getName()+" ");
            }
            System.out.println("");
        }
    }

}
