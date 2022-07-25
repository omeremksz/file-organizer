package kalemyazilim.fileapp.fileorganizer;

public class File {
    private Long Id;
    private String description;
    private String fileName;

    /*Empty Constructor*/
    public File() {
    }
    /*All Elements Included Constructor*/
    public File(Long id, String description, String fileName) {
        Id = id;
        this.description = description;
        this.fileName = fileName;
    }
    /*Getter & Setter for all Elements*/
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
