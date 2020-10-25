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
/**
 * This Product class structure is more different than the other Product classes.
 * So, we need a adapter a class to make it compitable with existing client interface  
 */
class DOCXViewer 
{

    public void ViewPages()
    {   
        System.out.println("Viewing with DOCX viewer");
    }
}
class DOCXAdapterViewer implements IViewer
{
    DOCXViewer docxViewer;
    DOCXAdapterViewer(DOCXViewer docxViewer)
    {
        this.docxViewer = docxViewer;
    }
    @Override
    public void view()
    {   
        docxViewer.ViewPages();
    }

}

abstract class FileFactory{
    
    IViewer getViewer(String ViewerType)
    {
        IViewer viewer;
        viewer =createViewer(ViewerType);
        return viewer;
    }
    // createViewer() = Factory method--> It produces products
    abstract IViewer createViewer(String ViewerType);
    

}
/**
 * If we add a new subclass of Factory class ,then the subclass will take the responsibility
 * of the concrete object/products creation.
 * 
 * NewFileFactory= Concrete Creators(A class that produces proudcts)
 * Product classes= "MicrosoftEdgeViewer","WPSviewer","WPSviewer" 
 */
class NewFileFactory extends FileFactory{

    

    IViewer createViewer(String ViewerType)
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
        else if(ViewerType.equals("microsoft_edge"))
        {
            viewer=new MicrosoftEdgeViewer();
        }
        
        return viewer;
    }


}
class NewFileFactory2 extends NewFileFactory{

    IViewer createViewer(String ViewerType)
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
        else if(ViewerType.equals("microsoft_edge"))
        {
            viewer=new MicrosoftEdgeViewer();
        }
        else if(ViewerType.equals("DOCX"))
        {
           
            viewer=new DOCXAdapterViewer(new DOCXViewer());
        }
        
        return viewer;
    }


}
public class Client{
    public static void main(String str[])
    {
        FileFactory ff=new NewFileFactory();
        ff.getViewer("microsoft_edge").view();
        FileFactory ff2=new NewFileFactory2();
        ff2.getViewer("DOCX").view();


    }
}









