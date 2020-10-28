import java.util.ArrayList;
import java.util.List;



interface EmployeeComponent
{
   public void add(EmployeeComponent e);
   public void remove(EmployeeComponent e) ;
   public List<EmployeeComponent> getSubordinates();
   public void setParent(EmployeeComponent p);
   public String getName();
   
}

class Employee implements EmployeeComponent{
   private String name;
   private String dept;
   private int salary;
   private List<EmployeeComponent> subordinates;
   private EmployeeComponent parent;

   // constructor
   public Employee(String name,String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<EmployeeComponent>();
   }

   public void add(EmployeeComponent e) {
      subordinates.add(e);
      e.setParent(this);
       
   }

   public void remove(EmployeeComponent e) {
      subordinates.remove(e);
   }

   public List<EmployeeComponent> getSubordinates(){
     return subordinates;
   }

   public void setParent(EmployeeComponent p)
   {
      parent = p;
   }
   public String getName()
   {
       return name;
   }
   public String toString(){
      if(parent==null)
      {
          return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
      }
      return ("Employee :[Under: "+parent.getName().toString()+", Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
   }   
}

public class Company {
    public static void main(String[] args) {
    
       EmployeeComponent BOSS = new Employee("Sajid","Boss", 30000);
 
       EmployeeComponent dev1 = new Employee("Rain","Developer-1", 20000);
 
       EmployeeComponent manager1 = new Employee("Jabed","Manager-1", 20000);
 
       EmployeeComponent dev2 = new Employee("Sachi","Developer-2", 10000);
       EmployeeComponent manager2 = new Employee("Nishan","Manager-2", 10000);
 
       EmployeeComponent dev3 = new Employee("Shourav","Developer-3", 10000);
       EmployeeComponent dev4 = new Employee("Saif","Developer-4", 10000);
 
       BOSS.add(dev1);
       BOSS.add(manager1);
 
       manager1.add(manager2);
       manager1.add(dev2);
 
       manager2.add(dev3);
       manager2.add(dev4);
 
      

       //print all employees of the organization
       System.out.println(BOSS); 
       System.out.println("---"); 
       List<EmployeeComponent> employees= BOSS.getSubordinates();
       while (employees.size()!=0)
       {

            EmployeeComponent employee = employees.remove(0);
            System.out.println(employee);
            for (EmployeeComponent emp : employee.getSubordinates()) {
               //System.out.println(emp);
               employees.add(emp);
            }

       }
       
       

    }
 }

 /**
  * This code is not following the principle of SRP.
  As Employee class is taking responsibility of both simple/leaf type objects and Composite/complex
  type objects.
   
  */