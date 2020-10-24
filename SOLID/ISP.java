/**
 * Interface segregation principle:
 * Clients(classes) should not be dependent on the methods that they don't use.
 * 
 */
/*
interface IIWorker
{
    public void work();
    public void eat();
}
class ManWorker implements IIWorker
{
    public void work(){

    }
    public void eat(){

    }
}
class RobotWorker implements IIWorker
{
    public void work(){

    }
    public void eat(){
            //Not applicatble for a Robot worker.So, we dont need this method in this class
    }

}
*/
/**
 * Solution: Split the interface
 */
interface Workable
{
    void work();
}
interface Feedable
{
    void eat();
}

class ManWorker implements Workable,Feedable
{
    public void work()
    {
        System.out.println("Man is working");
    }
    public void eat()
    {
        System.out.println("Man is eating");
    }
}
class RobotWorker implements Workable
{
    public void work()
    {
        System.out.println("Robot is working");
    }
}



public class ISP {
    public static void main(String[] args)
    {
        
    }
}
