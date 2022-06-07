package ai.bianjie.ddc.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ai.bianjie.ddc.contract.Authority;
import org.web3j.utils.Strings;
import org.web3j.tuples.generated.Tuple7;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.dto.AccountInfo;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;


public class AuthorityService extends BaseService {
    private Authority authority;

    public AuthorityService(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
        this.authority = Web3jUtils.getAuthority();
    }

    /**
     * The platform side can create DDC account information by calling this method,
     * the upper-level role can operate the lower-level role account,
     * and the platform side can only add terminal accounts through this method.
     *
     * @param sender      Caller address
     * @param account     DDC chain account address
     * @param accountName The account name corresponding to the DDC account
     * @param accountDID  DID information corresponding to the DDC account
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String addAccountByPlatform(String sender, String account, String accountName, String accountDID) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(accountName)) {
            throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
        }

        String encodedFunction = authority.addAccountByPlatform(account, accountName, accountDID).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_ADDACCOUNTBYPLATFORM, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The platform side can create batches of DDC chain account information by calling this method,
     * the upper-level role can operate the lower-level role account,
     * and the platform side can only add terminal accounts through this method.
     *
     * @param sender   Caller address
     * @param accounts Account Information List
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String addBatchAccountByPlatform(String sender, List<AccountInfo> accounts) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (accounts == null || accounts.size() <= 0) {
            throw new DDCException(ErrorMessage.ERR_ACCOUNTS_SIZE);
        }

        List<String> accountNames = new ArrayList<>();
        List<String> accountDIDs = new ArrayList<>();
        List<String> accountAddress = new ArrayList<>();

        accounts.forEach((account) -> {
            if (Strings.isEmpty(account.getAddress())) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
            }

            if (!AddressUtils.isValidAddress(account.getAddress())) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
            }

            if (Strings.isEmpty(account.getAccountName())) {
                throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
            }

            accountNames.add(account.getAccountName());
            accountDIDs.add(account.getAccountDID());
            accountAddress.add(account.getAddress());
        });

        String encodedFunction = authority.addBatchAccountByPlatform(accountAddress, accountNames, accountDIDs).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_ADDBATCHACCOUNTBYPLATFORM, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The operator can set the platform side to add the chain account switch by calling this method.
     *
     * @param sender Caller address
     * @param isOpen Switch Identification
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String setSwitcherStateOfPlatform(String sender, boolean isOpen) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        String encodedFunction = authority.setSwitcherStateOfPlatform(isOpen).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_SETSWITCHERSTATEOFPLATFORM, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The operator can call this method to query the switch status of the added chain account on the platform side.
     *
     * @return switch status
     * @throws Exception
     */
    public Boolean switcherStateOfPlatform() throws Exception {
        return Web3jUtils.getAuthority().switcherStateOfPlatform().send();
    }

    /**
     * The operator can directly create the platform side or the end user of the platform side by calling this method.
     *
     * @param sender      Caller address
     * @param account     DDC chain account address
     * @param accountName The account name corresponding to the DDC account
     * @param accountDID  DID information corresponding to the DDC account
     * @param leaderDID   The DID of the superior account corresponding to the ordinary account
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String addAccountByOperator(String sender, String account, String accountName, String accountDID, String leaderDID) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(accountName)) {
            throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
        }

        String encodedFunction = authority.addAccountByOperator(account, accountName, accountDID, leaderDID).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_ADDACCOUNTBYOPERATOR, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The operator can directly create batches for the platform side or the end users of the platform side by calling this method.
     *
     * @param sender   Caller address
     * @param accounts Account Information List
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String addBatchAccountByOperator(String sender, List<AccountInfo> accounts) throws ExecutionException, InterruptedException {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (accounts == null || accounts.size() <= 0) {
            throw new DDCException(ErrorMessage.ERR_ACCOUNTS_SIZE);
        }

        List<String> accountNames = new ArrayList<>();
        List<String> accountDIDs = new ArrayList<>();
        List<String> accountAddress = new ArrayList<>();
        List<String> leaderDIDs = new ArrayList<>();

        accounts.forEach((account) -> {
            if (Strings.isEmpty(account.getAddress())) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
            }

            if (!AddressUtils.isValidAddress(account.getAddress())) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
            }

            if (Strings.isEmpty(account.getAccountName())) {
                throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
            }
            accountAddress.add(account.getAddress());
            accountNames.add(account.getAccountName());
            accountDIDs.add(account.getAccountDID());
            leaderDIDs.add(account.getLeaderDID());
        });

        String encodedFunction = authority.addBatchAccountByOperator(accountAddress, accountNames, accountDIDs, leaderDIDs).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_ADDBATCHACCOUNTBYOPERATOR, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * Operators, platform parties and end users can query DDC account information by calling this method.
     *
     * @param account DDC user chain account address
     * @return AccountInfo, DDC Account Information
     * @throws Exception
     */
    public AccountInfo getAccount(String account) throws Exception {
        if (Strings.isEmpty(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String> res = Web3jUtils.getAuthority().getAccount(account).send();
        return new AccountInfo(account, res.component1(), res.component2(), res.component3().toString(), res.component4(), res.component5().toString(), res.component6().toString(), res.component7());
    }

    /**
     * The operator or the platform can change the status of the DDC account information for the end user by calling this method.
     *
     * @param sender              Caller address
     * @param account             DDC user chain account address
     * @param state               Status: Frozen - Frozen; Active - Active
     * @param changePlatformState Modify the platform side status flag
     * @return hash, Transaction hash
     * @throws Exception
     */
    public String updateAccState(String sender, String account, BigInteger state, boolean changePlatformState) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        String encodedFunction = authority.updateAccountState(account, state, changePlatformState).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_UPDATEACCOUNTSTATE, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The operator can authorize the cross-platform operation of DDC by calling this method.
     *
     * @param sender   caller address
     * @param from     authorizer
     * @param to       receiver
     * @param approved authorization logo
     * @return returns the transaction hash
     * @throws Exception
     */
    public String crossPlatformApproval(String sender, String from, String to, boolean approved) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(from)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(from)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        String encodedFunction = authority.crossPlatformApproval(from, to, approved).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_CROSSPLATFORMAPPROVAL, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * The operator synchronizes the DID corresponding to the old platform party chain account to the chain by calling the API interface.
     *
     * @param sender caller address
     * @param dids   authorizer
     * @return returns the transaction hash
     * @throws Exception
     */
    public String syncPlatformDID(String sender, List<String> dids) throws Exception {
        if (Strings.isEmpty(sender)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        dids.forEach((did -> {
            if (Strings.isEmpty(did)) {
                throw new DDCException(ErrorMessage.DID_IS_EMPTY);
            }
        }));

        String encodedFunction = authority.syncPlatformDID(dids).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_SYNCPLATFORMDID, encodedFunction, signEventListener, sender).getTransactionHash();
    }
}
