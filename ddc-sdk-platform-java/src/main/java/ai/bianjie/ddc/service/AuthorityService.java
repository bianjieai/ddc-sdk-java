package ai.bianjie.ddc.service;

import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.Authority;
import ai.bianjie.ddc.dto.AccountInfo;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.utils.Strings;

import java.math.BigInteger;


public class AuthorityService extends BaseService {
    private Authority authority;

    public AuthorityService(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
        this.authority = Web3jUtils.getAuthority();
    }

    /**
     * Operators, platform parties and end users can query DDC account information by calling this method.
     *
     * @param account DDC user chain account address
     * @return returns DDC account information
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
        return new AccountInfo(res.component1(), res.component2(), res.component3().toString(), res.component4(), res.component5().toString(), res.component6().toString(), res.component7());
    }

    /**
     * The operator or the platform can change the status of the DDC account information for the end user by calling this method.
     *
     * @param sender Caller address
     * @param account DDC user chain account address
     * @param state State: Frozen - frozen state; Active - active state
     * @param changePlatformState Modify the platform state identifier
     * @return hash, transaction hash
     * @throws Exception
     */
    public String updateAccState(String sender, String account, BigInteger state, boolean changePlatformState) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(account)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (state == null) {
            throw new DDCException(ErrorMessage.ACCOUNT_STASTUS_IS_EMPTY);
        }

        String encodedFunction = authority.updateAccountState(account, state, changePlatformState).encodeFunctionCall();
        return signAndSend(authority, Authority.FUNC_UPDATEACCOUNTSTATE, encodedFunction, signEventListener, sender).getTransactionHash();
    }

}
