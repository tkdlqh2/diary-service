package animores.diary.diary.repository;

import animores.diary.diary.entity.DiaryReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryReplyRepository extends JpaRepository<DiaryReply, Long> {

    Optional<DiaryReply> findByIdAndDeletedDtIsNull(Long id);
}
