package ai.bianjie.ddc.service;

import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.Charge;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.HexUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.utils.Numeric;
import org.web3j.utils.Strings;

import java.math.BigInteger;

public class ChargeService extends BaseService {
    private Charge charge;

    public ChargeService(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
        this.charge = Web3jUtils.getCharge();
    }


    /**
     * The operator and the platform party call this interface to recharge the account of the same level or the lower-level account of the same party;
     *
     * @param sender Caller address
     * @param to     Deposit account address
     * @param amount Recharge amount
     * @return hash, transaction hash
     * @throws Exception
     */
    public String recharge(String sender, String to, BigInteger amount) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (amount == null || amount.compareTo(new BigInteger(String.valueOf(0))) <= 0) {
            throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
        }
        String encodedFunction = charge.recharge(to, amount).encodeFunctionCall();

        return signAndSend(charge, Charge.FUNC_RECHARGE, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * Query the balance of the specified account.
     *
     * @param accAddr Query account address
     * @return balance, Business fee balance corresponding to the account
     * @throws Exception
     */
    public BigInteger balanceOf(String accAddr) throws Exception {

        if (Strings.isEmpty(accAddr)) {
            throw new DDCException(ErrorMessage.ACC_ADDR_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(accAddr)) {
            throw new DDCException(ErrorMessage.ACC_ADDR_IS_NOT_ADDRESS_FORMAT);
        }

        return Web3jUtils.getCharge().balanceOf(accAddr).send();
    }

    /**
     * Query the call business fee corresponding to the method of the specified DDC business main logic contract.
     *
     * @param ddcAddr DDC business contract address
     * @param sig     Hex format Contract method ID
     * @return fee, The queried DDC contract business fee
     * @throws Exception
     */
    public BigInteger queryFee(String ddcAddr, String sig) throws Exception {

        if (Strings.isEmpty(ddcAddr)) {
            throw new DDCException(ErrorMessage.DDC_ADDR_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(ddcAddr)) {
            throw new DDCException(ErrorMessage.DDC_ADDR_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(sig)) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }

        if (!HexUtils.isValid4ByteHash(sig)) {
            throw new DDCException(ErrorMessage.SIG_IS_NOT_4BYTE_HASH);
        }
        byte[] sigInByte = Numeric.hexStringToByteArray(sig);

        return Web3jUtils.getCharge().queryFee(ddcAddr, sigInByte).send();
    }

}