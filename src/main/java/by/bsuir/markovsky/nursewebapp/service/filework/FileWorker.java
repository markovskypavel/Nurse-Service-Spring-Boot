package by.bsuir.markovsky.nursewebapp.service.filework;

import by.bsuir.markovsky.nursewebapp.exception.NoExtensionFoundException;

public interface FileWorker<T> {
    void writeToFile(T object, String filePath);
    T readFromFile(String filePath);
    void sortFiles(String packagePath) throws NoExtensionFoundException;
}
