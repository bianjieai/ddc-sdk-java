package ai.bianjie.ddc.contract;

import ai.bianjie.ddc.config.ConfigCache;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes4;
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
public class ChargeLogic extends Contract {
    public static final String BINARY = ConfigCache.get().getChargeLogicBIN();

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DELETEDDC = "deleteDDC";

    public static final String FUNC_DELETEFEE = "deleteFee";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PAY = "pay";

    public static final String FUNC_QUERYFEE = "queryFee";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SELFRECHARGE = "selfRecharge";

    public static final String FUNC_SETAUTH = "setAuth";

    public static final String FUNC_SETFEE = "setFee";

    public static final String FUNC_SETICHARGEDATA = "setiChargeData";

    public static final String FUNC_SETTLEMENT = "settlement";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event DELETEDDC_EVENT = new Event("DeleteDDC", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event DELETEFEE_EVENT = new Event("DeleteFee", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes4>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PAY_EVENT = new Event("Pay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bytes4>() {}, new TypeReference<Uint32>() {}));
    ;

    public static final Event RECHARGE_EVENT = new Event("Recharge", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SETFEE_EVENT = new Event("SetFee", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bytes4>() {}, new TypeReference<Uint32>() {}));
    ;

    public static final Event SETTLEMENT_EVENT = new Event("Settlement", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ChargeLogic(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChargeLogic(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ChargeLogic(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ChargeLogic(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DeleteDDCEventResponse> getDeleteDDCEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELETEDDC_EVENT, transactionReceipt);
        ArrayList<DeleteDDCEventResponse> responses = new ArrayList<DeleteDDCEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DeleteDDCEventResponse typedResponse = new DeleteDDCEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DeleteDDCEventResponse> deleteDDCEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DeleteDDCEventResponse>() {
            @Override
            public DeleteDDCEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEDDC_EVENT, log);
                DeleteDDCEventResponse typedResponse = new DeleteDDCEventResponse();
                typedResponse.log = log;
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DeleteDDCEventResponse> deleteDDCEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEDDC_EVENT));
        return deleteDDCEventFlowable(filter);
    }

    public List<DeleteFeeEventResponse> getDeleteFeeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELETEFEE_EVENT, transactionReceipt);
        ArrayList<DeleteFeeEventResponse> responses = new ArrayList<DeleteFeeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DeleteFeeEventResponse typedResponse = new DeleteFeeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DeleteFeeEventResponse> deleteFeeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DeleteFeeEventResponse>() {
            @Override
            public DeleteFeeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DELETEFEE_EVENT, log);
                DeleteFeeEventResponse typedResponse = new DeleteFeeEventResponse();
                typedResponse.log = log;
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DeleteFeeEventResponse> deleteFeeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELETEFEE_EVENT));
        return deleteFeeEventFlowable(filter);
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

    public List<PayEventResponse> getPayEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(PAY_EVENT, transactionReceipt);
        ArrayList<PayEventResponse> responses = new ArrayList<PayEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            PayEventResponse typedResponse = new PayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PayEventResponse> payEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PayEventResponse>() {
            @Override
            public PayEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(PAY_EVENT, log);
                PayEventResponse typedResponse = new PayEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PayEventResponse> payEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAY_EVENT));
        return payEventFlowable(filter);
    }

    public List<RechargeEventResponse> getRechargeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(RECHARGE_EVENT, transactionReceipt);
        ArrayList<RechargeEventResponse> responses = new ArrayList<RechargeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RechargeEventResponse typedResponse = new RechargeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RechargeEventResponse> rechargeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RechargeEventResponse>() {
            @Override
            public RechargeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(RECHARGE_EVENT, log);
                RechargeEventResponse typedResponse = new RechargeEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RechargeEventResponse> rechargeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECHARGE_EVENT));
        return rechargeEventFlowable(filter);
    }

    public List<SetFeeEventResponse> getSetFeeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SETFEE_EVENT, transactionReceipt);
        ArrayList<SetFeeEventResponse> responses = new ArrayList<SetFeeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SetFeeEventResponse typedResponse = new SetFeeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetFeeEventResponse> setFeeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SetFeeEventResponse>() {
            @Override
            public SetFeeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SETFEE_EVENT, log);
                SetFeeEventResponse typedResponse = new SetFeeEventResponse();
                typedResponse.log = log;
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SetFeeEventResponse> setFeeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETFEE_EVENT));
        return setFeeEventFlowable(filter);
    }

    public List<SettlementEventResponse> getSettlementEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SETTLEMENT_EVENT, transactionReceipt);
        ArrayList<SettlementEventResponse> responses = new ArrayList<SettlementEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SettlementEventResponse typedResponse = new SettlementEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.accAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SettlementEventResponse> settlementEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SettlementEventResponse>() {
            @Override
            public SettlementEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SETTLEMENT_EVENT, log);
                SettlementEventResponse typedResponse = new SettlementEventResponse();
                typedResponse.log = log;
                typedResponse.accAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SettlementEventResponse> settlementEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETTLEMENT_EVENT));
        return settlementEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String accAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, accAddr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteDDC(String ddcAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETEDDC, 
                Arrays.<Type>asList(new Address(160, ddcAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deleteFee(String ddcAddr, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETEFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pay(String from, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAY, 
                Arrays.<Type>asList(new Address(160, from),
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> queryFee(String ddcAddr, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUERYFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new Bytes4(sig)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> recharge(String to, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(160, to),
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

    public RemoteFunctionCall<TransactionReceipt> selfRecharge(BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELFRECHARGE, 
                Arrays.<Type>asList(new Uint256(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setAuth(String authLogic) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAUTH, 
                Arrays.<Type>asList(new Address(160, authLogic)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFee(String ddcAddr, byte[] sig, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETFEE, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new Bytes4(sig),
                new Uint32(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setiChargeData(String chargeData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETICHARGEDATA, 
                Arrays.<Type>asList(new Address(160, chargeData)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> settlement(String ddcAddr, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETTLEMENT, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new Uint256(value)),
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
    public static ChargeLogic load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeLogic(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ChargeLogic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeLogic(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ChargeLogic load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChargeLogic(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChargeLogic load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChargeLogic(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChargeLogic> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String chargeData, String authLogic) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, chargeData),
                new Address(160, authLogic)));
        return deployRemoteCall(ChargeLogic.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ChargeLogic> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String chargeData, String authLogic) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, chargeData),
                new Address(160, authLogic)));
        return deployRemoteCall(ChargeLogic.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ChargeLogic> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String chargeData, String authLogic) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, chargeData),
                new Address(160, authLogic)));
        return deployRemoteCall(ChargeLogic.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ChargeLogic> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String chargeData, String authLogic) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(160, chargeData),
                new Address(160, authLogic)));
        return deployRemoteCall(ChargeLogic.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DeleteDDCEventResponse extends BaseEventResponse {
        public String ddcAddr;
    }

    public static class DeleteFeeEventResponse extends BaseEventResponse {
        public String ddcAddr;

        public byte[] sig;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class PayEventResponse extends BaseEventResponse {
        public String from;

        public String ddcAddr;

        public byte[] sig;

        public BigInteger amount;
    }

    public static class RechargeEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }

    public static class SetFeeEventResponse extends BaseEventResponse {
        public String ddcAddr;

        public byte[] sig;

        public BigInteger amount;
    }

    public static class SettlementEventResponse extends BaseEventResponse {
        public String accAddr;

        public String ddcAddr;

        public BigInteger value;
    }
}
