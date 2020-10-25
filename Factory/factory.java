interface Reader {
    public String read();
}

class DataBaseReader implements Reader {
    @Override
    public String read() {
         return "Reading database";
        }
    }
class XMLReader implements Reader 
{
    @Override
    public String read()
    {
         return "XML file reader";
    }
}
class CSVReader implements Reader 
{
    @Override
    public String read() {
            return "CSV file reading";
    }
}
class HttpClient
{

    public static void main(String args[]) 
    {
        XMLReader xmlreader = new XMLReader();
        CSVReader csvreader = new CSVReader();
        DataBaseReader dbreader = new DataBaseReader();
        

        String readerType="XML";
        if (readerType.equalsIgnoreCase("XML")) 
        {
            System.out.println(xmlreader.read());
        }
        else if (readerType.equalsIgnoreCase("CSV")) 
        {
            System.out.println(csvreader.read());
        }
        else if (readerType.equalsIgnoreCase("DB")) 
        {
            System.out.println(dbreader.read());
        }
    }
}

/**
 * 
 * 
 */
class ReaderFactory {

    public static Reader getReader(String readerType)
    {
            Reader reader = null;
            if (readerType.equalsIgnoreCase("XML")) {
                reader = new XMLReader();
            }
            else if (readerType.equalsIgnoreCase("CSV")) {
                reader = new CSVReader();
            }
            else if (readerType.equalsIgnoreCase("DB")) {
                reader = new DataBaseReader();
            }
            return reader;
    }

}