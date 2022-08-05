package kalemyazilim.fileapp.fileorganizer.service;

import kalemyazilim.fileapp.fileorganizer.model.FileModel;
import kalemyazilim.fileapp.fileorganizer.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*Service is special type of @Component just for more readable.*/
@Service
public class FileService {
    @Autowired
    private final FileRepository fileRepository;
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<FileModel> getFile() {
        return fileRepository.findAll();
    }

    public FileModel downloadById(Long fileId) {
        return fileRepository.getById(fileId);
    }

    public List<FileModel> getFileByUserName(String userName){
        return fileRepository.getFileByUserName(userName);
    }

  @Transactional
    public FileModel saveNewFile(FileModel fileModel, MultipartFile newFile) throws IOException {
        if (fileRepository.countByFileNameAndUserName(fileModel.getFileName(), fileModel.getUserName()) > 0) {
            throw new IllegalStateException("There is already a file with same name.");
        }
        fileModel.setData(newFile.getBytes());
        fileModel.setFileType(newFile.getContentType());
        fileModel.setOriginalFileName(newFile.getOriginalFilename());
        fileModel.setCreatedAt(LocalDateTime.now());
        fileRepository.save(fileModel);
        return fileModel;
    }

    public void deleteFile(Long fileId) {
        boolean isFileExists = fileRepository.existsById(fileId);
        if (!isFileExists) {
            throw new IllegalStateException("File with id " + fileId + " does not exists.");
        }
        fileRepository.deleteById(fileId);
    }

    @Transactional
    public void updateFile(Long fileId, String description, String fileName) {
        FileModel fileModel = fileRepository.findById(fileId).orElseThrow(() -> new IllegalStateException("File with " + fileId + " is not exists."));
        if (fileName != null && fileName.length() > 0 && !Objects.equals(fileModel.getFileName(), fileName)) {
            if (fileRepository.countByFileNameAndUserName(fileName, fileModel.getUserName()) > 0) {
                throw new IllegalStateException("There is already a file with same name.");
            }
            fileModel.setFileName(fileName);
        }
        if (description != null && description.length() > 0 && !Objects.equals(fileModel.getDescription(), description)) {
            fileModel.setDescription(description);
        }
    }
}
