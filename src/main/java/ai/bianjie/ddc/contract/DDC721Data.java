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
public class DDC721Data extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b61006f565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b610f1d8061007e6000396000f3fe608060405234801561001057600080fd5b50600436106101375760003560e01c8063715018a6116100b8578063d302b0dc1161007c578063d302b0dc146102b4578063d3fc9864146102c7578063d7a78db8146102da578063e985e9c5146102ed578063eaf7e75014610339578063f2fde38b1461034c57600080fd5b8063715018a6146102785780638da5cb5b1461028057806395d89b41146102915780639dc29fac14610299578063cb83bf0d146102ac57600080fd5b8063367605ca116100ff578063367605ca146101c05780634cd88b761461020857806359735e591461021b5780636352211e1461022e57806370a082311461025757600080fd5b806306fdde031461013c578063081812fc1461015a578063095ea7b31461018557806323b872dd1461019a578063293ec97c146101ad575b600080fd5b61014461035f565b6040516101519190610afe565b60405180910390f35b61016d610168366004610b53565b6103f1565b6040516001600160a01b039091168152602001610151565b610198610193366004610b83565b610446565b005b6101986101a8366004610bad565b61049e565b6101446101bb366004610b53565b610553565b6101986101ce366004610be9565b6001600160a01b03928316600090815260076020908152604080832094909516825292909252919020805460ff1916911515919091179055565b610198610216366004610cd8565b6105f5565b610198610229366004610d3c565b61064b565b61016d61023c366004610b53565b6000908152600460205260409020546001600160a01b031690565b61026a610265366004610d3c565b610705565b604051908152602001610151565b61019861074e565b6000546001600160a01b031661016d565b610144610784565b6101986102a7366004610b83565b610793565b600a5461026a565b6101986102c2366004610b53565b61080a565b6101986102d5366004610d5e565b61084c565b6101986102e8366004610b53565b6108eb565b6103296102fb366004610db5565b6001600160a01b03918216600090815260076020908152604080832093909416825291909152205460ff1690565b6040519015158152602001610151565b610329610347366004610b53565b610930565b61019861035a366004610d3c565b61097a565b60606002805461036e90610de8565b80601f016020809104026020016040519081016040528092919081815260200182805461039a90610de8565b80156103e75780601f106103bc576101008083540402835291602001916103e7565b820191906000526020600020905b8154815290600101906020018083116103ca57829003601f168201915b5050505050905090565b6001546000906001600160a01b031633146104275760405162461bcd60e51b815260040161041e90610e23565b60405180910390fd5b506000818152600660205260409020546001600160a01b03165b919050565b6001546001600160a01b031633146104705760405162461bcd60e51b815260040161041e90610e23565b600090815260066020526040902080546001600160a01b0319166001600160a01b0392909216919091179055565b6001546001600160a01b031633146104c85760405162461bcd60e51b815260040161041e90610e23565b6001600160a01b03831660009081526005602052604081208054600192906104f1908490610e83565b90915550506001600160a01b038216600090815260056020526040812080546001929061051f908490610e9a565b9091555050600090815260046020526040902080546001600160a01b0319166001600160a01b039290921691909117905550565b600081815260086020526040902080546060919061057090610de8565b80601f016020809104026020016040519081016040528092919081815260200182805461059c90610de8565b80156105e95780601f106105be576101008083540402835291602001916105e9565b820191906000526020600020905b8154815290600101906020018083116105cc57829003601f168201915b50505050509050919050565b6001546001600160a01b0316331461061f5760405162461bcd60e51b815260040161041e90610e23565b8151610632906002906020850190610a65565b508051610646906003906020840190610a65565b505050565b6000546001600160a01b031633146106755760405162461bcd60e51b815260040161041e90610eb2565b6001600160a01b0381166106e35760405162461bcd60e51b815260206004820152602f60248201527f444443373231446174613a20736574206464633732314c6f67696320746f207460448201526e6865207a65726f206164647265737360881b606482015260840161041e565b600180546001600160a01b0319166001600160a01b0392909216919091179055565b6001546000906001600160a01b031633146107325760405162461bcd60e51b815260040161041e90610e23565b506001600160a01b031660009081526005602052604090205490565b6000546001600160a01b031633146107785760405162461bcd60e51b815260040161041e90610eb2565b6107826000610a15565b565b60606003805461036e90610de8565b6001546001600160a01b031633146107bd5760405162461bcd60e51b815260040161041e90610e23565b6001600160a01b03821660009081526005602052604081208054600192906107e6908490610e83565b9091555050600090815260046020526040902080546001600160a01b031916905550565b6001546001600160a01b031633146108345760405162461bcd60e51b815260040161041e90610e23565b6000908152600960205260409020805460ff19169055565b6001546001600160a01b031633146108765760405162461bcd60e51b815260040161041e90610e23565b6001600160a01b038316600090815260056020526040812080546001929061089f908490610e9a565b9091555050600082815260046020908152604080832080546001600160a01b0319166001600160a01b0388161790556008825290912082516108e392840190610a65565b5050600a5550565b6001546001600160a01b031633146109155760405162461bcd60e51b815260040161041e90610e23565b6000908152600960205260409020805460ff19166001179055565b6001546000906001600160a01b0316331461095d5760405162461bcd60e51b815260040161041e90610e23565b5060008181526009602052604090205460ff161515600114919050565b6000546001600160a01b031633146109a45760405162461bcd60e51b815260040161041e90610eb2565b6001600160a01b038116610a095760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b606482015260840161041e565b610a1281610a15565b50565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b828054610a7190610de8565b90600052602060002090601f016020900481019282610a935760008555610ad9565b82601f10610aac57805160ff1916838001178555610ad9565b82800160010185558215610ad9579182015b82811115610ad9578251825591602001919060010190610abe565b50610ae5929150610ae9565b5090565b5b80821115610ae55760008155600101610aea565b600060208083528351808285015260005b81811015610b2b57858101830151858201604001528201610b0f565b81811115610b3d576000604083870101525b50601f01601f1916929092016040019392505050565b600060208284031215610b6557600080fd5b5035919050565b80356001600160a01b038116811461044157600080fd5b60008060408385031215610b9657600080fd5b610b9f83610b6c565b946020939093013593505050565b600080600060608486031215610bc257600080fd5b610bcb84610b6c565b9250610bd960208501610b6c565b9150604084013590509250925092565b600080600060608486031215610bfe57600080fd5b610c0784610b6c565b9250610c1560208501610b6c565b915060408401358015158114610c2a57600080fd5b809150509250925092565b634e487b7160e01b600052604160045260246000fd5b600082601f830112610c5c57600080fd5b813567ffffffffffffffff80821115610c7757610c77610c35565b604051601f8301601f19908116603f01168101908282118183101715610c9f57610c9f610c35565b81604052838152866020858801011115610cb857600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060408385031215610ceb57600080fd5b823567ffffffffffffffff80821115610d0357600080fd5b610d0f86838701610c4b565b93506020850135915080821115610d2557600080fd5b50610d3285828601610c4b565b9150509250929050565b600060208284031215610d4e57600080fd5b610d5782610b6c565b9392505050565b600080600060608486031215610d7357600080fd5b610d7c84610b6c565b925060208401359150604084013567ffffffffffffffff811115610d9f57600080fd5b610dab86828701610c4b565b9150509250925092565b60008060408385031215610dc857600080fd5b610dd183610b6c565b9150610ddf60208401610b6c565b90509250929050565b600181811c90821680610dfc57607f821691505b60208210811415610e1d57634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602a908201527f646463373231646174613a2063616c6c6572206973206e6f742074686520444460408201526943373231206c6f67696360b01b606082015260800190565b634e487b7160e01b600052601160045260246000fd5b600082821015610e9557610e95610e6d565b500390565b60008219821115610ead57610ead610e6d565b500190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657260408201526060019056fea26469706673582212207494c54bbb632a8c0db3ff92244bc76d4725339cbf42821ee059f69f2495f93864736f6c634300080b0033";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_DDCURI = "ddcURI";

    public static final String FUNC_FREEZE = "freeze";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_ISENTERBLACKLIST = "isEnterBlacklist";

    public static final String FUNC_LASTDDCID = "lastDDCId";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETDDC721LOGICADDRESS = "setDDC721LogicAddress";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UNFREEZE = "unFreeze";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected DDC721Data(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DDC721Data(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DDC721Data(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DDC721Data(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(ddcId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, owner)),
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

    public RemoteFunctionCall<String> ddcURI(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DDCURI, 
                Arrays.<Type>asList(new Uint256(ddcId)),
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

    public RemoteFunctionCall<String> getApproved(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new Uint256(ddcId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(String name_, String symbol_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new Utf8String(name_),
                new Utf8String(symbol_)),
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

    public RemoteFunctionCall<TransactionReceipt> mint(String to, BigInteger ddcId, String _ddcURI) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(ddcId),
                new Utf8String(_ddcURI)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new Uint256(ddcId)),
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

    public RemoteFunctionCall<TransactionReceipt> setDDC721LogicAddress(String ddc721Logic) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDDC721LOGICADDRESS, 
                Arrays.<Type>asList(new Address(160, ddc721Logic)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(ddcId)),
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
    public static DDC721Data load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DDC721Data(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DDC721Data load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DDC721Data(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DDC721Data load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DDC721Data(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DDC721Data load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DDC721Data(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DDC721Data> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DDC721Data.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DDC721Data> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DDC721Data.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DDC721Data> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DDC721Data.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DDC721Data> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DDC721Data.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
