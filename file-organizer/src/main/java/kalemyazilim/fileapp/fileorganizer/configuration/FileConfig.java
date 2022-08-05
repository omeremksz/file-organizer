package kalemyazilim.fileapp.fileorganizer.configuration;

import kalemyazilim.fileapp.fileorganizer.model.UserModel;
import kalemyazilim.fileapp.fileorganizer.repository.FileRepository;
import kalemyazilim.fileapp.fileorganizer.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FileConfig {
    @Bean
    CommandLineRunner commandLineRunner(FileRepository fileRepository, UserRepository userRepository){
        return args -> {
            /*FileModel testFile = new FileModel(
                    "Description of Test File",
                    "Test File",
                    "omeremksz"
            );
            FileModel testFile1 = new FileModel(
                    "Description of Test File 1",
                    "Test File 1",
                    "omeremksz"
            );*/
            UserModel userModel = new UserModel(
                    "omeremksz",
                    "Omeremksz.6637"
            );
            /*fileRepository.saveAll(
                    List.of(testFile,testFile1)
            );*/
            userRepository.saveAll(List.of(userModel));
        };
    }

}
