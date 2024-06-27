package animores.diary.diary.entity;

import animores.diary.common.BaseEntity;
import animores.diary.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary_reply")
public class DiaryReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DiaryComment diaryComment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;


    private String content;


    private LocalDateTime deletedDt;

    public static DiaryReply create(DiaryComment diaryComment, Profile profile, String content) {
        return DiaryReply.builder()
            .diaryComment(diaryComment)
            .profile(profile)
            .content(content)
            .build();
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.deletedDt = LocalDateTime.now();
    }

}
