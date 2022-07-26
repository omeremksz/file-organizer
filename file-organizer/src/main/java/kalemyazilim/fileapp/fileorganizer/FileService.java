package kalemyazilim.fileapp.fileorganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
