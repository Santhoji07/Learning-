//Static methods can access static variables directly but need an object to access non-static variable

import java.util.Scanner;

public class a19{

    static int staticvar=20;
    int nonstaticvar=10;

    static void StaticMethod(){
        System.out.println("Static Method:"+ staticvar);

        a19 obj= new a19();
        System.out.println("Non-Static Method:"+ obj.nonstaticvar);

    }
    public static void main(String[] args){
        StaticMethod();
    }
}