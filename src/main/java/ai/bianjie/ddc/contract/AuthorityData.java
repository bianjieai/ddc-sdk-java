package ai.bianjie.ddc.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
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
public class AuthorityData extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061001a3361001f565b61006f565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b611d968061007e6000396000f3fe608060405234801561001057600080fd5b50600436106101165760003560e01c8063b8100ab0116100a2578063de6990b911610071578063de6990b91461024c578063f2fde38b1461026c578063f6fda7851461027f578063f881a42514610143578063fbcbc0f11461029f57600080fd5b8063b8100ab014610200578063d12c602c14610213578063d5123d7214610226578063dd9ef97c1461023957600080fd5b8063715018a6116100e9578063715018a6146101955780637da19ad61461019f578063847ab924146101b25780638da5cb5b146101d2578063adbf2e96146101ed57600080fd5b8063041a40101461011b57806326006365146101435780634e880a5d146101565780635dbc20e814610182575b600080fd5b61012e610129366004611639565b6102bf565b60405190151581526020015b60405180910390f35b61012e610151366004611768565b610394565b610169610164366004611887565b6104cd565b6040516001600160e01b0319909116815260200161013a565b61012e6101903660046118ba565b61058e565b61019d61063d565b005b61012e6101ad3660046118dc565b610673565b6101c56101c03660046118dc565b61073d565b60405161013a9190611906565b6000546040516001600160a01b03909116815260200161013a565b61012e6101fb366004611954565b610845565b61019d61020e36600461199a565b610917565b61012e6102213660046119b5565b610a55565b61012e610234366004611a13565b610b21565b61012e61024736600461199a565b610bec565b61025f61025a3660046118ba565b610c89565b60405161013a9190611ab7565b61019d61027a36600461199a565b610dd8565b61029261028d3660046118dc565b610e73565b60405161013a9190611b19565b6102b26102ad36600461199a565b610fac565b60405161013a9190611ba3565b6001546000906001600160a01b031633146102f55760405162461bcd60e51b81526004016102ec90611c67565b60405180910390fd5b816003600086600281111561030c5761030c611b79565b600281111561031d5761031d611b79565b8152602001908152602001600020848154811061033c5761033c611cc4565b600091825260209182902083516002929092020180546001600160a01b0319166001600160a01b03909216919091178155828201518051919261038792600185019290910190611374565b5060019695505050505050565b6001546000906001600160a01b031633146103c15760405162461bcd60e51b81526004016102ec90611c67565b6001600160a01b03831660009081526002602090815260409091208351805185936103f0928492910190611420565b5060208281015180516104099260018501920190611420565b5060408201518160020160006101000a81548160ff0219169083600281111561043457610434611b79565b021790555060608201518051610454916003840191602090910190611420565b50608082015160048201805460ff19166001838181111561047757610477611b79565b021790555060a082015160048201805461ff0019166101008360018111156104a1576104a1611b79565b021790555060c082015180516104c1916005840191602090910190611420565b50600195945050505050565b6001546000906001600160a01b031633146104fa5760405162461bcd60e51b81526004016102ec90611c67565b6003600085600281111561051057610510611b79565b600281111561052157610521611b79565b8152602001908152602001600020838154811061054057610540611cc4565b9060005260206000209060020201600101828154811061056257610562611cc4565b90600052602060002090600891828204019190066004029054906101000a900460e01b90509392505050565b6001546000906001600160a01b031633146105bb5760405162461bcd60e51b81526004016102ec90611c67565b600360008360028111156105d1576105d1611b79565b60028111156105e2576105e2611b79565b81526020019081526020016000208054806105ff576105ff611cda565b60008281526020812060026000199093019283020180546001600160a01b0319168155906106306001830182611494565b505090555060015b919050565b6000546001600160a01b031633146106675760405162461bcd60e51b81526004016102ec90611cf0565b6106716000611324565b565b6001546000906001600160a01b031633146106a05760405162461bcd60e51b81526004016102ec90611c67565b600360008460028111156106b6576106b6611b79565b60028111156106c7576106c7611b79565b815260200190815260200160002082815481106106e6576106e6611cc4565b906000526020600020906002020160010180548061070657610706611cda565b600082815260209020600860001990920191820401805463ffffffff600460078516026101000a0219169055905550600192915050565b6001546060906001600160a01b0316331461076a5760405162461bcd60e51b81526004016102ec90611c67565b6003600084600281111561078057610780611b79565b600281111561079157610791611b79565b815260200190815260200160002082815481106107b0576107b0611cc4565b906000526020600020906002020160010180548060200260200160405190810160405280929190818152602001828054801561083857602002820191906000526020600020906000905b82829054906101000a900460e01b6001600160e01b031916815260200190600401906020826003010492830192600103820291508084116107fa5790505b5050505050905092915050565b6001546000906001600160a01b031633146108725760405162461bcd60e51b81526004016102ec90611c67565b816003600087600281111561088957610889611b79565b600281111561089a5761089a611b79565b815260200190815260200160002085815481106108b9576108b9611cc4565b906000526020600020906002020160010184815481106108db576108db611cc4565b90600052602060002090600891828204019190066004026101000a81548163ffffffff021916908360e01c021790555060019050949350505050565b6000546001600160a01b031633146109415760405162461bcd60e51b81526004016102ec90611cf0565b6001600160a01b0381166109bf576040805162461bcd60e51b81526020600482015260248101919091527f417574686f72697479446174613a20617574686f726974794c6f676963436f6e60448201527f7472616374416464722063616e6e6f74206265207a65726f206164647265737360648201526084016102ec565b803b610a335760405162461bcd60e51b815260206004820152603b60248201527f417574686f72697479446174613a20617574686f726974794c6f676963436f6e60448201527f747261637441646472206973206e6f74206120636f6e7472616374000000000060648201526084016102ec565b600180546001600160a01b0319166001600160a01b0392909216919091179055565b6001546000906001600160a01b03163314610a825760405162461bcd60e51b81526004016102ec90611c67565b60036000856002811115610a9857610a98611b79565b6002811115610aa957610aa9611b79565b81526020808201929092526040908101600090812082518084019093526001600160a01b03878116845283850187815282546001808201855593855293869020855160029095020180546001600160a01b03191694909216939093178155915180519394929361038793928501929190910190611374565b6001546000906001600160a01b03163314610b4e5760405162461bcd60e51b81526004016102ec90611c67565b60036000856002811115610b6457610b64611b79565b6002811115610b7557610b75611b79565b81526020019081526020016000208381548110610b9457610b94611cc4565b60009182526020808320600160029093020182018054808401825590845292206008830401805460e086901c60046007909516949094026101000a93840263ffffffff90940219169290921790915590509392505050565b6001546000906001600160a01b03163314610c195760405162461bcd60e51b81526004016102ec90611c67565b6001600160a01b038216600090815260026020526040812090610c3c82826114b9565b610c4a6001830160006114b9565b60028201805460ff19169055610c646003830160006114b9565b60048201805461ffff19169055610c7f6005830160006114b9565b5060019392505050565b6001546060906001600160a01b03163314610cb65760405162461bcd60e51b81526004016102ec90611c67565b60036000836002811115610ccc57610ccc611b79565b6002811115610cdd57610cdd611b79565b8152602001908152602001600020805480602002602001604051908101604052809291908181526020016000905b82821015610dcd5760008481526020908190206040805180820182526002860290920180546001600160a01b03168352600181018054835181870281018701909452808452939491938583019392830182828015610db557602002820191906000526020600020906000905b82829054906101000a900460e01b6001600160e01b03191681526020019060040190602082600301049283019260010382029150808411610d775790505b50505050508152505081526020019060010190610d0b565b505050509050919050565b6000546001600160a01b03163314610e025760405162461bcd60e51b81526004016102ec90611cf0565b6001600160a01b038116610e675760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084016102ec565b610e7081611324565b50565b6040805180820190915260008152606060208201526001546001600160a01b03163314610eb25760405162461bcd60e51b81526004016102ec90611c67565b60036000846002811115610ec857610ec8611b79565b6002811115610ed957610ed9611b79565b81526020019081526020016000208281548110610ef857610ef8611cc4565b6000918252602091829020604080518082018252600290930290910180546001600160a01b03168352600181018054835181870281018701909452808452939491938583019392830182828015610f9b57602002820191906000526020600020906000905b82829054906101000a900460e01b6001600160e01b03191681526020019060040190602082600301049283019260010382029150808411610f5d5790505b505050505081525050905092915050565b610fea6040805160e0810182526060808252602082015290810160008152606060208201526040016000815260200160008152602001606081525090565b6001546001600160a01b031633146110145760405162461bcd60e51b81526004016102ec90611c67565b6001600160a01b03821660009081526002602052604090819020815160e0810190925280548290829061104690611d25565b80601f016020809104026020016040519081016040528092919081815260200182805461107290611d25565b80156110bf5780601f10611094576101008083540402835291602001916110bf565b820191906000526020600020905b8154815290600101906020018083116110a257829003601f168201915b505050505081526020016001820180546110d890611d25565b80601f016020809104026020016040519081016040528092919081815260200182805461110490611d25565b80156111515780601f1061112657610100808354040283529160200191611151565b820191906000526020600020905b81548152906001019060200180831161113457829003601f168201915b505050918352505060028281015460209092019160ff169081111561117857611178611b79565b600281111561118957611189611b79565b815260200160038201805461119d90611d25565b80601f01602080910402602001604051908101604052809291908181526020018280546111c990611d25565b80156112165780601f106111eb57610100808354040283529160200191611216565b820191906000526020600020905b8154815290600101906020018083116111f957829003601f168201915b5050509183525050600482015460209091019060ff16600181111561123d5761123d611b79565b600181111561124e5761124e611b79565b81526020016004820160019054906101000a900460ff16600181111561127657611276611b79565b600181111561128757611287611b79565b815260200160058201805461129b90611d25565b80601f01602080910402602001604051908101604052809291908181526020018280546112c790611d25565b80156113145780601f106112e957610100808354040283529160200191611314565b820191906000526020600020905b8154815290600101906020018083116112f757829003601f168201915b5050505050815250509050919050565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b828054828255906000526020600020906007016008900481019282156114105791602002820160005b838211156113de57835183826101000a81548163ffffffff021916908360e01c0217905550926020019260040160208160030104928301926001030261139d565b801561140e5782816101000a81549063ffffffff02191690556004016020816003010492830192600103026113de565b505b5061141c9291506114ef565b5090565b82805461142c90611d25565b90600052602060002090601f01602090048101928261144e5760008555611410565b82601f1061146757805160ff1916838001178555611410565b82800160010185558215611410579182015b82811115611410578251825591602001919060010190611479565b508054600082556007016008900490600052602060002090810190610e7091906114ef565b5080546114c590611d25565b6000825580601f106114d5575050565b601f016020900490600052602060002090810190610e7091905b5b8082111561141c57600081556001016114f0565b80356003811061063857600080fd5b634e487b7160e01b600052604160045260246000fd5b60405160e0810167ffffffffffffffff8111828210171561154c5761154c611513565b60405290565b604051601f8201601f1916810167ffffffffffffffff8111828210171561157b5761157b611513565b604052919050565b80356001600160a01b038116811461063857600080fd5b80356001600160e01b03198116811461063857600080fd5b600082601f8301126115c357600080fd5b8135602067ffffffffffffffff8211156115df576115df611513565b8160051b6115ee828201611552565b928352848101820192828101908785111561160857600080fd5b83870192505b8483101561162e5761161f8361159a565b8252918301919083019061160e565b979650505050505050565b60008060006060848603121561164e57600080fd5b61165784611504565b925060208401359150604084013567ffffffffffffffff8082111561167b57600080fd5b908501906040828803121561168f57600080fd5b6040516040810181811083821117156116aa576116aa611513565b6040526116b683611583565b81526020830135828111156116ca57600080fd5b6116d6898286016115b2565b6020830152508093505050509250925092565b600082601f8301126116fa57600080fd5b813567ffffffffffffffff81111561171457611714611513565b611727601f8201601f1916602001611552565b81815284602083860101111561173c57600080fd5b816020850160208301376000918101602001919091529392505050565b80356002811061063857600080fd5b6000806040838503121561177b57600080fd5b61178483611583565b9150602083013567ffffffffffffffff808211156117a157600080fd5b9084019060e082870312156117b557600080fd5b6117bd611529565b8235828111156117cc57600080fd5b6117d8888286016116e9565b8252506020830135828111156117ed57600080fd5b6117f9888286016116e9565b60208301525061180b60408401611504565b604082015260608301358281111561182257600080fd5b61182e888286016116e9565b60608301525061184060808401611759565b608082015261185160a08401611759565b60a082015260c08301358281111561186857600080fd5b611874888286016116e9565b60c0830152508093505050509250929050565b60008060006060848603121561189c57600080fd5b6118a584611504565b95602085013595506040909401359392505050565b6000602082840312156118cc57600080fd5b6118d582611504565b9392505050565b600080604083850312156118ef57600080fd5b6118f883611504565b946020939093013593505050565b6020808252825182820181905260009190848201906040850190845b818110156119485783516001600160e01b03191683529284019291840191600101611922565b50909695505050505050565b6000806000806080858703121561196a57600080fd5b61197385611504565b9350602085013592506040850135915061198f6060860161159a565b905092959194509250565b6000602082840312156119ac57600080fd5b6118d582611583565b6000806000606084860312156119ca57600080fd5b6119d384611504565b92506119e160208501611583565b9150604084013567ffffffffffffffff8111156119fd57600080fd5b611a09868287016115b2565b9150509250925092565b600080600060608486031215611a2857600080fd5b611a3184611504565b925060208401359150611a466040850161159a565b90509250925092565b80516001600160a01b03168252602080820151604082850181905281519085018190526000929182019190839060608701905b80831015611aac5784516001600160e01b0319168252938301936001929092019190830190611a82565b509695505050505050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b82811015611b0c57603f19888603018452611afa858351611a4f565b94509285019290850190600101611ade565b5092979650505050505050565b6020815260006118d56020830184611a4f565b6000815180845260005b81811015611b5257602081850181015186830182015201611b36565b81811115611b64576000602083870101525b50601f01601f19169290920160200192915050565b634e487b7160e01b600052602160045260246000fd5b60028110611b9f57611b9f611b79565b9052565b602081526000825160e06020840152611bc0610100840182611b2c565b90506020840151601f1980858403016040860152611bde8383611b2c565b92506040860151915060038210611bf757611bf7611b79565b8160608601526060860151915080858403016080860152611c188383611b2c565b925060808601519150611c2e60a0860183611b8f565b60a08601519150611c4260c0860183611b8f565b60c08601519150808584030160e086015250611c5e8282611b2c565b95945050505050565b60208082526037908201527f417574686f72697479446174613a2063616c6c6572206973206e6f742074686560408201527f20617574686f726974794c6f676963436f6e7472616374000000000000000000606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fd5b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b600181811c90821680611d3957607f821691505b60208210811415611d5a57634e487b7160e01b600052602260045260246000fd5b5091905056fea26469706673582212207728234a8a0a981c47c82cbed097be4384bab08c4b0168a4d87f23627ba0d7df64736f6c634300080b0033";

    public static final String FUNC_ADDACCOUNT = "addAccount";

    public static final String FUNC_DELACCOUNT = "delAccount";

    public static final String FUNC_GETACCOUNT = "getAccount";

    public static final String FUNC_GETFUNACL = "getFunAcl";

    public static final String FUNC_GETFUNACLS = "getFunAcls";

    public static final String FUNC_GETSIG = "getSig";

    public static final String FUNC_GETSIGS = "getSigs";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_POPFULACL = "popFulAcl";

    public static final String FUNC_POPSIG = "popSig";

    public static final String FUNC_PUSHFULACL = "pushFulAcl";

    public static final String FUNC_PUSHSIG = "pushSig";

    public static final String FUNC_PUTSIG = "putSig";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SETAUTHORITYLOGICCONTRACTADDR = "setAuthorityLogicContractAddr";

    public static final String FUNC_SETFULACL = "setFulAcl";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPDATEACCOUNT = "updateAccount";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected AuthorityData(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AuthorityData(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AuthorityData(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AuthorityData(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> addAccount(String account, AccountInfo accountInfo) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new Address(160, account),
                accountInfo), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> delAccount(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELACCOUNT, 
                Arrays.<Type>asList(new Address(160, account)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<AccountInfo> getAccount(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETACCOUNT, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<AccountInfo>() {}));
        return executeRemoteCallSingleValueReturn(function, AccountInfo.class);
    }

    public RemoteFunctionCall<FunAcl> getFunAcl(BigInteger role, BigInteger i) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETFUNACL, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<FunAcl>() {}));
        return executeRemoteCallSingleValueReturn(function, FunAcl.class);
    }

    public RemoteFunctionCall<List> getFunAcls(BigInteger role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETFUNACLS, 
                Arrays.<Type>asList(new Uint8(role)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<FunAcl>>() {}));
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

    public RemoteFunctionCall<byte[]> getSig(BigInteger role, BigInteger i, BigInteger j) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSIG, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i), 
                new org.web3j.abi.datatypes.generated.Uint256(j)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<List> getSigs(BigInteger role, BigInteger i) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSIGS, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i)), 
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

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> popFulAcl(BigInteger role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_POPFULACL, 
                Arrays.<Type>asList(new Uint8(role)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> popSig(BigInteger role, BigInteger i) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_POPSIG, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> pushFulAcl(BigInteger role, String contractAddress, List<byte[]> sigs) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHFULACL, 
                Arrays.<Type>asList(new Uint8(role),
                new Address(160, contractAddress),
                new DynamicArray<Bytes4>(
                        Bytes4.class,
                        org.web3j.abi.Utils.typeMap(sigs, Bytes4.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> pushSig(BigInteger role, BigInteger i, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHSIG, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i), 
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> putSig(BigInteger role, BigInteger i, BigInteger j, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUTSIG, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i), 
                new org.web3j.abi.datatypes.generated.Uint256(j), 
                new Bytes4(sig)),
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

    public RemoteFunctionCall<TransactionReceipt> setAuthorityLogicContractAddr(String authorityLogicContractAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAUTHORITYLOGICCONTRACTADDR, 
                Arrays.<Type>asList(new Address(160, authorityLogicContractAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFulAcl(BigInteger role, BigInteger i, FunAcl funAcl) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETFULACL, 
                Arrays.<Type>asList(new Uint8(role),
                new org.web3j.abi.datatypes.generated.Uint256(i), 
                funAcl), 
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

    public RemoteFunctionCall<TransactionReceipt> updateAccount(String account, AccountInfo accountInfo) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEACCOUNT, 
                Arrays.<Type>asList(new Address(160, account),
                accountInfo), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AuthorityData load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AuthorityData(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AuthorityData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AuthorityData(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AuthorityData load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AuthorityData(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AuthorityData load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AuthorityData(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AuthorityData> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AuthorityData.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AuthorityData> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AuthorityData.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AuthorityData> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AuthorityData.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AuthorityData> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AuthorityData.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AccountInfo extends DynamicStruct {
        public String accountDID;

        public String accountName;

        public BigInteger accountRole;

        public String leaderDID;

        public BigInteger platformState;

        public BigInteger operatorState;

        public String field;

        public AccountInfo(String accountDID, String accountName, BigInteger accountRole, String leaderDID, BigInteger platformState, BigInteger operatorState, String field) {
            super(new Utf8String(accountDID),new Utf8String(accountName),new Uint8(accountRole),new Utf8String(leaderDID),new Uint8(platformState),new Uint8(operatorState),new Utf8String(field));
            this.accountDID = accountDID;
            this.accountName = accountName;
            this.accountRole = accountRole;
            this.leaderDID = leaderDID;
            this.platformState = platformState;
            this.operatorState = operatorState;
            this.field = field;
        }

        public AccountInfo(Utf8String accountDID, Utf8String accountName, Uint8 accountRole, Utf8String leaderDID, Uint8 platformState, Uint8 operatorState, Utf8String field) {
            super(accountDID,accountName,accountRole,leaderDID,platformState,operatorState,field);
            this.accountDID = accountDID.getValue();
            this.accountName = accountName.getValue();
            this.accountRole = accountRole.getValue();
            this.leaderDID = leaderDID.getValue();
            this.platformState = platformState.getValue();
            this.operatorState = operatorState.getValue();
            this.field = field.getValue();
        }
    }

    public static class FunAcl extends DynamicStruct {
        public String contractAddress;

        public List<Bytes4> funList;

        public FunAcl(String contractAddress, List<Bytes4> funList) {
            super(new Address(contractAddress),new DynamicArray<Bytes4>((Bytes4) funList));
            this.contractAddress = contractAddress;
            this.funList = funList;
        }

        public FunAcl(Address contractAddress, DynamicArray<Bytes4> funList) {
            super(contractAddress,funList);
            this.contractAddress = contractAddress.getValue();
            this.funList = funList.getValue();
        }
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
