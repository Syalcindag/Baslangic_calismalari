class B{ 
    int xB=2;
  B(int i,int j) {
       //super(); Hiçbir etkisi yok
    System.out.println("B nin constr. çalıştı, parametreler:"+i+"ve "+j); } 
   
  B (int i){
        System.out.println("B nin ikinci constr. çalıştı, parametreler:"+i);}
  
B(){
     System.out.println("B nin boş constr. Çalıştı");}

    void metodB()
    {
        System.out.println("metod B:"+xB);
    }
}
class C extends B{
    int xC=1;
    int xB=4;
    C(int m,int n){
      //super(m); İstenirse böyle de kullanılır.
      super(m,n);
      System.out.println("C nin constr. çalıştı, parametreler:"+m+" ve "+n); }
    C(int m){
     super(m);
      System.out.println("C nin ikinci constr. çalıştı, parametreler:"+m); }
    C(int m,int n,int k){
     super();
      System.out.println("C nin üçüncü constr. çalıştı");}
    void metodC()
    {
        System.out.println("metod C"); }
   @Override
    void metodB()
    {
         System.out.println("C deki metod b:"+super.xB);
         super.metodB();   }
}
public class dnm {
    public static void main(String args[])
    {
        B b1=new B(3,5);
        B b2=new B(7);
       C c1=new C(10,20); 
        C c2=new C(6);
        C c3=new C(7,8,9);
       System.out.println(b1.xB);
       b1.metodB();
        System.out.println(c1.xB);
        c1.metodB();        
    }
 }
