package animores.diary.diary.repository;

import animores.diary.diary.entity.DiaryLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryLikeRepository extends JpaRepository<DiaryLike, Long> {

    Optional<DiaryLike> findByDiaryIdAndProfileId(Long diaryId, Long profileId);
}
