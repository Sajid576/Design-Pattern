/**
 * Liskov Substitute Principle: 
 *          Subtypes must be substituble for base types.
 * 
 */

class Rectangle
{
    int width;
    int height;

    void setWidth(int width)
    {
        this.width = width;
    }
    void setHeight(int height)
    {
        this.height = height;
    }
    int getHeight()
    {
        return height;
    }
    int getWidth()
    {
        return width;
    }
    int getArea()
    {
        return this.width*this.height;
    }
} 

class Square extends Rectangle
{
    void setWidth(int width)
    {
        this.width=width;
        this.height=width;
    }
    void setHeight(int height)
    {
        this.width=height;
        this.height=height;
    }
}

public class LSP {
    public static void main(String[] args)
    {
        Rectangle r= new Rectangle();
        //Rectangle r= new Square();
        r.setWidth(5);//---> 5x5=25
        r.setHeight(10);//--> 10x10=100
        
        System.out.println(r.getArea());
        
        /**
         * output: 50 (if new Rectangle())
         * output: 100 (if new Square())
         * So, after substituting with the child object ,the results are not same.So, it is against the principle 
         * of LSP.
         * 
         */


    }
}
