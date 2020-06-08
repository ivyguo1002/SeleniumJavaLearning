package udemy_test;

import org.testng.annotations.Test;

public class JavaTest {
    @Test
    public void TestString() {
        //String : it is one of the prebuilt class in java
/* 1.String literal
2.by creating object of string*/
        String a = " javatraining";//string
        System.out.println(a.charAt(2));
        System.out.println(a.indexOf("e"));
        System.out.println(a.substring(3, 6));
        System.out.println(a.substring(5));
        System.out.println(a.concat("rahul teaches"));
//a.length()
        System.out.println(a.trim());
        a.toUpperCase();
        a.toLowerCase();
//split
        String arr[] = a.split("t");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(a.replace("t", "s"));
    }

    @Test
    public void TestLoop() {
        //While loop
//1 to 10
        int i = 10;

/* while(i>0)
{
System.out.println(i);
i--;//i=2
}
}*/
        int j = 20;
        do {
            System.out.println(j);
            j++;

        } while (j > 30);// 1 loop of execution is guarantee

    }


    @Test
    public void TestLoop2() {

        for(int i = 0;i<10;i=i+3)
        {
            if (i == 9)
                System.out.println(" 9 is displayed");
            else
                System.out.println("I didnot find");//
        }

    }
}