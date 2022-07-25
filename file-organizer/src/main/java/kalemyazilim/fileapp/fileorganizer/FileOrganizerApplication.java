package kalemyazilim.fileapp.fileorganizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class FileOrganizerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileOrganizerApplication.class, args);
    }
}
