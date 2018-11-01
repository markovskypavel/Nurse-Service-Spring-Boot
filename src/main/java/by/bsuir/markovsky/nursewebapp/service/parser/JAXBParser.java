package by.bsuir.markovsky.nursewebapp.service.parser;

import by.bsuir.markovsky.nursewebapp.exception.UtilException;

import java.io.File;

public interface JAXBParser {
    Object getObject(File file, Class c) throws UtilException;
    void saveObject(File file, Object o) throws UtilException;
}
