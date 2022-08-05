package kalemyazilim.fileapp.fileorganizer.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity//For Hibernate.
@Table(name = "file_table")//For table in DB.
public class FileModel {
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
    @Column(name = "file_id")//To specify column name of table.
    private Long fileId;//To hold file id.
    private String description;//To hold file description.
    @Column(name = "file_name")
    private String fileName;//To hold file name.
    @Column(name = "user_name")
    private String userName;//To hold user's name that own files.
    @Column(name = "created_date")
    private LocalDateTime createdAt;//To hold file creation time.
    @Column(name = "file_type")
    private String fileType;//To hold file type.
    @Column(name = "original_file_name")
    private String originalFileName;//To hold uploaded file name.
    @Lob//Large Object Type.
    @Column(name = "data")
    private byte[] data;

    /*Empty Constructor*/
    public FileModel() {
    }

    /*All Elements Included Constructor*/

    public FileModel(Long fileId, String description, String fileName, String userName, LocalDateTime createdAt, String fileType, String originalFileName, byte[] data) {
        this.fileId = fileId;
        this.description = description;
        this.fileName = fileName;
        this.userName = userName;
        this.createdAt = createdAt;
        this.fileType = fileType;
        this.originalFileName = originalFileName;
        this.data = data;
    }

    /*All Elements Included Constructor without ID*/

    public FileModel(String description, String fileName, String userName, LocalDateTime createdAt, String fileType, String originalFileName, byte[] data) {
        this.description = description;
        this.fileName = fileName;
        this.userName = userName;
        this.createdAt = createdAt;
        this.fileType = fileType;
        this.originalFileName = originalFileName;
        this.data = data;
    }

    /*Temporary Constructor for Configuration*/

    public FileModel(String description, String fileName, String userName) {
        this.description = description;
        this.fileName = fileName;
        this.userName = userName;
    }

    /*Getter & Setter for all Elements*/
    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                ", userName='" + userName + '\'' +
                ", createdAt=" + createdAt +
                ", fileType='" + fileType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
