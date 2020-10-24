/**
 * My system works with Json object.But I have to integrate a module that works with XML
 * format.So,I have to make compitable my JSON class with the XML class.
 * 
 */

//Old
interface IJsonModel {
    public void readJson();
    public void writeJson();
}
//New
interface IXMLModel{
    public void readXML();
    public void writeXML();
}

class JsonModel implements IJsonModel{

    public void readJson(){
        System.out.println("Reading Json file");
    }
    public void writeJson(){
        System.out.println("Writing Json file");
    }
}
class XmlModel implements IXMLModel{
    public void readXML(){
        System.out.println("Reading XML file");
    }
    public void writeXML(){
        System.out.println("Writing XML file");
    }
}
class XMLAdapter implements IJsonModel{
    IXMLModel xmlModel;
    XMLAdapter(IXMLModel xmlModel)
    {
        this.xmlModel = xmlModel;
    }
    public void readJson(){
        System.out.println("Reading Json file");
    }
    public void writeJson(){
        System.out.println("Writing Json file");
    }
}
public class Example_2 {

    public static void main(String[] args){
        JsonModel jsonObj=new JsonModel();
        IXMLModel xmlObj=new XmlModel();
        IJsonModel xmlAdapter=new XMLAdapter(xmlObj);
        System.out.println("XML system");
        xmlObj.readXML();
        xmlObj.writeXML();
        System.out.println("JSON system");
        jsonObj.readJson();
        jsonObj.writeJson();
        System.out.println("XML adapter");
        xmlAdapter.readJson();
        xmlAdapter.writeJson();

    }

}
