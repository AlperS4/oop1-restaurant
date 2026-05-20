package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Управлява работа с файлове
 */
public class FileManager {

    private FileData fileData;

    public FileManager(FileData fileData) {
        this.fileData = fileData;
    }

    /**
     * Отваря файл
     * Ако файлът не съществува се създава нов
     *
     * @param path път към файла
     */
    public String open(String path) {

        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileData.setFilePath(path);
            fileData.setLoaded(true);

            return "Successfully opened " + path;

        } catch (Exception e) {
            return "Error opening file";
        }
    }

    /**
     * Затваря текущия файл
     */
    public String close() {

        if (!fileData.isLoaded()) {
            return "No file is open";
        }

        fileData.clear();
        return "Successfully closed ";
    }

    /**
     * Записва текущия файл
     */
    public String save() {

        if (!fileData.isLoaded()) {
            return "No file is open";
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileData.getFilePath()))) {
            return "Successfully saved";

        } catch (Exception e) {
            return "Error saving file";
        }
    }

    /**
     * Записва във нов файл
     *
     * @param path нов път
     */
    public String saveAs(String path) {

        if (!fileData.isLoaded()) {
            return "No file is open";
        }

        fileData.setFilePath(path);
        return "Successfully saved " + path;
    }
}