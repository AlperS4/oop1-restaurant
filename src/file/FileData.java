package file;

/**
 * Съдържа информация за текущо отворения файл
 */
public class FileData {

    private boolean loaded;
    private String filePath;


    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Изчиства информацията за текущия файл
     */
    public void clear() {
        this.filePath = null;
        this.loaded = false;
    }
}