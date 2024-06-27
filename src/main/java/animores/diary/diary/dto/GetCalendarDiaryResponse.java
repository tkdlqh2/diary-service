package animores.diary.diary.dto;

import animores.diary.diary.dao.GetCalendarDiaryDao;
import lombok.Getter;

import java.util.List;

@Getter
public class GetCalendarDiaryResponse {

    private long totalCount;

    private List<GetCalendarDiaryDao> diaries;

    public GetCalendarDiaryResponse(long totalCount, List<GetCalendarDiaryDao> diaries) {
        this.totalCount = totalCount;
        this.diaries = diaries;
    }
}
