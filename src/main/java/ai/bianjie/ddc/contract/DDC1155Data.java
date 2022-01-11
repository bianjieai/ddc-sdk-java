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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class DDC1155Data extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b61006f565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b610d148061007e6000396000f3fe608060405234801561001057600080fd5b50600436106100ff5760003560e01c8063bb7fde7111610097578063e985e9c511610066578063e985e9c51461021c578063eaf7e7501461022f578063f2fde38b14610242578063fe99049a1461025557600080fd5b8063bb7fde71146101db578063cb83bf0d146101ee578063d302b0dc146101f6578063d7a78db81461020957600080fd5b8063828f396c116100d3578063828f396c146101675780638da5cb5b1461017a5780639dc29fac14610195578063a54d3b06146101a857600080fd5b8062fdd58e14610104578063293ec97c1461012a578063367605ca1461014a578063715018a61461015f575b600080fd5b610117610112366004610996565b610268565b6040519081526020015b60405180910390f35b61013d6101383660046109c0565b6102c6565b60405161012191906109d9565b61015d610158366004610a2e565b610392565b005b61015d6103f6565b61015d610175366004610a7a565b61042c565b6000546040516001600160a01b039091168152602001610121565b61015d6101a3366004610996565b610555565b6101cb6101b63660046109c0565b60009081526006602052604090205460ff1690565b6040519015158152602001610121565b61015d6101e9366004610ab2565b6105b9565b600154610117565b61015d6102043660046109c0565b61065c565b61015d6102173660046109c0565b61069e565b6101cb61022a366004610b87565b6106e3565b6101cb61023d3660046109c0565b61073f565b61015d610250366004610a7a565b610782565b61015d610263366004610bba565b61081d565b6002546000906001600160a01b0316331461029e5760405162461bcd60e51b815260040161029590610bfc565b60405180910390fd5b5060009081526003602090815260408083206001600160a01b03949094168352929052205490565b6002546060906001600160a01b031633146102f35760405162461bcd60e51b815260040161029590610bfc565b6000828152600560205260409020805461030c90610c48565b80601f016020809104026020016040519081016040528092919081815260200182805461033890610c48565b80156103855780601f1061035a57610100808354040283529160200191610385565b820191906000526020600020905b81548152906001019060200180831161036857829003601f168201915b505050505090505b919050565b6002546001600160a01b031633146103bc5760405162461bcd60e51b815260040161029590610bfc565b6001600160a01b03928316600090815260046020908152604080832094909516825292909252919020805460ff1916911515919091179055565b6000546001600160a01b031633146104205760405162461bcd60e51b815260040161029590610c83565b61042a6000610896565b565b6000546001600160a01b031633146104565760405162461bcd60e51b815260040161029590610c83565b6001600160a01b0381166104ca5760405162461bcd60e51b815260206004820152603560248201527f44444331313535446174613a206e6f207a65726f2064646331313535206c6f676044820152746963616c20636f6e7472616374206164647265737360581b6064820152608401610295565b803b6105335760405162461bcd60e51b815260206004820152603260248201527f44444331313535446174613a206e6f20612064646331313535206c6f676963616044820152716c20636f6e7472616374206164647265737360701b6064820152608401610295565b600280546001600160a01b0319166001600160a01b0392909216919091179055565b6002546001600160a01b0316331461057f5760405162461bcd60e51b815260040161029590610bfc565b60008181526003602090815260408083206001600160a01b039095168352938152838220829055918152600790915220805460ff19169055565b6002546001600160a01b031633146105e35760405162461bcd60e51b815260040161029590610bfc565b60008381526003602090815260408083206001600160a01b038816845290915281208054849290610615908490610cb8565b909155505060008381526005602090815260409091208251610639928401906108e6565b5050506000818152600660205260409020805460ff191660019081179091555550565b6002546001600160a01b031633146106865760405162461bcd60e51b815260040161029590610bfc565b6000908152600760205260409020805460ff19169055565b6002546001600160a01b031633146106c85760405162461bcd60e51b815260040161029590610bfc565b6000908152600760205260409020805460ff19166001179055565b6002546000906001600160a01b031633146107105760405162461bcd60e51b815260040161029590610bfc565b506001600160a01b03918216600090815260046020908152604080832093909416825291909152205460ff1690565b6002546000906001600160a01b0316331461076c5760405162461bcd60e51b815260040161029590610bfc565b5060009081526007602052604090205460ff1690565b6000546001600160a01b031633146107ac5760405162461bcd60e51b815260040161029590610c83565b6001600160a01b0381166108115760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b6064820152608401610295565b61081a81610896565b50565b6002546001600160a01b031633146108475760405162461bcd60e51b815260040161029590610bfc565b60008281526003602090815260408083206001600160a01b038881168552925280832080548581039091559186168352822080549192849261088a908490610cb8565b90915550505050505050565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b8280546108f290610c48565b90600052602060002090601f016020900481019282610914576000855561095a565b82601f1061092d57805160ff191683800117855561095a565b8280016001018555821561095a579182015b8281111561095a57825182559160200191906001019061093f565b5061096692915061096a565b5090565b5b80821115610966576000815560010161096b565b80356001600160a01b038116811461038d57600080fd5b600080604083850312156109a957600080fd5b6109b28361097f565b946020939093013593505050565b6000602082840312156109d257600080fd5b5035919050565b600060208083528351808285015260005b81811015610a06578581018301518582016040015282016109ea565b81811115610a18576000604083870101525b50601f01601f1916929092016040019392505050565b600080600060608486031215610a4357600080fd5b610a4c8461097f565b9250610a5a6020850161097f565b915060408401358015158114610a6f57600080fd5b809150509250925092565b600060208284031215610a8c57600080fd5b610a958261097f565b9392505050565b634e487b7160e01b600052604160045260246000fd5b60008060008060808587031215610ac857600080fd5b610ad18561097f565b93506020850135925060408501359150606085013567ffffffffffffffff80821115610afc57600080fd5b818701915087601f830112610b1057600080fd5b813581811115610b2257610b22610a9c565b604051601f8201601f19908116603f01168101908382118183101715610b4a57610b4a610a9c565b816040528281528a6020848701011115610b6357600080fd5b82602086016020830137600060208483010152809550505050505092959194509250565b60008060408385031215610b9a57600080fd5b610ba38361097f565b9150610bb16020840161097f565b90509250929050565b60008060008060808587031215610bd057600080fd5b610bd98561097f565b9350610be76020860161097f565b93969395505050506040820135916060013590565b6020808252602c908201527f44444331313535446174613a2063616c6c6572206973206e6f7420746865204460408201526b444331313535206c6f67696360a01b606082015260800190565b600181811c90821680610c5c57607f821691505b60208210811415610c7d57634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b60008219821115610cd957634e487b7160e01b600052601160045260246000fd5b50019056fea2646970667358221220a8cdf3c792a7d39b6fb30d5096aa7778989d6159db817e5ef91ae5ab4f1a0d5864736f6c634300080b0033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_DDCIDISEXIST = "ddcIdIsExist";

    public static final String FUNC_DDCURI = "ddcURI";

    public static final String FUNC_FREEZE = "freeze";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_ISENTERBLACKLIST = "isEnterBlacklist";

    public static final String FUNC_LASTDDCID = "lastDDCId";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETDDC1155LOGICADDRESS = "setDDC1155LogicAddress";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UNFREEZE = "unFreeze";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected DDC1155Data(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DDC1155Data(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DDC1155Data(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DDC1155Data(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<BigInteger> balanceOf(String account, BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, account),
                new Uint256(ddcId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(String owner, BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new Address(160, owner),
                new Uint256(ddcId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> ddcIdIsExist(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DDCIDISEXIST, 
                Arrays.<Type>asList(new Uint256(ddcId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> ddcURI(BigInteger _ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DDCURI, 
                Arrays.<Type>asList(new Uint256(_ddcId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> freeze(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FREEZE, 
                Arrays.<Type>asList(new Uint256(ddcId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, operator)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isEnterBlacklist(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISENTERBLACKLIST, 
                Arrays.<Type>asList(new Uint256(ddcId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> lastDDCId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LASTDDCID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String to, BigInteger ddcId, BigInteger amount, String _ddcURI) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(ddcId),
                new Uint256(amount),
                new Utf8String(_ddcURI)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String owner, String operator, Boolean approved) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, operator),
                new Bool(approved)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDDC1155LogicAddress(String ddc1155LogicAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDDC1155LOGICADDRESS, 
                Arrays.<Type>asList(new Address(160, ddc1155LogicAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger ddcId, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(ddcId),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new Address(160, newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unFreeze(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNFREEZE, 
                Arrays.<Type>asList(new Uint256(ddcId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DDC1155Data load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DDC1155Data(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DDC1155Data load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DDC1155Data(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DDC1155Data load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DDC1155Data(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DDC1155Data load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DDC1155Data(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DDC1155Data> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DDC1155Data.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DDC1155Data> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DDC1155Data.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DDC1155Data> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DDC1155Data.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DDC1155Data> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DDC1155Data.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
