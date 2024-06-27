package animores.diary.diary.dto;

import animores.diary.diary.dao.GetAllDiaryDao;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllDiaryResponse {

    private long totalCount;

    private List<GetAllDiaryDao> diaries;

    public GetAllDiaryResponse(long totalCount, List<GetAllDiaryDao> diaries) {
        this.totalCount = totalCount;
        this.diaries = diaries;
    }
}
