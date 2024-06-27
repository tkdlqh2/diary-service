package animores.diary.diary.dao;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCalendarDiaryDao {

    private Long diaryId;
    private String content;
    private LocalDateTime createdAt;

    private Long profileId;
    private String name;
    private String imageUrl;
}
