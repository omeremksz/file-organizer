package kalemyazilim.fileapp.fileorganizer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FileConfig {
    @Bean
    CommandLineRunner commandLineRunner(FileRepository fileRepository){
        return args -> {
            File testFile = new File(
                    "Description of Test File",
                    "Test File",
                    123L
            );
            File testFile1 = new File(
                    "Description of Test File 1",
                    "Test File 1",
                    123L
            );
            fileRepository.saveAll(
                    List.of(testFile,testFile1)
            );
        };
    }

}
