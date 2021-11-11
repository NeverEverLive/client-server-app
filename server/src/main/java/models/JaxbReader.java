package models;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public abstract class JaxbReader {
    public static Users read(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Users.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

       return (Users) unmarshaller.unmarshal(file);
    }
}
