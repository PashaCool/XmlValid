package xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;

import domain.Gun;

public class Runner {

    public static void main(String[] args) throws XMLStreamException, IOException {
        
        ValidationXml xml = new ValidationXml();
        xml.validate("guns.xml", "schema2.xsd");
        //xml.validate("result.xml", "schema2.xsd");
        ReaderXml rr = new ReaderXml();
        List<Gun> guns = new ArrayList<Gun>();
        guns = rr.read();
        System.out.print(guns.toString());
        WriterXml wrt = new WriterXml();
        //wrt.write(guns, "result.xml");
        //System.out.print(guns.toString());
        //xml.validate("result.xml", "schema2.xsd");
    }
}
