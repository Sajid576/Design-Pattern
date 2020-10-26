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

import java.util.ArrayList;
import java.util.List;

interface IViewer{
    void view();
}

interface ExplorerComponent{
    public void add(ExplorerComponent e);
    public void remove(ExplorerComponent e) ;
    public List<ExplorerComponent> getSubordinates();
    public void setParent(ExplorerComponent p);
    public String getName();
}

class FileExplorer implements ExplorerComponent
{
    private String name;
    private List<ExplorerComponent> subordinates;
    private ExplorerComponent parent;
 
    FileExplorer(String name)
    {
        this.name = name;
        subordinates = new ArrayList<ExplorerComponent>();
    }
    public void add(ExplorerComponent e) {
        subordinates.add(e);
        e.setParent(this);
         
     }
  
     public void remove(ExplorerComponent e) {
        subordinates.remove(e);
     }
  
     public List<ExplorerComponent> getSubordinates(){
       return subordinates;
     }
  
     public void setParent(ExplorerComponent p)
     {
         this.parent = p;
     }
     public String getName()
     {
         return name;
     }
     public String toString(){
        if(parent==null)
        {
            return ("Root");
        }
        else if(subordinates.size()!=0)
        {
            return ("Folder:  "+name+", Under: "+parent.getName());
        }
        else 
        {
            return ("File:  "+name+", Under: "+parent.getName());
        }
}
}
class WPSviewer implements IViewer{
    private String name;

    WPSviewer(String name)
    {
        this.name = name;
        
    } 
    @Override
    public void view()
    {   
        System.out.println("Viewing with "+name+" viewer");
    }


}
class AdobeViewer implements IViewer{
    private String name;
   

    AdobeViewer(String name)
    {
        this.name = name;
        
    }
   
    @Override
    public void view()
    {   
        System.out.println("Viewing with "+name+" viewer");
    }
}
/**
 * Suppose, I want to add microsoft edge viewer in later versions
 */
class MicrosoftEdgeViewer implements IViewer
{
    private String name;
    
    MicrosoftEdgeViewer(String name)
    {
        this.name = name;
        
    }  
    @Override
    public void view()
    {   
        System.out.println("Viewing with "+name+" viewer");
    }
}
/**
 * This Product class structure is more different than the other Product classes.
 * So, we need a adapter a class to make it compitable with existing client interface  
 */
class DOCXViewer 
{
    
    public void ViewPages(String name)
    {   
        System.out.println("Viewing with "+name+" viewer");
    }
}
class DOCXAdapterViewer implements IViewer
{
    private String name;
  
    DOCXViewer docxViewer;
    DOCXAdapterViewer(DOCXViewer docxViewer,String name)
    {
        this.docxViewer = docxViewer;
        this.name = name;
       
   
    }
     
    @Override
    public void view()
    {   
        docxViewer.ViewPages(name);
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
            viewer=new WPSviewer(ViewerType);
        }
        else if(ViewerType.equals("adobe"))
        {
            viewer=new AdobeViewer(ViewerType);
        }
        else if(ViewerType.equals("microsoft_edge"))
        {
            viewer=new MicrosoftEdgeViewer(ViewerType);
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
            viewer=new WPSviewer(ViewerType);
        }
        else if(ViewerType.equals("adobe"))
        {
            viewer=new AdobeViewer(ViewerType);
        }
        else if(ViewerType.equals("microsoft_edge"))
        {
            viewer=new MicrosoftEdgeViewer(ViewerType);
        }
        else if(ViewerType.equals("DOCX"))
        {
           
            viewer=new DOCXAdapterViewer(new DOCXViewer(),ViewerType);
        }
        
        return viewer;
    }


}


/*
 *                  Root
 * ----------------------------------------
 * |                |                     |
 * file1       local                  myfolder
 *             ----------              ------
 *             |        |                 |            
 *           file2     file3            file4
 * 
 * 
 */


public class PatternDemo 
{
    public static void main(String[] args)
    {

        //After adding the composite design pattern.
        ExplorerComponent root=new FileExplorer("Root");
        ExplorerComponent file1 = new FileExplorer("file-1");
        ExplorerComponent local = new FileExplorer("local");
        ExplorerComponent myfolder = new FileExplorer("My Folder");
        ExplorerComponent file2 = new FileExplorer("file-2");
        ExplorerComponent file3 = new FileExplorer("file-3");
        ExplorerComponent file4 = new FileExplorer("file-4");

        root.add(file1);
        root.add(local);
        root.add(myfolder);

        local.add(file2);
        local.add(file3);
        myfolder.add(file4);



        System.out.println("Now printing full file system");
        System.out.println(root); 
        System.out.println("---"); 
        List<ExplorerComponent> path= root.getSubordinates();
        while (path.size()!=0)
        {

            ExplorerComponent directory = path.remove(0);
            System.out.println(directory);
            for (ExplorerComponent children : directory.getSubordinates()) 
            {
                
                path.add(children);
            }

        }


        FileFactory ff=new NewFileFactory();
        ff.getViewer("microsoft_edge").view();
        
        //After implementing new Viewer named DOCX. 
        FileFactory ff2=new NewFileFactory2();
        ff2.getViewer("DOCX").view();
        
    }    
}
