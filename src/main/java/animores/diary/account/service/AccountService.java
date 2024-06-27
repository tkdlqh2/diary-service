package animores.diary.account.service;

import animores.diary.account.entity.Account;

public interface AccountService {
    Account getAccount();
    Account getAccountFromContext();
}
