import java.util.ArrayList;
import java.util.List;

interface FacebookComponent
{
    public void add(FacebookComponent e);
    public void remove(FacebookComponent e) ;
    public List<FacebookComponent> getSubordinates();
    public void setParent(FacebookComponent p);
    public String getTitle();
    public String getType();
}

class GroupPage implements FacebookComponent
{
   
    String title="";
    private List<FacebookComponent> subordinates;
    private FacebookComponent parent;
    public String type;

    GroupPage(String title,String type)
    {
        this.title = title;
        this.type = type;
        subordinates = new ArrayList<FacebookComponent>();

    }
    public void add(FacebookComponent e)
    {
        subordinates.add(e);
        e.setParent(this);
    }
    public void remove(FacebookComponent e)
    {
        subordinates.remove(e);
    }
    public List<FacebookComponent> getSubordinates()
    {
        return subordinates;
    }
    public void setParent(FacebookComponent p)
    {
        parent = p;
    }
    public String getTitle()
    {
        return title;
    }
    public String getType()
    {
        return type;
    }
    
    public String toString()
    {
        if(parent==null)
        {
            return ("Group :[ Title : " + title + ",  " + type+" ]");

        }
        return ("Group :[Under: "+parent.getTitle().toString()+", Title : " + title + ",  " + type+" ]");

    }
}

class User implements FacebookComponent
{
    String title="";
    public String type="user";
    private FacebookComponent parent;
    

    User(String title)
    {
        this.title = title;
        

    }
    public void add(FacebookComponent e)
    {
        System.out.println("Error");
    }
    public void remove(FacebookComponent e)
    {
        System.out.println("Error");
    }
    public List<FacebookComponent> getSubordinates()
    {
        System.out.println("Error");
        return null;
    }
    public void setParent(FacebookComponent p)
    {
        //System.out.println("Error.can't set parent");
        parent=p;
    }
    public String getTitle()
    {
        return title;
    }
    public String getType()
    {
        return type;
    }
    public String toString()
    {
        return ("User :[Under: "+parent.getTitle().toString()+", Title : " + title + "  ]");

    }
}




public class FacebookComposite {
    public static void main(String[] args)
    {

        FacebookComponent user1=new User("Sajid");
        FacebookComponent user2=new User("Rain");
        FacebookComponent user3=new User("Jabed");
        FacebookComponent user4=new User("Shourav");
        FacebookComponent user5=new User("Sachi");
        FacebookComponent user6=new User("Raju");
        FacebookComponent user7=new User("Anika");

        
        FacebookComponent austcse39=new GroupPage("Aust Cse 39","closed");
        FacebookComponent austcsecommunity=new GroupPage("Aust Cse community","open");
        FacebookComponent austFamily=new GroupPage("Aust Family","open");

        austFamily.add(austcsecommunity);
        austFamily.add(austcse39);

        austcsecommunity.add(user1);
        austcsecommunity.add(user2);
        austcsecommunity.add(user3);
        austcsecommunity.add(user4);

        austcse39.add(user5);
        austcse39.add(user6);
        austcse39.add(user7);

        /**
         * print all Groups(Composite object) and memebers(leaf/ simple object) 
         * of the organization
         */
       System.out.println(austFamily); 
       System.out.println("---"); 
       List<FacebookComponent> components= austFamily.getSubordinates();
       while (components.size()!=0)
       {

            FacebookComponent component = components.remove(0);
            System.out.println(component);
            if( !component.getType().equals("user") )
            {
                for (FacebookComponent c : component.getSubordinates()) {
                    //System.out.println(emp);
                    components.add(c);
                 }
            }
            else
            {
                System.out.println(component);
            }
           

       }
        

    }
}
