package animores.diary.diary.repository;


import animores.diary.diary.entity.DiaryMedia;
import animores.diary.diary.entity.DiaryMediaType;

import java.util.List;

public interface DiaryMediaCustomRepository {

    List<DiaryMedia> getAllDiaryMediaToReorder(Long diaryId, DiaryMediaType type);

}
