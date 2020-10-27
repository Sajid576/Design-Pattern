import java.util.ArrayList;

interface Members
{
    public String getName();
    public void setNewsFeed(String post);
}
class NormalUser implements Members
{
    final Boolean admin=false;
    private String name;
    private ArrayList<String>posts=new ArrayList<String>();

    NormalUser(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setNewsFeed(String post)
    {
        this.posts.add(post);
    }
}
class AdminUser implements Members
{
    final Boolean admin=true;
    private String name;
    private ArrayList<String>posts=new ArrayList<String>();

    AdminUser(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setNewsFeed(String post)
    {
        this.posts.add(post);
    }
}

class FacebookGroup
{
    private static final FacebookGroup INSTANCE=new FacebookGroup();
    String title="";
    ArrayList<Members>users=new ArrayList<Members>();
    String type="open";

    private FacebookGroup(){}
    public static FacebookGroup getInstance()
    {
        return INSTANCE;
    }
    void addUser(Members m)
    {
        users.add(m);
    }
    void RemoveUser(Members m)
    {
        users.remove(m);
    }
    void showUserList()
    {
        for(int i=0; i<users.size(); i++)
        {
            System.out.println(users.get(i).getName());
        }

       
    }

}
public class facebook_group
{
    public static void main(String[] args)
    {
        Members user1=new AdminUser("Sajid");
        Members user2=new NormalUser("Rain");
        Members user3=new NormalUser("Shourav");

        FacebookGroup group= FacebookGroup.getInstance();
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);
        group.showUserList();

        System.out.println("After removing shourav");
        FacebookGroup group1= FacebookGroup.getInstance();
        group1.RemoveUser(user3);
        group.showUserList();
        group1.showUserList();

    }
}