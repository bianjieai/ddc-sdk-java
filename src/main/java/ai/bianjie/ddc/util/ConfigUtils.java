package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigInfo;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;

import java.io.*;

public class ConfigUtils {
	
//	public static final String OPB_GATE_WAY_ADDRESS = "opbGatewayAddress";
//
//	public static final String CONTRACT = "contract";
//
//	public static final String DDC_721_CONTRACT_ADDR = "ddc721Addr";
//
//	public static final String DDC_1155_CONRACT_ADDR = "ddc1155Addr";
//
//	public static final String AUTHORITY_LOGIC_ADDR = "authorityLogicAddr";
//
//	public static final String CHARGE_LOGIC_ADDR = "chargeLogicAddr";

	public static final String DDC721_BIN_FILE = "contract/DDC721.bin";
	
	public static final String DDC1155_BIN_FILE = "contract/DDC1155.bin";

	public static final String AUTHORITY_BIN_FILE = "contract/AuthorityLogic.bin";

	public static final String RECHARGE_BIN_FILE = "contract/ChargeLogic.bin";
	
	public static final String PRIVATE_KEY_FILE = "cert/privateKey.pem";
	
	public static final String PUBLIC_KEY_FILE = "cert/publicKey.pem";
	
	/**
	 * 解析默认位置的位置文件，并验证配置项，组装成配置对象
	 * 
	 * @return 返回配置对象
	 */
	public static ConfigInfo loadConfigFromFile() {
		
		ConfigInfo configInfo = new ConfigInfo();
		

		
//		if(isEmpty(signMethod)) {
//			throw new DDCException(ErrorMessage.SIGN_METHOD_EMPTY);
//		}
//		configInfo.setSignMethod(signMethod);
		
		String ddc721bin = readFileContent(DDC721_BIN_FILE);
		configInfo.setDdc721BIN(ddc721bin);

		String ddc1155bin = readFileContent(DDC1155_BIN_FILE);
		configInfo.setDdc1155BIN(ddc1155bin);

		String authorityLogicBIN = readFileContent(AUTHORITY_BIN_FILE);
		configInfo.setAuthorityLogicBIN(authorityLogicBIN);

		String reChargeLogicBIN = readFileContent(RECHARGE_BIN_FILE);
		configInfo.setChargeLogicBIN(reChargeLogicBIN);
		
//		if(configInfo.isSignMethodPrivateKey()) {
//			String privateKey = null;
//			try {
//				privateKey = readFileContent(PRIVATE_KEY_FILE);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			configInfo.setPrivateKey(privateKey);
//			
//			String publicKey = null;
//			try {
//				publicKey = readFileContent(PUBLIC_KEY_FILE);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			configInfo.setPublicKey(publicKey);
//		}
		
		return configInfo;
	}
	
	
	private static boolean isEmpty(String str) {
		return (str == null || str.trim().isEmpty());
	}
	
	
	public static String readFileContent(String fileName) {
		InputStream inputStream = getInputStream(fileName);
		byte[] bytes = new byte[1024*1024];
		try {
			int count = inputStream.read(bytes);
			return new String(bytes,0,count);
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new DDCException(ErrorMessage.FILE_NOT_EXISTS);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			} 
		}
	}
	
	public static InputStream getInputStream(String fileName) {
		InputStream inputStream = null;
		inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream(fileName);
		if(inputStream == null) {
//				File configYamlFile = ResourceUtils.getFile(fileName);
//				inputStream = new FileInputStream(configYamlFile);
			throw new DDCException(ErrorMessage.FILE_NOT_EXISTS);
		}

		return inputStream;
	}
	
}
