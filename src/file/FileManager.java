package file;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private FileData fileData;

    public FileManager(FileData fileData) {
        this.fileData = fileData;
    }

    public void open(String path) {

        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileData.setFile(path);

            System.out.println("Successfully opened " + file.getName());

        } catch (IOException e) {
            System.out.println("Error opening file");
        }
    }

    public void close() {

        if (!fileData.isLoaded()) {
            System.out.println("No file is open");
            return;
        }

        System.out.println("Successfully closed " + fileData.getFilePath());

        fileData.clear();
    }

    public void save() {

        if (!fileData.isLoaded()) {
            System.out.println("No file is open");
            return;
        }

        System.out.println("Successfully saved " + fileData.getFilePath());
    }

    public void saveAs(String path) {

        if (!fileData.isLoaded()) {
            System.out.println("No file is open");
            return;
        }

        fileData.setFile(path);

        System.out.println("Successfully saved " + path);
    }
}