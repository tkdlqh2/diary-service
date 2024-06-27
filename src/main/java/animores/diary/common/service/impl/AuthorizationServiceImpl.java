package animores.diary.common.service.impl;

import animores.diary.account.entity.Account;
import animores.diary.common.exception.CustomException;
import animores.diary.common.exception.ExceptionCode;
import animores.diary.common.service.AuthorizationService;
import animores.diary.diary.entity.Diary;
import animores.diary.diary.entity.DiaryComment;
import animores.diary.diary.entity.DiaryReply;
import animores.diary.profile.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public void validateProfileAccess(Account account, Profile profile) {
        if (!account.getId().equals(profile.getAccount().getId())) {
            throw new CustomException(ExceptionCode.UNAUTHORIZED_PROFILE_ACCESS);
        }
    }

    @Override
    public void validateDiaryAccess(Diary diary, Profile profile) {
        if (!diary.getProfile().getId().equals(profile.getId())) {
            throw new CustomException(ExceptionCode.UNAUTHORIZED_DIARY_ACCESS);
        }
    }

    @Override
    public void validateDiaryCommentAccess(DiaryComment diaryComment, Profile profile) {
        if (!diaryComment.getProfile().getId().equals(profile.getId())) {
            throw new CustomException(ExceptionCode.UNAUTHORIZED_DIARY_COMMENT_ACCESS);
        }
    }

    @Override
    public void validateDiaryReplyAccess(DiaryReply diaryReply, Profile profile) {
        if (!diaryReply.getProfile().getId().equals(profile.getId())) {
            throw new CustomException(ExceptionCode.UNAUTHORIZED_DIARY_REPLY_ACCESS);
        }
    }
}
