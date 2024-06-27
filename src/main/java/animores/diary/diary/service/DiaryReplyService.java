package animores.diary.diary.service;


import animores.diary.account.entity.Account;
import animores.diary.diary.dto.AddDiaryReplyRequest;
import animores.diary.diary.dto.EditDiaryReplyRequest;
import animores.diary.diary.dto.RemoveDiaryReplyRequest;

public interface DiaryReplyService {

    public void addDiaryReply(Account account, AddDiaryReplyRequest request);

    public void editDiaryReply(Account account, Long replyId, EditDiaryReplyRequest request);

    public void removeDiaryReply(Account account, Long replyId, RemoveDiaryReplyRequest request);

}
