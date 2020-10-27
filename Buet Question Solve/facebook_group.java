import java.util.ArrayList;

interface Members
{
    public String getName();
    public void setNewsFeed(String post);
}
class NormalUser implements Members
{
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




    }
}