package xml;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class ValidationXml {

    public void validate(String xmlFile, String xsdFile) {
        boolean flag = true;
        SchemaFactory schFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        ErrorHandler error = new ErrorReg();

        try {
            File schemaLocation = new File(xsdFile);
            Schema schema = schFactory.newSchema(schemaLocation);
            Validator val = schema.newValidator();
            Source source = new StreamSource(new File(xmlFile));
            val.validate(source);
            val.setErrorHandler(error);
            // ((schFactory.newSchema(new File(xsdFile))).newValidator()).validate(new
            // StreamSource(new File(xmlFile)));
        } catch (SAXException e) {
            flag = false;
            System.out.println(e.getMessage());
        } catch (IOException e) {
            flag = false;
            System.out.println(e.getMessage());
        }
        System.out.println("xml file is valid: " + flag);
    }
}
