package ai.bianjie.ddc.contract;

import ai.bianjie.ddc.config.ConfigCache;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes4;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
public class AuthorityLogic extends Contract {
    public static final String BINARY = ConfigCache.get().getAuthorityLogicBIN();

    public static final String FUNC_ACCOUNTAVAILABLE = "accountAvailable";

    public static final String FUNC_ADDACCOUNT = "addAccount";

    public static final String FUNC_ADDCONSUMERBYOPERATOR = "addConsumerByOperator";

    public static final String FUNC_ADDFUNCTION = "addFunction";

    public static final String FUNC_ADDOPERATOR = "addOperator";

    public static final String FUNC_ASSERTACCOUNTROLE = "assertAccountRole";

    public static final String FUNC_DELFUNCTION = "delFunction";

    public static final String FUNC_GETACCOUNT = "getAccount";

    public static final String FUNC_GETAUTHORITYDATACONTRACTADDR = "getAuthorityDataContractAddr";

    public static final String FUNC_GETFUNCTION = "getFunction";

    public static final String FUNC_HASFUNCTIONPERMISSION = "hasFunctionPermission";

    public static final String FUNC_LEADERCHECK = "leaderCheck";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SAMEDIDCHECK = "sameDIDCheck";

    public static final String FUNC_SAMELEADERCHECK = "sameLeaderCheck";

    public static final String FUNC_SAMEPLATFORMMANAGERCHECK = "samePlatformManagerCheck";

    public static final String FUNC_SETAUTHORITYDATACONTRACTADDR = "setAuthorityDataContractAddr";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPDATEACCOUNTSTATE = "updateAccountState";

