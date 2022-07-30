package kalemyazilim.fileapp.fileorganizer.service;

import kalemyazilim.fileapp.fileorganizer.model.File;
import kalemyazilim.fileapp.fileorganizer.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*Service is special type of @Component just for more readable.*/
@Service
public class FileService {

    private final FileRepository fileRepository;
    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getFile(){
        return fileRepository.findAll();
    }

    public void saveNewFile(File file) {
        //Casting both fileName and userId.
        Optional<File> fileByFileName = fileRepository.findFileByFileName(file.getFileName(),file.getUserName());
        if(fileByFileName.isPresent()){
            throw new IllegalStateException("There is already a file with same name.");
        }
        fileRepository.save(file);
    }

    public void deleteFile(Long fileId) {
        boolean isFileExists = fileRepository.existsById(fileId);
        if(!isFileExists){
            throw new IllegalStateException("File with id "+fileId+" does not exists.");
        }
        fileRepository.deleteById(fileId);
    }
    @Transactional
    public void updateFile(Long fileId, String description, String fileName) {
        File file = fileRepository.findById(fileId).orElseThrow(() -> new IllegalStateException("File with "+fileId+" is not exists."));
        if(fileName!=null && fileName.length()>0 && !Objects.equals(file.getFileName(),fileName)){
            Optional<File> fileOptional = fileRepository.findFileByFileName(file.getFileName(),file.getUserName());
            if(fileOptional.isPresent()){
                throw new IllegalStateException("There is already a file with same name.");
            }
            file.setFileName(fileName);
        }
        if(description!=null && description.length()>0 && !Objects.equals(file.getDescription(),description)){
            file.setDescription(description);
        }
    }
}
