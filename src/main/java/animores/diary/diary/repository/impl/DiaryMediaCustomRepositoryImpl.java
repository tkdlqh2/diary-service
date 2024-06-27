package animores.diary.diary.repository.impl;

import animores.diary.diary.entity.DiaryMedia;
import animores.diary.diary.entity.DiaryMediaType;
import animores.diary.diary.repository.DiaryMediaCustomRepository;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static animores.diary.diary.entity.QDiaryMedia.diaryMedia;

@Repository
@RequiredArgsConstructor
public class DiaryMediaCustomRepositoryImpl implements DiaryMediaCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DiaryMedia> getAllDiaryMediaToReorder(Long diaryId, DiaryMediaType type) {
        return jpaQueryFactory
            .selectFrom(diaryMedia)
            .where(diaryMedia.diary.id.eq(diaryId))
            .orderBy(new CaseBuilder()
                    .when(diaryMedia.type.eq(type)).then(1)
                    .otherwise(0).desc(),
                diaryMedia.id.asc())
            .fetch();
    }
}
