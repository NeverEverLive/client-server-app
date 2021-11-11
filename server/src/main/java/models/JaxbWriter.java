package models;

import javax.xml.bind.*;
import java.io.File;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public abstract class JaxbWriter {
    public static void write(Users users, User user, File file) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Users.class);

        Marshaller marshaller = context.createMarshaller();;
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        users.addUser(user);

        marshaller.marshal(users, System.out);
        marshaller.marshal(users, file);
    }
}
