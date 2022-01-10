package ai.bianjie.ddc.util;

import org.web3j.protocol.core.methods.response.BaseEventResponse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

public class CommonUtils {
    /**
     * String转换为BigInteger
     */
    public static BigInteger string2BigInteger(String val) {
        boolean numeric00 = CommonUtils.isNumeric00(val);
        if(numeric00){
            return BigInteger.valueOf(Long.valueOf(val));
        }else{
            throw new NumberFormatException();
        }
    }

    /**
     * 判断字符串是否由数字组成
     * @param str
     * @return
     */
    public static boolean isNumeric00(String str) {
        try{
            Long.parseLong(str);
            return true;
        }catch(NumberFormatException e)
        {
//            System.out.println("异常：\"" + str + "\"不是数字/整数...");
            return false;
        }
    }

}
