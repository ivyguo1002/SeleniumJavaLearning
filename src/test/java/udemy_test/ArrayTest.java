package udemy_test;

import org.testng.annotations.Test;

import java.util.*;

public class ArrayTest {
    @Test
    public void TestArrayList(){
        ArrayList<String> a=new ArrayList<String>();
        a.add("rahul");
        a.add("java");
        a.add("java");
        System.out.println(a);
        a.add(0, "student");
        System.out.println(a);
        a.remove(1);
        a.remove("java");
        System.out.println(a);
        System.out.println(a.get(2));
        System.out.println(a.contains("java"));
        System.out.println(a.indexOf("rahul"));
        System.out.println(a.isEmpty());
        System.out.println(a.size());

    }

    @Test
    public void TestHashSet(){
        //HashSet treeset, LinkedHashset implements Set interface
        // does not accept duplicate values
        // There is no guarantee elements stored in sequential order..
        // Random order
         HashSet<String> hs= new HashSet<String>();
         hs.add("USA");
         hs.add("UK");
         hs.add("INDIA");
         hs.add("he");
         hs.add("she");
         hs.add("INDIA");
         System.out.println(hs);
         System.out.println(hs.remove("UK"));
         System.out.println(hs.isEmpty());
         System.out.println(hs.size());
         Iterator<String> i=hs.iterator();
         while(i.hasNext())
         { System.out.println(i.next()); }
    }

    @Test
    public void TestHashMap(){
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(0, "hello");
        hm.put(1, "Gudbye");
        hm.put(42, "morning");
        hm.put(3, "evening");
        System.out.println(hm.get(42));
        hm.remove(42);
        System.out.println(hm.get(42));
        Set sn= hm.entrySet();
        Iterator it =sn.iterator();
        //hashtable -pass table set collections
        while(it.hasNext()) {
            System.out.println(it.next());
            Map.Entry mp = (Map.Entry) it.next();
            System.out.println(mp.getKey());
            System.out.println(mp.getValue());
        }

        for(var entry : hm.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    @Test
    //difficult
    public void TestCollections(){
        int[] array = {4,5,5,5,4,6,7,8,6};
        //printing number and quantity
        //4 - 2, 5 - 3, 6 - 2, 7 - 1, 8 - 1
        var list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++){
            if(!list.contains(array[i]))
                list.add(array[i]);
        }
        for (var number : list){
            int quatity = 0;
            for(int j = 0; j < array.length; j++){
                if(array[j] == number)
                    quatity++;
            }
            System.out.println(number);
            System.out.println(quatity);
        }
    }
}
