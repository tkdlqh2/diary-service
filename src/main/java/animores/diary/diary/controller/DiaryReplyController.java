package animores.diary.diary.controller;

import animores.diary.account.entity.Account;
import animores.diary.account.service.AccountService;
import animores.diary.common.Response;
import animores.diary.common.aop.UserInfo;
import animores.diary.diary.dto.AddDiaryReplyRequest;
import animores.diary.diary.dto.EditDiaryReplyRequest;
import animores.diary.diary.dto.RemoveDiaryReplyRequest;
import animores.diary.diary.service.DiaryReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@PreAuthorize("hasAuthority('USER')")
//@SecurityRequirement(name = "Authorization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/diary-reply")
public class DiaryReplyController {

    private final AccountService accountService;
    private final DiaryReplyService diaryReplyService;

    @UserInfo
    @PostMapping("")
    @Operation(summary = "대댓글 작성", description = "대댓글을 작성합니다.")
    public Response<Void> addDiaryReply(
        @RequestBody @Parameter(description = "대댓글 작성에 대한 요청 데이터", required = true) AddDiaryReplyRequest request) {
        Account account = accountService.getAccountFromContext();
        diaryReplyService.addDiaryReply(account, request);
        return Response.success(null);
    }

    @UserInfo
    @PatchMapping("/{replyId}")
    @Operation(summary = "대댓글 수정", description = "대댓글을 수정합니다.")
    public Response<Void> editDiaryReply(
        @PathVariable @Parameter(description = "대댓글 아이디", required = true) Long replyId,
        @RequestBody @Parameter(description = "대댓글 수정에 대한 요청 데이터", required = true) EditDiaryReplyRequest request) {
        Account account = accountService.getAccountFromContext();
        diaryReplyService.editDiaryReply(account, replyId, request);
        return Response.success(null);
    }

    @UserInfo
    @DeleteMapping("/{replyId}")
    @Operation(summary = "대댓글 삭제", description = "대댓글을 삭제합니다.")
    public Response<Void> removeDiaryReply(
        @PathVariable @Parameter(description = "대댓글 아이디", required = true) Long replyId,
        @RequestBody @Parameter(description = "대댓글 삭제에 대한 요청 데이터", required = true) RemoveDiaryReplyRequest request) {
        Account account = accountService.getAccountFromContext();
        diaryReplyService.removeDiaryReply(account, replyId, request);
        return Response.success(null);

    }
}
