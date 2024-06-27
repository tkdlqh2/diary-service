package animores.diary.diary.dto;

import animores.diary.diary.dao.GetAllDiaryCommentDao;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllDiaryCommentResponse {

    private long totalCount;

    private List<GetAllDiaryCommentDao> comments;

    public GetAllDiaryCommentResponse(long totalCount, List<GetAllDiaryCommentDao> comments) {
        this.totalCount = totalCount;
        this.comments = comments;
    }
}
