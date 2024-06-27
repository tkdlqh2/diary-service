package animores.diary.diary.entity;

import animores.diary.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diary_media")
public class DiaryMedia extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Diary diary;

    private String url;

    private int mediaOrder;

    @Enumerated(EnumType.STRING)
    private DiaryMediaType type;

    public static DiaryMedia create(Diary diary, String url, int order, DiaryMediaType type) {
        return DiaryMedia.builder()
            .diary(diary)
            .url(url)
            .mediaOrder(order)
            .type(type)
            .build();
    }

    public void updateMediaOrder(int order) {
        this.mediaOrder = order;
    }

}
