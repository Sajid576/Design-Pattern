import java.util.ArrayList;
import java.util.List;

class Employee {
   private String name;
   private String dept;
   private int salary;
   private List<Employee> subordinates;

   // constructor
   public Employee(String name,String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<Employee>();
   }

   public void add(Employee e) {
      subordinates.add(e);
   }

   public void remove(Employee e) {
      subordinates.remove(e);
   }

   public List<Employee> getSubordinates(){
     return subordinates;
   }

   public String toString(){
      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
   }   
}

public class Company {
    public static void main(String[] args) {
    
       Employee BOSS = new Employee("Sajid","Boss", 30000);
 
       Employee dev1 = new Employee("Rain","Developer-1", 20000);
 
       Employee manager1 = new Employee("Jabed","Manager-1", 20000);
 
       Employee dev2 = new Employee("Sachi","Developer-2", 10000);
       Employee manager2 = new Employee("Nishan","Manager-2", 10000);
 
       Employee dev3 = new Employee("Shourav","Developer-3", 10000);
       Employee dev4 = new Employee("Saif","Developer-4", 10000);
 
       BOSS.add(dev1);
       BOSS.add(manager1);
 
       manager1.add(manager2);
       manager1.add(dev2);
 
       manager2.add(dev3);
       manager2.add(dev4);
 
       //print all employees of the organization
       System.out.println(BOSS); 
       
       for (Employee Employee : BOSS.getSubordinates())
       {
            System.out.println(Employee);
          
            for (Employee employee : Employee.getSubordinates()) 
            {
                System.out.println(employee);
            }
       }
       
       

    }
 }