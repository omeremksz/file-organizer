package kalemyazilim.fileapp.fileorganizer.response;

public class FileUploadResponse {
    private Long fileId;
    private String fileType;
    private String uploadedMessage;
    private Boolean uploadedStatus;
    private String downloadUri;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUploadedMessage() {
        return uploadedMessage;
    }

    public void setUploadedMessage(String uploadedMessage) {
        this.uploadedMessage = uploadedMessage;
    }

    public Boolean getUploadedStatus() {
        return uploadedStatus;
    }

    public void setUploadedStatus(Boolean uploadedStatus) {
        this.uploadedStatus = uploadedStatus;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }
}
