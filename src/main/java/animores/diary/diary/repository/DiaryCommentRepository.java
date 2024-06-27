package animores.diary.diary.repository;

import animores.diary.diary.entity.DiaryComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryCommentRepository extends JpaRepository<DiaryComment, Long> {

    Optional<DiaryComment> findByIdAndDeletedDtIsNull(Long id);
}
