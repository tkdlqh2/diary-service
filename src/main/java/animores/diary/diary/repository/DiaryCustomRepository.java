package animores.diary.diary.repository;

import animores.diary.diary.dao.GetAllDiaryDao;
import animores.diary.diary.dao.GetCalendarDiaryDao;
import com.querydsl.core.QueryResults;

import java.time.LocalDate;
import java.util.List;

public interface DiaryCustomRepository {

    List<GetAllDiaryDao> getAllDiary(Long accountId, Long profileId, int page, int size);

    Long getAllDiaryCount(Long accountId);

    QueryResults<GetCalendarDiaryDao> getCalendarDiary(Long accountId, LocalDate date);
}
