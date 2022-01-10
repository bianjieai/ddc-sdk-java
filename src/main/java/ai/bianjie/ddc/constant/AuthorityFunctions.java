package ai.bianjie.ddc.constant;

public class AuthorityFunctions {
    public static final String AddAccount = "addAccount";
    
    public static final String AddConsumerByOperator = "addConsumerByOperator";
    
    public static final String DelAccount = "DelAccount";
    
    public static final String GetAccount = "getAccount";
    
    public static final String UpdateAccountState = "updateAccountState";


    public static final String AddAccountEvent = "AddAccount(address,string,string,uint8,string,uint8,uint8,string)";
    public static final String DelAccountEvent = "DelAccount(address)";
    public static final String UpdateAccountEvent = "UpdateAccount(address,string,string,uint8,string,uint8,uint8,string)";
    public static final String UpdateAccountStateEvent = "UpdateAccountState(address,uint8,uint8)";
}
