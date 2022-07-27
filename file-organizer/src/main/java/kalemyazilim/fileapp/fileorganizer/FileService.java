package kalemyazilim.fileapp.fileorganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<File> fileByFileName = fileRepository.findFileByFileName(file.getFileName(),file.getUserId());
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
}
