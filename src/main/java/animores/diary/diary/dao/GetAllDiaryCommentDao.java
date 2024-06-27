package animores.diary.diary.dao;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetAllDiaryCommentDao {

    private Long commentId;
    private String content;
    private LocalDateTime createAt;

    private Long profileId;
    private String name;
    private String imageUrl;

    private Integer replyCount = 0;

}
