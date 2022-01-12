package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.AuthorityFunctions;
import ai.bianjie.ddc.contract.AuthorityLogic;
import ai.bianjie.ddc.contract.ChargeLogic;
import ai.bianjie.ddc.util.CommonUtils;
import ai.bianjie.ddc.util.GasProvider;
import ai.bianjie.ddc.util.Web3jUtils;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestService {
    public void test() throws Exception {
        Web3j web3j = Web3jUtils.getWeb3j();
//        Web3j web3j = Web3j.build(new HttpService("http://192.168.150.43:8545"));
//        Credentials credentials = Credentials.create("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        String contractAddr = "0x368d4064762a22640E8a79cA6B62F0815f3e2F9C";
//        ChargeLogic chargeLogic = ChargeLogic.load(contractAddr, web3j, credentials, new GasProvider());
//        BigInteger res = chargeLogic.balanceOf(account).send();
//        System.out.println("002---------------------------------------------------------------------------------");
//
//        System.out.println("003---------------------------------------------------------------------------------");
//        return res.toString();


//        Request<?, EthBlock> ethBlockRequest = web3j.ethGetBlockByHash("0x381b09c7503ef16bcf585878a0e8fc503475643ab3314494b91664488d0e3eab",true);


//        Request<?, EthBlock> ethBlockRequest = web3j.ethGetBlockByNumber(CommonUtils.getDefaultBlockParamter(160506),true);
//        EthBlock send = ethBlockRequest.send();
//        List<EthBlock.TransactionResult> transactionResults = send.getBlock().getTransactions();
//        if (transactionResults != null) {
//            transactionResults.forEach(tr->{
//                EthBlock.TransactionObject obj = (EthBlock.TransactionObject) tr.get();
//                System.out.println(obj.getHash());
//            });
//        }
//        System.out.println("--------------------------");

//        List<BaseEventResponse> list = new ArrayList<>();
        TransactionReceipt receipt = web3j.ethGetTransactionReceipt("0x0ad7630c5336913a823e640df71460b260b7e068080b64ec2650a34e805c3184").send().getTransactionReceipt().get();
        System.out.println(receipt);
//        for (int i = 0; i < receipt.getLogs().size(); i++) {
//            Log log = receipt.getLogs().get(i);
//            String address = log.getAddress();
//            System.out.println("my topics" + log.getTopics().get(0));
//            if (ConfigCache.get().getAuthorityLogicAddress().equalsIgnoreCase(log.getAddress())) {
//                //List<Type> res = FunctionReturnDecoder.decode(log.getData(), AuthorityLogic.ADDACCOUNT_EVENT.getParameters());
//                AuthorityLogic authorityLogic = web3jUtils.getAuthority();
//                if (log.getTopics().get(0).equals(AuthorityFunctions.AddAccountEvent)) {
//                    List<AuthorityLogic.AddAccountEventResponse> responses = authorityLogic.getAddAccountEvents(receipt);
//                    list.addAll(responses);
//                }if (log.getTopics().get(0).equals(AuthorityFunctions.UpdateAccountEvent)) {
//                    List<AuthorityLogic.UpdateAccountEventResponse> responses = authorityLogic.getUpdateAccountEvents(receipt);
//                    list.addAll(responses);
//                }if (log.getTopics().get(0).equals(AuthorityFunctions.UpdateAccountStateEvent)) {
//                    List<AuthorityLogic.UpdateAccountStateEventResponse> responses = authorityLogic.getUpdateAccountStateEvents(receipt);
//                    list.addAll(responses);
//                }
//            }
//        }
//        list.forEach(l->{
//            System.out.println("----------------------------------");
//
//            System.out.println(l);
//        });
    }

}
