package kalemyazilim.fileapp.fileorganizer.repository;

import kalemyazilim.fileapp.fileorganizer.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
    //Finding file by file name.
    //SELECT *FROM file WHERE name = entered file name.
    @Query("SELECT f FROM File f WHERE f.fileName = ?1 AND f.userName = ?2")//JPQL query.
    Optional<File>findFileByFileName(String fileName, String userName);
}
