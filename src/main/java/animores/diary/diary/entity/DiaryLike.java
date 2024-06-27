package animores.diary.diary.entity;

import animores.diary.profile.entity.Profile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary_like", uniqueConstraints = {
    @UniqueConstraint(name = "UK_diary_profile", columnNames = {"diary_id", "profile_id"})
})
public class DiaryLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;


    @CreatedDate
    private LocalDateTime createdAt;

    public static DiaryLike create(Profile profile, Diary diary) {
        return DiaryLike.builder()
            .profile(profile)
            .diary(diary)
            .build();
    }
}
