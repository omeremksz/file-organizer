package kalemyazilim.fileapp.fileorganizer;

import org.springframework.stereotype.Service;

import java.util.List;

/*Service is special type of @Component just for more readable.*/
@Service
public class FileService {
    public List<File> getFile(){
        return List.of(
                new File(
                        1L,
                        "SomeDescription",
                        "Prices"
                )
        );
    }
}
