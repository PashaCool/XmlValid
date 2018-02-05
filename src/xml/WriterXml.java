package xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import domain.Gun;
import domain.TTC;

public class WriterXml {
    public void write(List<Gun> guns, String xml) throws XMLStreamException, IOException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            writer = output.createXMLStreamWriter(new FileWriter(xml));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Gun");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/guns");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/guns schema2.xsd");
            for(Gun newguns : guns) {
                writer.writeStartElement("guns");
                writer.writeAttribute("id", newguns.getId());
                writer.writeStartElement("Model");
                writer.writeCharacters(newguns.getModel());
                writer.writeEndElement();
                writer.writeStartElement("Handy");
                writer.writeCharacters(newguns.getHandy().toString());
                writer.writeEndElement();
                writer.writeStartElement("Origin");
                writer.writeCharacters(newguns.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("TTC");
                for(TTC ttcChar : newguns.getTTCList()) {
                    writer.writeStartElement(ttcChar.getName());
                    writer.writeCharacters(ttcChar.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("Material");
                writer.writeCharacters(newguns.getMaterial().toString());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch(XMLStreamException ex) {
                ex.printStackTrace();
              }
          }
        }
    }
