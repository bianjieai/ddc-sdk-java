package ai.bianjie.ddc.service;

import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.ChargeLogic;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.HexUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.utils.Strings;

import java.math.BigInteger;

public class ChargeService extends BaseService {

	public ChargeService(SignEventListener signEventListener) {
		super.signEventListener = signEventListener;
	}

	/**
	 * 运营方、平台方调用该接口为所属同一方的同一级别账户或者下级账户充值；
	 *
	 * @param to 充值账户的地址
	 * @param amount 充值金额
	 * @return 返回交易哈希
	 * @throws Exception
	 */
	public String recharge(String to, BigInteger amount) throws Exception {
		if (Strings.isEmpty(to)) {
			throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
		}

		if (!AddressUtils.isValidAddress(to)) {
			throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
		}


		if (amount == null || amount.intValue() <= 0) {
			throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
		}

		return Web3jUtils.getCharge().recharge(to, amount).send().getTransactionHash();
	}

	/**
	 * 查询指定账户的余额。
	 *
	 * @param accAddr 查询的账户地址
	 * @return 返回账户所对应的业务费余额
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
	 * Hex字符串转byte
	 * @param inHex 待转换的Hex字符串
	 * @return  转换后的byte
	 */
	private byte hexToByte(String inHex){
		return (byte)Integer.parseInt(inHex,16);
	}

	/**
	 * hex字符串转byte数组
	 * @param inHex 待转换的Hex字符串
	 * @return  转换后的byte数组结果
	 */
	private byte[] hexToByteArray(String inHex){
		int hexlen = inHex.length();
		byte[] result;
		if (hexlen % 2 == 1){
			hexlen++;
			result = new byte[(hexlen/2)];
			inHex="0"+inHex;
		}else {
			result = new byte[(hexlen/2)];
		}
		int j=0;
		for (int i = 0; i < hexlen; i+=2){
			result[j]=hexToByte(inHex.substring(i,i+2));
			j++;
		}
		return result;
	}

	/**
	 * 查询指定的DDC业务主逻辑合约的方法所对应的调用业务费用。
	 *
	 * @param ddcAddr DDC业务主逻辑合约地址
	 * @param sig Hex格式的合约方法ID
	 * @return 返回DDC合约业务费
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

		return Web3jUtils.getCharge().queryFee(ddcAddr, hexToByteArray(sig)).send();
	}

	/**
	 * 运营方调用为自己的账户增加业务费。
	 *
	 * @param amount 对运营方账户进行充值的业务费
	 * @return 返回交易哈希
	 * @throws Exception
	 */
	public String selfRecharge(BigInteger amount) throws Exception {
		if (amount == null || amount.intValue() <= 0) {
			throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
		}

		return Web3jUtils.getCharge().selfRecharge(amount).send().getTransactionHash();
	}

	/**
	 * 运营方调用接口设置指定的DDC主合约的方法调用费用。
	 *
	 * @param ddcAddr DDC业务主逻辑合约地址
	 * @param sig Hex格式的合约方法ID
	 * @param amount 业务费用
	 * @return 返回交易哈希
	 * @throws Exception
	 */
	public String setFee(String ddcAddr, String sig, BigInteger amount) throws Exception {
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

		if (amount == null || amount.intValue() <= 0) {
			throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
		}

		return Web3jUtils.getCharge().setFee(ddcAddr, hexToByteArray(sig), amount).send().getTransactionHash();
	}

	/**
	 * 运营方调用接口删除指定的DDC主合约的方法调用费用。
	 *
	 * @param ddcAddr DDC业务主逻辑合约地址
	 * @param sig Hex格式的合约方法ID
	 * @return 返回交易哈希
	 * @throws Exception
	 */
	public String delFee(String ddcAddr, String sig) throws Exception {
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

		return Web3jUtils.getCharge().deleteFee(ddcAddr, hexToByteArray(sig)).send().getTransactionHash();
	}

	/**
	 * 运营方调用该接口删除指定的DDC业务主逻辑合约授权。
	 *
	 * @param ddcAddr DDC业务主逻辑合约地址
	 * @return 返回交易哈希
	 * @throws Exception
	 */
	public String delDDC(String ddcAddr) throws Exception {
		if (Strings.isEmpty(ddcAddr)) {
			throw new DDCException(ErrorMessage.DDC_ADDR_IS_EMPTY);
		}

		if (!AddressUtils.isValidAddress(ddcAddr)) {
			throw new DDCException(ErrorMessage.DDC_ADDR_IS_NOT_ADDRESS_FORMAT);
		}

		return Web3jUtils.getCharge().deleteDDC(ddcAddr).send().getTransactionHash();
	}

}
