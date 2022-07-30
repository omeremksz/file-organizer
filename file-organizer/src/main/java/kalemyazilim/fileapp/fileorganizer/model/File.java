package kalemyazilim.fileapp.fileorganizer.model;

import javax.persistence.*;

@Entity//For Hibernate.
@Table(name = "file_table")//For table in DB.
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
    @Column(name = "fileId")
    private Long Id;
    private String description;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "userName")
    private String userName;

    /*Empty Constructor*/
    public File() {
    }
    /*All Elements Included Constructor*/

    public File(Long id, String description, String fileName, String userName) {
        Id = id;
        this.description = description;
        this.fileName = fileName;
        this.userName = userName;
    }

    /*All Elements Included Constructor without ID*/

    public File(String description, String fileName, String userName) {
        this.description = description;
        this.fileName = fileName;
        this.userName = userName;
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

    public String getUserName() {return userName;}

    public void setUserId(Long userId) {this.userName = userName;}

    @Override
    public String toString() {
        return "File{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }


}
