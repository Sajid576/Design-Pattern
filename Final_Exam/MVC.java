




abstract class Controller {
    public ShapeModel getShape(String tag,double radius)
    {
        ShapeModel shape;
        shape=craeteShape(tag,radius);
        return shape;
    }
    abstract ShapeModel craeteShape(String tag,double radius);
    
}
class childController extends Controller
{
    ShapeModel craeteShape(String tag,double radius)
    {
        ShapeModel shape=null;
        if(!tag.equals("circle") && !tag.equals("sphere") )
        {
            System.out.println("invalid input");
        }
        else if(tag.equals("circle"))
        {
            shape=new CircleModel(radius);
            System.out.println("Area: "+shape.surfaceArea());
            System.out.println("Perimeter: "+shape.perimeter());
        }
        else
        {
            shape=new SphereModel(radius);
            
            System.out.println("Area: "+shape.surfaceArea());
            System.out.println("Volume: "+shape.volume());
        }

        return shape;

    }
}

abstract class ShapeModel {
    abstract public double surfaceArea();
    abstract public double perimeter();
    abstract public double volume();
}

class CircleModel extends ShapeModel {
    private double radius;
    CircleModel(double radius)
    {
        this.radius = radius;
    }
    public double surfaceArea()
    {
        double area=3.1416*Math.pow(radius, 2);
        return area;
    }
    public double perimeter()
    {
        double peri=2*3.1416*radius;
        return peri;
    }
    public double volume()
    {
        
    }
}
class SphereModel extends ShapeModel{
    private double radius;
    SphereModel(double radius)
    {
        this.radius = radius;
    }
    public double surfaceArea()
    {
        double area=4*3.1416*Math.pow(radius,2);
        return area;
    }
    public double volume()
    {
        double vol=3.1416*Math.pow(radius, 3)*4/3;
        return vol;
    }

}

class View
{
    public static void main(String[] args)
    {
        System.out.println("Please enter tag and radius of circle");
        String tag="circle";
        double radius=10;
        Controller c=new childController();
        c.getShape(tag, radius);
        

    }
}