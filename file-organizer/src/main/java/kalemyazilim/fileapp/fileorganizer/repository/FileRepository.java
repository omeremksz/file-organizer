package kalemyazilim.fileapp.fileorganizer.repository;

import kalemyazilim.fileapp.fileorganizer.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileModel,Long> {
    //SELECT *FROM file WHERE name = entered file name.
    @Query("SELECT f FROM FileModel f WHERE f.fileName = ?1 AND f.userName = ?2")//JPQL query.
    Collection<Optional<FileModel>> findFileByFileName(String fileName, String userName);//Finding file by file name.

    Integer countByFileNameAndUserName(String fileName, String userName);//Count number of file of given user that name is given file name.

    @Query("SELECT f FROM FileModel f WHERE f.fileId = ?1")
    FileModel getById(Long fileId);//Finding file by file id.

    @Query("SELECT f FROM FileModel f WHERE f.userName = ?1")
    List<FileModel> getFileByUserName(String userName);//Finding file by user's name.


}
