
public class CatchThrow {
private static void a() {
    String  intNumber = "5A";
    Integer.parseInt(intNumber);
}
private static void b() {
           a();
    }

public static void main(String[] args) {
    try{ 
    b();}
    catch(Exception e){}
}}

