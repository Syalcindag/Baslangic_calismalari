/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pelin
 */
public class StringOrnek {
    public static void main(String args[]){
        char[] dizi={'b','i','r','t','h',' ','d','a','y'};
        char dizi1[]=new char[10];
        String s=new String("hello");
        String s1=new String();
        //s1=null;
        String s2=new String(s);
        String s3=new String(dizi);
        String s4=new String(dizi,6,3);//6.indisten itibaren 3 karakter
        System.out.printf("s1:"+s1+"\ns2:"+s2+"\ns3:"+s3+"\ns4:"+s4);
        System.out.printf("\n s1 uzunluk:"+s1.length()+"\ns2 uzunluk:"+s2.length()+"\ns3 uzunluk:"+s3.length());
        System.out.printf("\n s2 2. karakter:"+s2.charAt(1) +"\n s3 6. karakter:"+s3.charAt(5)+"\n");
        System.out.println("////////////////////////");
           s3.getChars(1,8,dizi1,0);
           //1.indisten 8.indis e kadar dizi1 e 0. indisinden itibaren kopyala
              for (int i=0;i<dizi1.length;i++)
               System.out.print(dizi1[i]);
         System.out.println();
         System.out.println("////////////////////////");
        String a1=new String("hello")   ;
        String a2="goodbye"   ;
        String a3="Happy Birthday";
        String a4="happy birthday";
        String a5=new String("goodbye");
        
        if (a1.equals("hello"))
            System.out.println("a1 equals \"hello\"");
        else
            System.out.println("a1 does not equal \"hello\"");
        
        if (a3=="Happy Birthday")
            System.out.println("a3 = Happy Birthday");
        
        if (a1=="hello")
            System.out.println("a1 is the same object as \"hello\"");
        else
            System.out.println("a1 is not the same object as \"hello\"");
        
        if (a3.equalsIgnoreCase(a4))
            System.out.printf("%s equals %s with case ignored\n",a3,a4);
        else
            System.out.println("a3 does not equal a4");
        
         if (a5==a2)
            System.out.println("a5=a2\n");
        else
            System.out.println("a5!=a2");
         if (a5.equals(a2))
            System.out.println("a5 equals a2");
       System.out.println("////////////////////////");
       String harfler="abcdefghijklmabcdefghijklm";
       System.out.printf("'c' karakterinin indisi:%d\n",harfler.indexOf('c'));
        System.out.printf("'a' karakterinin indisi:%d\n",harfler.indexOf('a',7));//7.indisten baslayarak bak
        System.out.printf("'$' karakterinin indisi:%d\n",harfler.indexOf('$'));
       
        System.out.printf(" son'c' karakterinin indisi:%d\n",harfler.lastIndexOf('c'));//sondan basla, ilk c yi buldugun indisin bastan itibaren yeri
       
        System.out.printf("son'a' karakterinin indisi:%d\n",harfler.lastIndexOf('a',14));//baştan 14. ye gel. sonra geri doğru aynı adımlar.
        System.out.printf("'$' karakterinin indisi:%d\n",harfler.indexOf('$'));
        
       System.out.printf("'def' karakterinin indisi:%d\n",harfler.indexOf("def"));
       System.out.printf("'son def' karakterinin indisi:%d\n",harfler.lastIndexOf("def",29)); 
        System.out.println("////////////////////////");
        char[] dizihali=s.toCharArray();
        for (int i=0;i<dizihali.length;i++)
            System.out.println(dizihali[i]);
       String x=String.valueOf(dizihali);
       System.out.println(x);
}
}
