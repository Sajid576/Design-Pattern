/**
 * Task: Make a simple File Explorer. The purpose is to test whether you can identify and
        apply appropriate design patterns in your applications. Further details of your tasks can
        be found below.


-   File Explorer is an application that provides a graphical interface to access
    or browse the files and folders of a file system. You application should
    perform exactly the same.

-   You have to provide a graphical user interface that can show all the files
    in any directory.

-   You have to support two different styles of viewing the files.
-   Provision for switching between different styles should be provided.


-   Your application should provide the functionality so that one can browse
    the folders by double-clicking on them.
-   Your application should be able to run from any folder and show the files
    of that folder. You can create a jar file and test it yourself.
-   A tree like hierarchy of the folders should be shown on the interface and
    users should be able to click on the folders and navigate to that folder
    easily.
 * 
 */


package Assignment;


interface IViewer{
    void view();
}
class WPSviewer implements IViewer{

    @Override
    public void view()
    {   
        System.out.println("Viewing with WPS viewer");
    }
}
class AdobeViewer implements IViewer{

    @Override
    public void view()
    {   
        System.out.println("Viewing with Adobe viewer");
    }
}
/**
 * Suppose, I want to add microsoft edge viewer in later versions
 */
class MicrosoftEdgeViewer implements IViewer
{

    @Override
    public void view()
    {   
        System.out.println("Viewing with Microsoft Edge viewer");
    }
}


class FileFactory{
    static FileFactory obj=null;
    private FileFactory(){}

    public static FileFactory getInstatnce()
    {
        if(obj==null)
        {
            obj=new FileFactory();
        }

        return obj;
    }
    public IViewer getViewer(String ViewerType)
    {
            IViewer viewer=null;
            if(ViewerType.equals("wps"))
            {
                viewer=new WPSviewer();
            }
            else if(ViewerType.equals("adobe"))
            {
                viewer=new AdobeViewer();
            }
            
            return viewer;

    }

}

public class Client{
    public static void main(String str[])
    {
        FileFactory.getInstatnce().getViewer("wps").view();

    }
}









