package animores.diary.diary.dao;

import animores.diary.diary.entity.DiaryMediaType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetAllDiaryMediaDao {

    private Long id;
    private String url;
    private int order;
    private DiaryMediaType type;

    @QueryProjection
    public GetAllDiaryMediaDao(Long id, String url, int order, DiaryMediaType type) {
        this.id = id;
        this.url = url;
        this.order = order;
        this.type = type;
    }
}
