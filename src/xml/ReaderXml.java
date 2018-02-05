package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import domain.*;

public class ReaderXml {
    public List<Gun> read(){
        final String fileName = "guns.xml";
        XMLStreamReader xmlr = null;
        List<Gun> shots = new ArrayList<Gun>();
        try {
            Gun gun = null;
            xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlr.hasNext()) {
                int next = xmlr.next();
                switch (next) {
                case XMLStreamConstants.START_ELEMENT: {
                    String localName = xmlr.getLocalName();
                    switch (localName) {
                    case "guns": {
                        gun = new Gun();
                        gun.setId(xmlr.getAttributeValue(null, "id"));
                        break;
                    }
                    case "Model": {
                        gun.setModel(xmlr.getElementText());
                        break;
                    }
                    case "Handy": {
                        gun.setHandy(xmlr.getElementText());
                        break;
                    }
                    case "Origin": {
                        gun.setOrigin((xmlr.getElementText()));
                        break;
                    }
                    case "range": {
                        TTC ttcRange = new Range();
                        ttcRange.setValue(xmlr.getElementText());
                        gun.getTTCList().add(ttcRange);
                        break;
                    }
                    case "sighting_rang": {
                        TTC sighting_rang = new Sighting();
                        sighting_rang.setValue(xmlr.getElementText());
                        gun.getTTCList().add(sighting_rang);
                        break;
                    }
                    case "collar": {
                        TTC collar = new Collar();
                        collar.setValue(xmlr.getElementText());
                        gun.getTTCList().add(collar);
                        break;
                    }
                    case "optic": {
                        TTC optic = new Optic();
                        optic.setValue(xmlr.getElementText());
                        gun.getTTCList().add(optic);
                        break;
                    }
                    case "Material": {
                        gun.setMaterial(Material.valueOf(xmlr.getElementText()));
                        break;
                    }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String end = xmlr.getLocalName();
                    if ("guns".equals(end)) {
                        shots.add(gun);
                    }
                    break;
                }
                }
            }
            return shots;
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                xmlr.close();
            } catch (Exception e) {
            }
        }
    }
}