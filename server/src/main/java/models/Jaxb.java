package models;

import javax.xml.bind.JAXBException;
import java.io.File;

public abstract class Jaxb {
    public static boolean contains(Users users, User user){
        return users.contains(user);
    }
    public static void write(Users users, User user, File file) throws JAXBException{
        JaxbWriter.write(users, user, file);
    }

    public static Users read(File file) throws JAXBException {
        return JaxbReader.read(file);
    }
}
