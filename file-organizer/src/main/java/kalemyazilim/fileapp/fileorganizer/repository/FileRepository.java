package kalemyazilim.fileapp.fileorganizer.repository;

import kalemyazilim.fileapp.fileorganizer.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileModel,Long> {
    //Finding file by file name.
    //SELECT *FROM file WHERE name = entered file name.
    @Query("SELECT f FROM FileModel f WHERE f.fileName = ?1 AND f.userName = ?2")//JPQL query.
    Optional<FileModel>findFileByFileName(String fileName, String userName);

    @Query("SELECT f FROM FileModel f WHERE f.fileId = ?1")//JPQL query.
    FileModel getById(Long fileId);
}
