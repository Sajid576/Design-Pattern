import java.util.ArrayList;

interface Members
{
    public String getName();
    public void showNewsFeed(FacebookGroup group);
    public void setPost(String post,FacebookGroup group);
}
class NormalUser implements Members
{
    final Boolean admin=false;
    private String name;
   

    NormalUser(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void showNewsFeed(FacebookGroup group)
    {
        System.out.println(group.getAllPosts()); 
    }
    public void setPost(String post,FacebookGroup group)
    {
        group.addPost(post);
    }
}
class AdminUser implements Members
{
    final Boolean admin=true;
    private String name;
   

    AdminUser(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void showNewsFeed(FacebookGroup group)
    {
        System.out.println(group.getAllPosts()); 
    }
    public void setPost(String post,FacebookGroup group)
    {
        group.addPost(post);
    }
}

class FacebookGroup
{
    private static final FacebookGroup INSTANCE=new FacebookGroup();
    String title="";
    ArrayList<Members>users=new ArrayList<Members>();
    ArrayList<String> group_posts= new ArrayList<String>();
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
    void addPost(String post)
    {
        this.group_posts.add(post);
    }
    ArrayList<String>  getAllPosts()
    {
        return this.group_posts;
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
        //group.showUserList();

        
        user1.setPost("Hello,I am a nodejs develpoer", group);
        user2.showNewsFeed(group);
        user3.showNewsFeed(group);
        user1.setPost("Hello,I am developing game", group);
        user3.setPost("Hello,I am a php develpoer", group);
        user3.showNewsFeed(group);
    }
}