    public static final Event ADDACCOUNT_EVENT = new Event("AddAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event DELACCOUNT_EVENT = new Event("DelAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event UPDATEACCOUNT_EVENT = new Event("UpdateAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event UPDATEACCOUNTSTATE_EVENT = new Event("UpdateAccountState", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected AuthorityLogic(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AuthorityLogic(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AuthorityLogic(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AuthorityLogic(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddAccountEventResponse> getAddAccountEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADDACCOUNT_EVENT, transactionReceipt);
        ArrayList<AddAccountEventResponse> responses = new ArrayList<AddAccountEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AddAccountEventResponse typedResponse = new AddAccountEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.caller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.accountDID = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.accountName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.accountRole = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.leaderDID = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.field = (String) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddAccountEventResponse> addAccountEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddAccountEventResponse>() {
            @Override
            public AddAccountEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ADDACCOUNT_EVENT, log);
                AddAccountEventResponse typedResponse = new AddAccountEventResponse();
                typedResponse.log = log;
                typedResponse.caller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.accountDID = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.accountName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.accountRole = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.leaderDID = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.field = (String) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddAccountEventResponse> addAccountEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDACCOUNT_EVENT));
        return addAccountEventFlowable(filter);
    }

    public List<DelAccountEventResponse> getDelAccountEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELACCOUNT_EVENT, transactionReceipt);
        ArrayList<DelAccountEventResponse> responses = new ArrayList<DelAccountEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DelAccountEventResponse typedResponse = new DelAccountEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelAccountEventResponse> delAccountEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelAccountEventResponse>() {
            @Override
            public DelAccountEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DELACCOUNT_EVENT, log);
                DelAccountEventResponse typedResponse = new DelAccountEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelAccountEventResponse> delAccountEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELACCOUNT_EVENT));
        return delAccountEventFlowable(filter);
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

    public List<UpdateAccountEventResponse> getUpdateAccountEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEACCOUNT_EVENT, transactionReceipt);
        ArrayList<UpdateAccountEventResponse> responses = new ArrayList<UpdateAccountEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UpdateAccountEventResponse typedResponse = new UpdateAccountEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.accountDID = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.accountName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.accountRole = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.leaderDID = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.field = (String) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdateAccountEventResponse> updateAccountEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpdateAccountEventResponse>() {
            @Override
            public UpdateAccountEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEACCOUNT_EVENT, log);
                UpdateAccountEventResponse typedResponse = new UpdateAccountEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.accountDID = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.accountName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.accountRole = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.leaderDID = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.field = (String) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdateAccountEventResponse> updateAccountEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEACCOUNT_EVENT));
        return updateAccountEventFlowable(filter);
    }

    public List<UpdateAccountStateEventResponse> getUpdateAccountStateEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEACCOUNTSTATE_EVENT, transactionReceipt);
        ArrayList<UpdateAccountStateEventResponse> responses = new ArrayList<UpdateAccountStateEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UpdateAccountStateEventResponse typedResponse = new UpdateAccountStateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdateAccountStateEventResponse> updateAccountStateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpdateAccountStateEventResponse>() {
            @Override
            public UpdateAccountStateEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEACCOUNTSTATE_EVENT, log);
                UpdateAccountStateEventResponse typedResponse = new UpdateAccountStateEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.platformState = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.operatorState = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdateAccountStateEventResponse> updateAccountStateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEACCOUNTSTATE_EVENT));
        return updateAccountStateEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> accountAvailable(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ACCOUNTAVAILABLE, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addAccountByPlatform(String account, String accountName, String accountDID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new Address(160, account),
                new Utf8String(accountName),
                new Utf8String(accountDID)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addAccountByOperator(String account, String accountName, String accountDID, String leaderDID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDCONSUMERBYOPERATOR, 
                Arrays.<Type>asList(new Address(160, account),
                new Utf8String(accountName),
                new Utf8String(accountDID),
                new Utf8String(leaderDID)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addFunction(BigInteger role, String contractAddress, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDFUNCTION, 
                Arrays.<Type>asList(new Uint8(role),
                new Address(160, contractAddress),
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addOperator(String operator, String accountName, String accountDID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDOPERATOR, 
                Arrays.<Type>asList(new Address(160, operator),
                new Utf8String(accountName),
                new Utf8String(accountDID)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> assertAccountRole(String account, BigInteger role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ASSERTACCOUNTROLE, 
                Arrays.<Type>asList(new Address(160, account),
                new Uint8(role)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> delFunction(BigInteger role, String contractAddress, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELFUNCTION, 
                Arrays.<Type>asList(new Uint8(role),
                new Address(160, contractAddress),
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String>> getAccount(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETACCOUNT, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String>>(function,
                new Callable<Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> getAuthorityDataContractAddr() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAUTHORITYDATACONTRACTADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getFunction(BigInteger role, String contractAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETFUNCTION, 
                Arrays.<Type>asList(new Uint8(role),
                new Address(160, contractAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes4>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> hasFunctionPermission(String account, String contractAddress, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASFUNCTIONPERMISSION, 
                Arrays.<Type>asList(new Address(160, account),
                new Address(160, contractAddress),
                new Bytes4(sig)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> leaderCheck(String account, String leaderAccount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LEADERCHECK, 
                Arrays.<Type>asList(new Address(160, account),
                new Address(160, leaderAccount)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteFunctionCall<Boolean> sameDIDCheck(String account1, String account2) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SAMEDIDCHECK, 
                Arrays.<Type>asList(new Address(160, account1),
                new Address(160, account2)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> sameLeaderCheck(String account1, String account2) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SAMELEADERCHECK, 
                Arrays.<Type>asList(new Address(160, account1),
                new Address(160, account2)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> samePlatformManagerCheck(String account1, String account2) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SAMEPLATFORMMANAGERCHECK, 
                Arrays.<Type>asList(new Address(160, account1),
                new Address(160, account2)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setAuthorityDataContractAddr(String authorityDataContractAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAUTHORITYDATACONTRACTADDR, 
                Arrays.<Type>asList(new Address(160, authorityDataContractAddr)),
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

    public RemoteFunctionCall<TransactionReceipt> updateAccountState(String account, BigInteger state, Boolean changePlatformState) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEACCOUNTSTATE, 
                Arrays.<Type>asList(new Address(160, account),
                new Uint8(state),
                new Bool(changePlatformState)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AuthorityLogic load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AuthorityLogic(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AuthorityLogic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AuthorityLogic(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AuthorityLogic load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AuthorityLogic(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AuthorityLogic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AuthorityLogic(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AuthorityLogic> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String authorityData) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, authorityData)));
        return deployRemoteCall(AuthorityLogic.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<AuthorityLogic> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String authorityData) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, authorityData)));
        return deployRemoteCall(AuthorityLogic.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AuthorityLogic> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String authorityData) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, authorityData)));
        return deployRemoteCall(AuthorityLogic.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AuthorityLogic> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String authorityData) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, authorityData)));
        return deployRemoteCall(AuthorityLogic.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class AddAccountEventResponse extends BaseEventResponse {
        public String caller;

        public String account;

        public String accountDID;

        public String accountName;

        public BigInteger accountRole;

        public String leaderDID;

        public BigInteger platformState;

        public BigInteger operatorState;

        public String field;
    }

    public static class DelAccountEventResponse extends BaseEventResponse {
        public String account;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class UpdateAccountEventResponse extends BaseEventResponse {
        public String account;

        public String accountDID;

        public String accountName;

        public BigInteger accountRole;

        public String leaderDID;

        public BigInteger platformState;

        public BigInteger operatorState;

        public String field;
    }

    public static class UpdateAccountStateEventResponse extends BaseEventResponse {
        public String account;

        public BigInteger platformState;

        public BigInteger operatorState;
    }
}
