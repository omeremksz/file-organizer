package kalemyazilim.fileapp.fileorganizer.controller;

import kalemyazilim.fileapp.fileorganizer.model.FileModel;
import kalemyazilim.fileapp.fileorganizer.response.FileUploadResponse;
import kalemyazilim.fileapp.fileorganizer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "file")//Add default path for controller class and their methods.
public class FileController {
    /*Reference to FileService object through constructor injection to obey DI.*/
    @Autowired
    private final FileService fileService;

    /*Initialize FileService object for us.*/
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    //Get all files as a list.
    @GetMapping("/list")
    public List<FileModel> getFile() {
        return fileService.getFile();
    }

    //Download file by id method.
    @GetMapping(value = "/download/{fileId}")
    public ResponseEntity<Resource> downloadById(@PathVariable("fileId") Long fileId) {
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileService.downloadById(fileId).getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; originalFileName = " + fileService.downloadById(fileId).getOriginalFileName())
                .body(new ByteArrayResource(fileService.downloadById(fileId).getData()));
    }

    @PostMapping(value = "/save",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public FileUploadResponse saveNewFile(@RequestPart("fileModel") FileModel fileModel, @RequestPart("newFile") MultipartFile newFile) throws IOException {
        FileModel uploadedFile = fileService.saveNewFile(fileModel,newFile);
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        if(uploadedFile!=null){
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/file/download/")
                    .path(Long.toString(uploadedFile.getFileId()))
                    .toUriString();
            fileUploadResponse.setDownloadUri(downloadUri);
            fileUploadResponse.setFileId(uploadedFile.getFileId());
            fileUploadResponse.setFileType(uploadedFile.getFileType());
            fileUploadResponse.setUploadedStatus(true);
            fileUploadResponse.setUploadedMessage("File Uploaded Successfully!");
            return fileUploadResponse;
        }
        fileUploadResponse.setUploadedMessage("Something went wrong, please re-uploaded!");
        return  fileUploadResponse;
    }

    //POST http://localhost:8080/file
    @DeleteMapping(path = "/delete/{fileId}")
    public void deleteFile(@PathVariable("fileId") Long fileId) {
        fileService.deleteFile(fileId);
    }

    //DELETE http://localhost:8080/file/3
    @PutMapping(path = "/update/{fileId}")
    public void updateFile(
            @PathVariable("fileId") Long fileId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String fileName) {
        fileService.updateFile(fileId, description, fileName);
    }
    //PUT http://localhost:8080/file/update/2?description=Updated&fileName=Updated
}
