package animores.diary.diary.repository;

import animores.diary.diary.entity.DiaryMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryMediaRepository extends JpaRepository<DiaryMedia, Long> {

    List<DiaryMedia> findByIdIn(List<Long> ids);

}
