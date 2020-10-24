/**
 * Dependency Inversion Principle:
 * High level module shouldn't depend on low-level modules.Both should depend on
 * abstractions.Abstractions should not depend on details.Details should 
 * depend on abstractions.  
 * 
 * 
 * 
 * Example-1:(Bad practice)
 */

 /*
 class Worker
 {
     public void work()
     {
         System.out.println("Worker is working under manager");
     }
 } 
 class Manager
 {
     Worker worker;
     void setWorker(Worker worker)
     {
         this.worker = worker;
     }
     void manage()
     {
         worker.work();
     }
 }
class DIP{
    public static void main(String[] args)
    {
        Manager manager=new Manager();
        manager.setWorker(new Worker());

    }
}
*/

 /**
  * According to this code, class Manager= High level Module, class Worker=Low level Module.Worker object is 
    being instantiated inside the Manager class.So,class Manager is dependent on Worker class as Manager wont 
    work if the the object of Worker class is not instantiated.As high level module is depending on the low 
    level module , it is against the principle of DIP. 
    Problems that arise because of this code,is--
  * If we want to add a new worker that extends the class Worker and  works much faster, 
    then 
  */
/*
 class Worker
 {
     public void work()
     {
         System.out.println("Worker is working under manager");
     }
 } 
class SuperWorker extends Worker
{
    public void work()
    {
        System.out.println("New Worker is working much faster under manager");
    }
}

 class Manager
 {
     Worker worker;
     void setWorker(Worker worker)
     {
         this.worker = worker;
     }
     void manage()
     {
         worker.work();
     }
 }

public class DIP{
    public static void main(String[] args)
    {
        Manager manager=new Manager();
        manager.setWorker(new SuperWorker());
        manager.manage();

    }
}
*/
/**
 * Good Practise:There should be abstraction /interface on which Worker,SuperWorker and 
 * Manager will be dependent. So,there is no interacton between high level module and low 
 * level module.
 * 
 * 
 */
interface IWorker
{
    void work();
}
class Worker implements IWorker
{
    public void work()
    {
        System.out.println("Worker is working under manager");
    }
} 
class SuperWorker implements IWorker
{
   public void work()
   {
       System.out.println("New Worker is working much faster under manager");
   }
}

class Manager
{
    IWorker worker;
    void setWorker(IWorker worker)
    {
        this.worker = worker;
    }
    void manage()
    {
        worker.work();
    }
}

public class DIP{
   public static void main(String[] args)
   {
       Manager manager=new Manager();
       manager.setWorker(new Worker());
       manager.manage();

   }
}