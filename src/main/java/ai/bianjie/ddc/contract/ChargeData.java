package ai.bianjie.ddc.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class ChargeData extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b61006f565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b61099b8061007e6000396000f3fe608060405234801561001057600080fd5b50600436106100b35760003560e01c80637e4f7c65116100715780637e4f7c65146101395780638da5cb5b1461014c578063b7fa29f914610167578063c9c45a0f1461017a578063f2fde38b146101a2578063fe1e0335146101b557600080fd5b80620b8f70146100b8578063093f28e0146100e057806318160ddd146100f3578063322013231461010957806354d85c4e1461011c578063715018a61461012f575b600080fd5b6100cb6100c63660046107a8565b6101c8565b60405190151581526020015b60405180910390f35b6100cb6100ee3660046107e2565b61022a565b6100fb610299565b6040519081526020016100d7565b6100cb610117366004610815565b6102cd565b6100fb61012a3660046107a8565b610353565b61013761039c565b005b6101376101473660046107a8565b6103d2565b6000546040516001600160a01b0390911681526020016100d7565b6100cb6101753660046107a8565b610506565b61018d6101883660046107e2565b610555565b60405163ffffffff90911681526020016100d7565b6101376101b03660046107a8565b6105e8565b6100cb6101c3366004610865565b610683565b6004546000906001600160a01b031633146101fe5760405162461bcd60e51b81526004016101f5906108a1565b60405180910390fd5b506001600160a01b03811660009081526002602052604090206001908101805460ff191690555b919050565b6004546000906001600160a01b031633146102575760405162461bcd60e51b81526004016101f5906108a1565b506001600160a01b03821660009081526002602090815260408083206001600160e01b0319851684529091529020805463ffffffff1916905560015b92915050565b6004546000906001600160a01b031633146102c65760405162461bcd60e51b81526004016101f5906108a1565b5060015490565b6004546000906001600160a01b031633146102fa5760405162461bcd60e51b81526004016101f5906108a1565b506001600160a01b03831660009081526002602090815260408083206001818101805460ff1916821790556001600160e01b0319871685529252909120805463ffffffff841663ffffffff199091161790559392505050565b6004546000906001600160a01b031633146103805760405162461bcd60e51b81526004016101f5906108a1565b506001600160a01b031660009081526003602052604090205490565b6000546001600160a01b031633146103c65760405162461bcd60e51b81526004016101f5906108eb565b6103d06000610741565b565b6000546001600160a01b031633146103fc5760405162461bcd60e51b81526004016101f5906108eb565b6001600160a01b0381166104785760405162461bcd60e51b815260206004820152603a60248201527f436861726765446174613a206368617267654c6f676963436f6e74726163744160448201527f6464722063616e6e6f74206265207a65726f206164647265737300000000000060648201526084016101f5565b803b6104e45760405162461bcd60e51b815260206004820152603560248201527f436861726765446174613a206368617267654c6f676963436f6e74726163744160448201527419191c881a5cc81b9bdd08184818dbdb9d1c9858dd605a1b60648201526084016101f5565b600480546001600160a01b0319166001600160a01b0392909216919091179055565b6004546000906001600160a01b031633146105335760405162461bcd60e51b81526004016101f5906108a1565b506001600160a01b031660009081526002602052604090206001015460ff1690565b6004546000906001600160a01b031633146105825760405162461bcd60e51b81526004016101f5906108a1565b6001600160a01b03831660009081526002602052604090206001015460ff166105ad57506000610293565b506001600160a01b03821660009081526002602090815260408083206001600160e01b03198516845290915290205463ffffffff1692915050565b6000546001600160a01b031633146106125760405162461bcd60e51b81526004016101f5906108eb565b6001600160a01b0381166106775760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084016101f5565b61068081610741565b50565b6004546000906001600160a01b031633146106b05760405162461bcd60e51b81526004016101f5906108a1565b6001600160a01b038416156106f2576001600160a01b038416600090815260036020526040812080548492906106e7908490610936565b9091555061070a9050565b8160016000828254610704919061094d565b90915550505b6001600160a01b0383166000908152600360205260408120805484929061073290849061094d565b90915550600195945050505050565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b80356001600160a01b038116811461022557600080fd5b6000602082840312156107ba57600080fd5b6107c382610791565b9392505050565b80356001600160e01b03198116811461022557600080fd5b600080604083850312156107f557600080fd5b6107fe83610791565b915061080c602084016107ca565b90509250929050565b60008060006060848603121561082a57600080fd5b61083384610791565b9250610841602085016107ca565b9150604084013563ffffffff8116811461085a57600080fd5b809150509250925092565b60008060006060848603121561087a57600080fd5b61088384610791565b925061089160208501610791565b9150604084013590509250925092565b6020808252602a908201527f436861726765446174613a206f6e6c79206368617267652063616c6c207468696040820152691cc818dbdb9d1c9858dd60b21b606082015260800190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b634e487b7160e01b600052601160045260246000fd5b60008282101561094857610948610920565b500390565b6000821982111561096057610960610920565b50019056fea2646970667358221220b8f7059b85dc1f3dc4c30b579785a3eab43f8c3c71f5d371c1860dc81a27423264736f6c634300080b0033";

    public static final String FUNC_ADDFEE = "addFee";

    public static final String FUNC_CHECKDDC = "checkDDC";

    public static final String FUNC_DELDDC = "delDDC";

    public static final String FUNC_DELFEE = "delFee";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_QUERYACCOUNT = "queryAccount";

    public static final String FUNC_QUERYFEE = "queryFee";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETCHARGELOGICCONTRACTADDR = "setChargeLogicContractAddr";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ChargeData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChargeData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ChargeData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ChargeData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addFee(String ddcAddr, byte[] sig, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new org.web3j.abi.datatypes.generated.Bytes4(sig), 
                new Uint32(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> checkDDC(String ddcAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHECKDDC, 
                Arrays.<Type>asList(new Address(160, ddcAddr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> delDDC(String ddcAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELDDC, 
                Arrays.<Type>asList(new Address(160, ddcAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> delFee(String ddcAddr, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new org.web3j.abi.datatypes.generated.Bytes4(sig)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> queryAccount(String ddcAdd) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUERYACCOUNT, 
                Arrays.<Type>asList(new Address(160, ddcAdd)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> queryFee(String ddcAddr, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUERYFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new org.web3j.abi.datatypes.generated.Bytes4(sig)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> recharge(String from, String to, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setChargeLogicContractAddr(String chargeLogicContractAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCHARGELOGICCONTRACTADDR, 
                Arrays.<Type>asList(new Address(160, chargeLogicContractAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new Address(160, newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ChargeData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ChargeData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ChargeData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChargeData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChargeData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChargeData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChargeData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeData.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChargeData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargeData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ChargeData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeData.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChargeData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargeData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
