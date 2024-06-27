package animores.diary.common.service;


import animores.diary.account.entity.Account;
import animores.diary.diary.entity.Diary;
import animores.diary.diary.entity.DiaryComment;
import animores.diary.diary.entity.DiaryReply;
import animores.diary.profile.entity.Profile;

public interface AuthorizationService {

    void validateProfileAccess(Account account, Profile profile);

    void validateDiaryAccess(Diary diary, Profile profile);

    void validateDiaryCommentAccess(DiaryComment diaryComment, Profile profile);

    void validateDiaryReplyAccess(DiaryReply diaryReply, Profile profile);

}
