package kalemyazilim.fileapp.fileorganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "file")
public class FileController {
    /*Reference to FileService object through constructor injection to obey DI.*/
    private final FileService fileService;
    /*Initialize FileService object for us.*/
    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public List<File> getFile(){
        return fileService.getFile();
    }
    @PostMapping
    public void saveNewFile(@RequestBody File file){fileService.saveNewFile(file);}
    @DeleteMapping(path = "{fileId}")
    public void deleteFile(@PathVariable("fileId") Long fileId){
        fileService.deleteFile(fileId);
    }
}
