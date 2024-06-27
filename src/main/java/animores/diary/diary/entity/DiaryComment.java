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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary_comment")
public class DiaryComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    // diary reply 연관관계 추가


    private String content;


    private LocalDateTime deletedDt;

    public static DiaryComment create(Diary diary, Profile profile, String content) {
        return DiaryComment.builder()
            .diary(diary)
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
