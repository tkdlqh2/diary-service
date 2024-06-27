package animores.diary.diary.service.impl;

import animores.diary.account.entity.Account;
import animores.diary.common.exception.CustomException;
import animores.diary.common.exception.ExceptionCode;
import animores.diary.common.service.AuthorizationService;
import animores.diary.diary.dto.AddDiaryReplyRequest;
import animores.diary.diary.dto.EditDiaryReplyRequest;
import animores.diary.diary.dto.RemoveDiaryReplyRequest;
import animores.diary.diary.entity.DiaryComment;
import animores.diary.diary.entity.DiaryReply;
import animores.diary.diary.repository.DiaryCommentRepository;
import animores.diary.diary.repository.DiaryReplyRepository;
import animores.diary.diary.service.DiaryReplyService;
import animores.diary.profile.entity.Profile;
import animores.diary.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DiaryReplyServiceImpl implements DiaryReplyService {
    private final ProfileRepository profileRepository;
    private final AuthorizationService authorizationService;
    private final DiaryCommentRepository diaryCommentRepository;
    private final DiaryReplyRepository diaryReplyRepository;

    @Override
    @Transactional
    public void addDiaryReply(Account account, AddDiaryReplyRequest request) {
        Profile profile = findProfileById(request.profileId());
        DiaryComment diaryComment = findDiaryComment(request.diaryCommentId());

        diaryReplyRepository.save(DiaryReply.create(diaryComment, profile, request.content()));
    }

    @Override
    @Transactional
    public void editDiaryReply(Account account, Long replyId, EditDiaryReplyRequest request) {
        Profile profile = findProfileById(request.profileId());
        DiaryReply diaryReply = findDiaryReply(replyId);

        authorizationService.validateDiaryReplyAccess(diaryReply, profile);

        diaryReply.updateContent(request.content());
    }

    @Override
    @Transactional
    public void removeDiaryReply(Account account, Long replyId, RemoveDiaryReplyRequest request) {
        Profile profile = findProfileById(request.profileId());
        DiaryReply diaryReply = findDiaryReply(replyId);

        authorizationService.validateDiaryReplyAccess(diaryReply, profile);

        diaryReply.delete();
    }

    private Profile findProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionCode.INVALID_PROFILE));
    }

    public DiaryComment findDiaryComment(Long id) {
        return diaryCommentRepository.findByIdAndDeletedDtIsNull(id)
            .orElseThrow(() -> new CustomException(ExceptionCode.NOT_FOUND_DIARY_COMMENT));
    }

    private DiaryReply findDiaryReply(Long id) {
        return diaryReplyRepository.findByIdAndDeletedDtIsNull(id)
            .orElseThrow(() -> new CustomException(ExceptionCode.NOT_FOUND_DIARY_REPLY));
    }
}
