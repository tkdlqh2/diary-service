package animores.diary.diary.service;

import animores.diary.account.entity.Account;
import animores.diary.diary.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface DiaryService {

    GetAllDiaryResponse getAllDiary(Account account, Long profileId, int page, int size);

    GetCalendarDiaryResponse getCalendarDiary(Account account, Long profileId, LocalDate date);

    void addDiary(Account account, AddDiaryRequest request, List<MultipartFile> files)
        throws IOException;

    void editDiaryContent(Account account, Long diaryId, EditDiaryContentRequest request);

    void addDiaryMedia(Account account, Long diaryId, AddDiaryMediaRequest request,
        List<MultipartFile> files) throws IOException;

    void editDiaryMedia(Account account, Long diaryId, EditDiaryMediaRequest request,
        List<MultipartFile> files) throws IOException;

    void removeDiaryMedia(Account account, Long diaryId, EditDiaryMediaRequest request);

    void removeDiary(Account account, Long diaryId, RemoveDiaryRequest request);

    void addDiaryLike(Account account, Long diaryId, AddDiaryLikeRequest request);

    void cancelDiaryLike(Account account, Long diaryId, CancelDiaryLikeRequest request);

    GetAllDiaryCommentResponse getAllDiaryComment(Account account, Long diaryId, Long profileId,
        int page, int size);

}
