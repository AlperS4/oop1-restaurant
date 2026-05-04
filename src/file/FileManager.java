package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

            fileData.setFilePath(path);
            fileData.setLoaded(true);

            System.out.println("Successfully opened " + path);

        } catch (Exception e) {
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
            System.out.println("No file opened");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileData.getFilePath()))) {
            System.out.println("Successfully saved");

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public void saveAs(String path) {

        if (!fileData.isLoaded()) {
            System.out.println("No file is open");
            return;
        }

        fileData.setFilePath(path);
        System.out.println("Successfully saved " + path);
    }
}