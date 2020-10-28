/**
 * Principle: Software entities should be open for extension but
 * closed for modification.
 * 
 * "open for extensions"--> We can use inheritance for this.
 * "closed for modification"--> We shouldnt alter it until we find bug.
 * 
 * 
 * 
 * 
 */

 /*
class GraphicEdition
{
    public void drawShape(Shape s)
    {
        if(s.type == 1)
        {
            drawRectangle(s);
        }
        else if(s.type == 2)
        {
            drawCircle(s);
        }
    }
    public void drawCircle(Shape s)
    {
        System.out.println("drawing circle");
    }
    public void drawRectangle(Shape s)
    {
        System.out.println("drawing rectangle");
    }

}
class Shape{
    int type;
}
class Rectangles extends Shape
{
    Rectangles()
    {
        super.type=1;
    }
}
class Circle extends Shape
{
    Circle(){
        super.type=2;
    }
}
*/

/**
 * Now , if we want to add a new class 'Square' extending Shape,we have to modify the
 * GraphicEdition class using another else-if condition which is against the principle of OCP.
 * **Problems of this code:
 * 1) Impossible to add new shape without modifying GraphicEdition class .So, it is 
 * necessary to understand the code of GraphicEdition to add a new Shape.
 * 2) Tight Coupling between Shape and GraphicEdition.
 * 3)if-else case should be avoided.
 * 
 * 
 * Solution:
 * 
 */

class GraphicEdition
{
    public void drawShape(Shape s)
    {
        s.draw();
    }
    
    
}
abstract class Shape{
    
    abstract public void draw();

}
class Rectangles extends Shape
{
    
    public void draw()
    {
        System.out.println("drawing rectangle");
    }

}
class Circle extends Shape
{
   
    public void draw()
    {
        System.out.println("drawing circle");
    }
}
/**
 * So, it solved all of the above mentioned problems .Now, we can add a new shape named "Square" without modifying 
 * another class.
 */

class Squares extends Shape
{
   
    public void draw()
    {
        System.out.println("drawing circle");
    }
}
public class OCP {
    
}
