package kalemyazilim.fileapp.fileorganizer;

import javax.persistence.*;

@Entity//For Hibernate.
@Table//For table in DB.
public class File {
    @Id
    @SequenceGenerator(
            name = "file_sequence",
            sequenceName = "file_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "file_sequence"
    )
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
