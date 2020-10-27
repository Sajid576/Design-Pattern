import java.util.ArrayList;
import java.util.List;


class Base
{
    
    private static Base instance=new Base();
    protected Base(){}
    public static Base getInstance()
    {
        return instance;
    }

}
class Derived1 extends Base
{
    static int count = 0;
    static Derived1 instance=new Derived1();
    private Derived1(){}
    public static Base getInstance()
    {
        if(Derived1.count==5)
        {
            return null;
        }
        Derived1.count++;
        System.out.println(Derived1.count+" instances of Derived1 created");
        return Derived1.instance;
    }
}
class Derived2 extends Base
{
    static int count = 0;
    static Derived2 instance=new Derived2();
    private Derived2(){}
    public static Base getInstance()
    {
        if(Derived2.count==10)
        {
            return null;
        }
        Derived2.count++;
        System.out.println(Derived2.count+" instances of Derived2 created");
        return Derived2.instance;
    }
}

public class Singleton {
    public static void main(String[] args)
    {
        ArrayList<Base> mylist=new ArrayList<Base>();

        
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());
        mylist.add(Derived1.getInstance());

        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());
        mylist.add(Derived2.getInstance());

        System.out.println(mylist);


    }
}
