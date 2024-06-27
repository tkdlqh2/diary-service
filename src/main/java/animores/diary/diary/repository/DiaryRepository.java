package animores.diary.diary.repository;


import animores.diary.diary.entity.Diary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @EntityGraph(attributePaths = {"profile", "account"})
    List<Diary> findByAccountId(Long accountId);
}
