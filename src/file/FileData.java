package file;

public class FileData {

    private String filePath;
    private boolean loaded;

    public boolean isLoaded() {
        return loaded;
    }

    public void setFile(String path) {
        this.filePath = path;
        this.loaded = true;
    }

    public String getFilePath() {
        return filePath;
    }

    public void clear() {
        filePath = null;
        loaded = false;
    }
}