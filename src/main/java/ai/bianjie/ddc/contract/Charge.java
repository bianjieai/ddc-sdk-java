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
public class Charge extends Contract {
    public static final String BINARY = "60a06040523060805234801561001457600080fd5b50600054610100900460ff168061002e575060005460ff16155b6100955760405162461bcd60e51b815260206004820152602e60248201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160448201526d191e481a5b9a5d1a585b1a5e995960921b606482015260840160405180910390fd5b600054610100900460ff161580156100b7576000805461ffff19166101011790555b80156100c9576000805461ff00191690555b506080516120416100fa600039600081816104c3015281816105030152818161058c01526105cc01526120416000f3fe6080604052600436106100fd5760003560e01c8063715018a6116100955780639687519011610064578063968751901461026d578063c5837d821461028d578063c9c45a0f146102ad578063d213fe45146102e2578063f2fde38b1461030257600080fd5b8063715018a6146101fb5780638129fc1c146102105780638a27a80d146102255780638da5cb5b1461024557600080fd5b80633659cfe6116100d15780633659cfe6146101885780634f1ef286146101a857806363569189146101bb57806370a08231146101db57600080fd5b80620b8f7014610102578063093f28e01461012457806318160ddd1461014457806336351c7c14610168575b600080fd5b34801561010e57600080fd5b5061012261011d3660046119bc565b610322565b005b34801561013057600080fd5b5061012261013f3660046119ef565b6103a5565b34801561015057600080fd5b5060c9545b6040519081526020015b60405180910390f35b34801561017457600080fd5b50610122610183366004611a22565b610441565b34801561019457600080fd5b506101226101a33660046119bc565b6104b8565b6101226101b6366004611abb565b610581565b3480156101c757600080fd5b506101226101d6366004611b4c565b61063b565b3480156101e757600080fd5b506101556101f63660046119bc565b6106fb565b34801561020757600080fd5b5061012261073f565b34801561021c57600080fd5b50610122610775565b34801561023157600080fd5b50610122610240366004611a22565b6107f0565b34801561025157600080fd5b506033546040516001600160a01b03909116815260200161015f565b34801561027957600080fd5b506101226102883660046119ef565b6108de565b34801561029957600080fd5b506101226102a83660046119bc565b61098e565b3480156102b957600080fd5b506102cd6102c83660046119ef565b610a30565b60405163ffffffff909116815260200161015f565b3480156102ee57600080fd5b506101226102fd366004611b9c565b610b0d565b34801561030e57600080fd5b5061012261031d3660046119bc565b610b78565b6001600160a01b0381166103515760405162461bcd60e51b815260040161034890611bb5565b60405180910390fd5b610359610c10565b6001600160a01b038116600081815260ca6020526040808220600101805460ff19169055517f0ba05d508af447342f624920545278b6e2d2320ee40cb9eff56b89d21e1b25e89190a250565b6001600160a01b0382166103cb5760405162461bcd60e51b815260040161034890611bb5565b6103d3610c10565b6001600160a01b038216600081815260ca602090815260408083206001600160e01b0319861680855290835292819020805463ffffffff19169055519182527f2f93e067617701594eddb2443d90441c5bb959df555ae8e4d150f0a8bf8b006d910160405180910390a25050565b8061045e5760405162461bcd60e51b815260040161034890611be2565b6104683383610cdd565b610473338383610df7565b6040518181526001600160a01b0383169033907f4ade20d82044693c0d3331ba1d2a482d103734f274166989491c8d30d3f2ecb1906020015b60405180910390a35050565b306001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614156105015760405162461bcd60e51b815260040161034890611c17565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316610533610ee9565b6001600160a01b0316146105595760405162461bcd60e51b815260040161034890611c63565b61056281610f17565b6040805160008082526020820190925261057e91839190610f41565b50565b306001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614156105ca5760405162461bcd60e51b815260040161034890611c17565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166105fc610ee9565b6001600160a01b0316146106225760405162461bcd60e51b815260040161034890611c63565b61062b82610f17565b61063782826001610f41565b5050565b6001600160a01b0383166106615760405162461bcd60e51b815260040161034890611bb5565b610669610c10565b6001600160a01b038316600081815260ca602090815260408083206001808201805460ff191690911790556001600160e01b0319871680855290835292819020805463ffffffff191663ffffffff87169081179091558151938452918301919091527f929dc21675623ba3d42ef9e085962b7d88bf57ba159fe8f0a86d6785195e2acc910160405180910390a2505050565b60006001600160a01b0382166107235760405162461bcd60e51b815260040161034890611bb5565b506001600160a01b0316600090815260cb602052604090205490565b6033546001600160a01b031633146107695760405162461bcd60e51b815260040161034890611caf565b610773600061108c565b565b600054610100900460ff168061078e575060005460ff16155b6107aa5760405162461bcd60e51b815260040161034890611ce4565b600054610100900460ff161580156107cc576000805461ffff19166101011790555b6107d46110de565b6107dc611145565b801561057e576000805461ff001916905550565b8061080d5760405162461bcd60e51b815260040161034890611be2565b6001600160a01b0382163b1515801561084157506001600160a01b038216600090815260ca602052604090206001015460ff165b61088d5760405162461bcd60e51b815260206004820152601860248201527f6368617267653a206e6f742044444320636f6e747261637400000000000000006044820152606401610348565b610895610c10565b6108a182335b83610df7565b6040518181526001600160a01b0383169033907fca2ce982d63c71a419517d389df253be4b0d6f4da85fe1491e49608b139ee0be906020016104ac565b6001600160a01b0382166109045760405162461bcd60e51b815260040161034890611bb5565b3360006109118284610a30565b905063ffffffff8116156109305761093084838363ffffffff16610df7565b604080516001600160e01b03198516815263ffffffff831660208201526001600160a01b0380851692908716917fe5e4f0955699fa27be3f7aeb5a9e4ab78b6a37914fd44e5b08c4b78e56f04aa0910160405180910390a350505050565b6033546001600160a01b031633146109b85760405162461bcd60e51b815260040161034890611caf565b6001600160a01b038116610a0e5760405162461bcd60e51b815260206004820152601d60248201527f6368617267653a206175746820746865207a65726f20616464726573730000006044820152606401610348565b60cc80546001600160a01b0319166001600160a01b0392909216919091179055565b60006001600160a01b038316610a585760405162461bcd60e51b815260040161034890611bb5565b6001600160a01b038316600090815260ca602052604090206001015460ff16610ad15760405162461bcd60e51b815260206004820152602560248201527f6368617267653a6464632070726f787920636f6e747261637420756e617661696044820152646c61626c6560d81b6064820152608401610348565b506001600160a01b038216600090815260ca602090815260408083206001600160e01b03198516845290915290205463ffffffff165b92915050565b80610b2a5760405162461bcd60e51b815260040161034890611be2565b610b32610c10565b610b3d60003361089b565b60405181815233906000907f4ade20d82044693c0d3331ba1d2a482d103734f274166989491c8d30d3f2ecb19060200160405180910390a350565b6033546001600160a01b03163314610ba25760405162461bcd60e51b815260040161034890611caf565b6001600160a01b038116610c075760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b6064820152608401610348565b61057e8161108c565b60cc546001600160a01b031663ed5cad643360006040518363ffffffff1660e01b8152600401610c41929190611d48565b602060405180830381865afa158015610c5e573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610c829190611d83565b6107735760405162461bcd60e51b815260206004820152602660248201527f4444433732313a6e6f742061206f70657261746f7220726f6c65206f722064696044820152651cd8589b195960d21b6064820152608401610348565b6001600160a01b038116610d3f5760405162461bcd60e51b8152602060048201526024808201527f6368617267653a20726563686172676520746f20746865207a65726f206164646044820152637265737360e01b6064820152608401610348565b806001600160a01b0316826001600160a01b03161415610da15760405162461bcd60e51b815260206004820181905260248201527f6368617267653a206e6f207265636861726765206973206e65636573736172796044820152606401610348565b610dab82826111ac565b6106375760405162461bcd60e51b815260206004820152601e60248201527f6368617267653a206e6f207265636861726765207065726d697373696f6e00006044820152606401610348565b6001600160a01b03831615610e9f5780610e10846106fb565b1015610e6c5760405162461bcd60e51b815260206004820152602560248201527f6368617267653a206163636f756e742062616c616e6365206973206e6f7420656044820152640dcdeeaced60db1b6064820152608401610348565b6001600160a01b038316600090815260cb602052604081208054839290610e94908490611dbb565b90915550610eb79050565b8060c96000828254610eb19190611dd2565b90915550505b6001600160a01b038216600090815260cb602052604081208054839290610edf908490611dd2565b9091555050505050565b7f360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc546001600160a01b031690565b6033546001600160a01b0316331461057e5760405162461bcd60e51b815260040161034890611caf565b6000610f4b610ee9565b9050610f568461162e565b600083511180610f635750815b15610f7457610f7284846116d3565b505b7f4910fdfa16fed3260ed0e7147f7cc6da11a60208b5b9406d12a635614ffd9143805460ff1661108557805460ff191660011781556040516001600160a01b0383166024820152610ff390869060440160408051601f198184030181529190526020810180516001600160e01b0316631b2ce7f360e11b1790526116d3565b50805460ff19168155611004610ee9565b6001600160a01b0316826001600160a01b03161461107c5760405162461bcd60e51b815260206004820152602f60248201527f45524331393637557067726164653a207570677261646520627265616b73206660448201526e75727468657220757067726164657360881b6064820152608401610348565b611085856117b5565b5050505050565b603380546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b600054610100900460ff16806110f7575060005460ff16155b6111135760405162461bcd60e51b815260040161034890611ce4565b600054610100900460ff16158015611135576000805461ffff19166101011790555b61113d6117f5565b6107dc61185f565b600054610100900460ff168061115e575060005460ff16155b61117a5760405162461bcd60e51b815260040161034890611ce4565b600054610100900460ff1615801561119c576000805461ffff19166101011790555b6111a46117f5565b6107dc6117f5565b60006111ec6040805160e0810182526060808252602082015290810160008152606060208201526040016000815260200160008152602001606081525090565b60cc5460405163fbcbc0f160e01b81526001600160a01b0386811660048301529091169063fbcbc0f190602401600060405180830381865afa158015611236573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261125e9190810190611e85565b5092935090918560408101606082016080830160a0840185600181111561128757611287611d32565b600181111561129857611298611d32565b90528560018111156112ac576112ac611d32565b60018111156112bd576112bd611d32565b90528590528560028111156112d4576112d4611d32565b60028111156112e5576112e5611d32565b90529490945250600192506112f8915050565b8160800151600181111561130e5761130e611d32565b148015611330575060018160a00151600181111561132e5761132e611d32565b145b61137c5760405162461bcd60e51b815260206004820152601960248201527f6368617267653a206163636f756e742069732066726f7a656e000000000000006044820152606401610348565b6113ba6040805160e0810182526060808252602082015290810160008152606060208201526040016000815260200160008152602001606081525090565b60cc5460405163fbcbc0f160e01b81526001600160a01b0386811660048301529091169063fbcbc0f190602401600060405180830381865afa158015611404573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261142c9190810190611e85565b5092935090918560408101606082016080830160a0840185600181111561145557611455611d32565b600181111561146657611466611d32565b905285600181111561147a5761147a611d32565b600181111561148b5761148b611d32565b90528590528560028111156114a2576114a2611d32565b60028111156114b3576114b3611d32565b90529490945250600192506114c6915050565b816080015160018111156114dc576114dc611d32565b1480156114fe575060018160a0015160018111156114fc576114fc611d32565b145b6115415760405162461bcd60e51b815260206004820152601460248201527331b430b933b29d103a379034b990333937bd32b760611b6044820152606401610348565b60028260400151600281111561155957611559611d32565b14156115a75760405162461bcd60e51b815260206004820152601e60248201527f6368617267653a206e6f207265636861726765207065726d697373696f6e00006044820152606401610348565b6000826040015160028111156115bf576115bf611d32565b14806115d65750606081015182516115d6916118bf565b806116255750606080820151908301516115ef916118bf565b8015611603575080518251611603916118bf565b8015611625575060028160400151600281111561162257611622611d32565b14155b95945050505050565b803b6116925760405162461bcd60e51b815260206004820152602d60248201527f455243313936373a206e657720696d706c656d656e746174696f6e206973206e60448201526c1bdd08184818dbdb9d1c9858dd609a1b6064820152608401610348565b7f360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc80546001600160a01b0319166001600160a01b0392909216919091179055565b6060823b6117325760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b6064820152608401610348565b600080846001600160a01b03168460405161174d9190611f64565b600060405180830381855af49150503d8060008114611788576040519150601f19603f3d011682016040523d82523d6000602084013e61178d565b606091505b50915091506116258282604051806060016040528060278152602001611fe560279139611960565b6117be8161162e565b6040516001600160a01b038216907fbc7cd75a20ee27fd9adebab32041f755214dbc6bffa90cc0225b39da2e5c2d3b90600090a250565b600054610100900460ff168061180e575060005460ff16155b61182a5760405162461bcd60e51b815260040161034890611ce4565b600054610100900460ff161580156107dc576000805461ffff1916610101179055801561057e576000805461ff001916905550565b600054610100900460ff1680611878575060005460ff16155b6118945760405162461bcd60e51b815260040161034890611ce4565b600054610100900460ff161580156118b6576000805461ffff19166101011790555b6107dc3361108c565b8051825160009184918491146118da57600092505050610b07565b815160005b81811015611953578281815181106118f9576118f9611f80565b602001015160f81c60f81b6001600160f81b03191684828151811061192057611920611f80565b01602001516001600160f81b03191614611941576000945050505050610b07565b8061194b81611f96565b9150506118df565b5060019695505050505050565b6060831561196f575081611999565b82511561197f5782518084602001fd5b8160405162461bcd60e51b81526004016103489190611fb1565b9392505050565b80356001600160a01b03811681146119b757600080fd5b919050565b6000602082840312156119ce57600080fd5b611999826119a0565b80356001600160e01b0319811681146119b757600080fd5b60008060408385031215611a0257600080fd5b611a0b836119a0565b9150611a19602084016119d7565b90509250929050565b60008060408385031215611a3557600080fd5b611a3e836119a0565b946020939093013593505050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff81118282101715611a8b57611a8b611a4c565b604052919050565b600067ffffffffffffffff821115611aad57611aad611a4c565b50601f01601f191660200190565b60008060408385031215611ace57600080fd5b611ad7836119a0565b9150602083013567ffffffffffffffff811115611af357600080fd5b8301601f81018513611b0457600080fd5b8035611b17611b1282611a93565b611a62565b818152866020838501011115611b2c57600080fd5b816020840160208301376000602083830101528093505050509250929050565b600080600060608486031215611b6157600080fd5b611b6a846119a0565b9250611b78602085016119d7565b9150604084013563ffffffff81168114611b9157600080fd5b809150509250925092565b600060208284031215611bae57600080fd5b5035919050565b6020808252601390820152726368617267653a7a65726f206164647265737360681b604082015260600190565b6020808252818101527f6368617267653a206e6f207472616e73666572206973206e6563657373617279604082015260600190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b19195b1959d85d1958d85b1b60a21b606082015260800190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b6163746976652070726f787960a01b606082015260800190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b634e487b7160e01b600052602160045260246000fd5b6001600160a01b03831681526040810160038310611d7657634e487b7160e01b600052602160045260246000fd5b8260208301529392505050565b600060208284031215611d9557600080fd5b8151801515811461199957600080fd5b634e487b7160e01b600052601160045260246000fd5b600082821015611dcd57611dcd611da5565b500390565b60008219821115611de557611de5611da5565b500190565b60005b83811015611e05578181015183820152602001611ded565b83811115611e14576000848401525b50505050565b600082601f830112611e2b57600080fd5b8151611e39611b1282611a93565b818152846020838601011115611e4e57600080fd5b611e5f826020830160208701611dea565b949350505050565b8051600381106119b757600080fd5b8051600281106119b757600080fd5b600080600080600080600060e0888a031215611ea057600080fd5b875167ffffffffffffffff80821115611eb857600080fd5b611ec48b838c01611e1a565b985060208a0151915080821115611eda57600080fd5b611ee68b838c01611e1a565b9750611ef460408b01611e67565b965060608a0151915080821115611f0a57600080fd5b611f168b838c01611e1a565b9550611f2460808b01611e76565b9450611f3260a08b01611e76565b935060c08a0151915080821115611f4857600080fd5b50611f558a828b01611e1a565b91505092959891949750929550565b60008251611f76818460208701611dea565b9190910192915050565b634e487b7160e01b600052603260045260246000fd5b6000600019821415611faa57611faa611da5565b5060010190565b6020815260008251806020840152611fd0816040850160208701611dea565b601f01601f1916919091016040019291505056fe416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a2646970667358221220c558ceb1c937b40d945db4878f1b64e16098d5c814623c4ce823c9e34b75fc2364736f6c634300080b0033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DELDDC = "delDDC";

    public static final String FUNC_DELFEE = "delFee";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PAY = "pay";

    public static final String FUNC_QUERYFEE = "queryFee";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SELFRECHARGE = "selfRecharge";

    public static final String FUNC_SETAUTHORITYPROXYADDRESS = "setAuthorityProxyAddress";

    public static final String FUNC_SETFEE = "setFee";

    public static final String FUNC_SETTLEMENT = "settlement";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPGRADETO = "upgradeTo";

    public static final String FUNC_UPGRADETOANDCALL = "upgradeToAndCall";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event BEACONUPGRADED_EVENT = new Event("BeaconUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event DELDDC_EVENT = new Event("DelDDC", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event DELFEE_EVENT = new Event("DelFee", 
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

    public static final Event UPGRADED_EVENT = new Event("Upgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected Charge(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Charge(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Charge(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Charge(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AdminChangedEventResponse> getAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(ADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<AdminChangedEventResponse> responses = new ArrayList<AdminChangedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AdminChangedEventResponse>() {
            @Override
            public AdminChangedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(ADMINCHANGED_EVENT, log);
                AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.previousAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCHANGED_EVENT));
        return adminChangedEventFlowable(filter);
    }

    public List<BeaconUpgradedEventResponse> getBeaconUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(BEACONUPGRADED_EVENT, transactionReceipt);
        ArrayList<BeaconUpgradedEventResponse> responses = new ArrayList<BeaconUpgradedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BeaconUpgradedEventResponse>() {
            @Override
            public BeaconUpgradedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(BEACONUPGRADED_EVENT, log);
                BeaconUpgradedEventResponse typedResponse = new BeaconUpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.beacon = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BeaconUpgradedEventResponse> beaconUpgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BEACONUPGRADED_EVENT));
        return beaconUpgradedEventFlowable(filter);
    }

    public List<DelDDCEventResponse> getDelDDCEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELDDC_EVENT, transactionReceipt);
        ArrayList<DelDDCEventResponse> responses = new ArrayList<DelDDCEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DelDDCEventResponse typedResponse = new DelDDCEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelDDCEventResponse> delDDCEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelDDCEventResponse>() {
            @Override
            public DelDDCEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DELDDC_EVENT, log);
                DelDDCEventResponse typedResponse = new DelDDCEventResponse();
                typedResponse.log = log;
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelDDCEventResponse> delDDCEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELDDC_EVENT));
        return delDDCEventFlowable(filter);
    }

    public List<DelFeeEventResponse> getDelFeeEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(DELFEE_EVENT, transactionReceipt);
        ArrayList<DelFeeEventResponse> responses = new ArrayList<DelFeeEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            DelFeeEventResponse typedResponse = new DelFeeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelFeeEventResponse> delFeeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelFeeEventResponse>() {
            @Override
            public DelFeeEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(DELFEE_EVENT, log);
                DelFeeEventResponse typedResponse = new DelFeeEventResponse();
                typedResponse.log = log;
                typedResponse.ddcAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.sig = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelFeeEventResponse> delFeeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELFEE_EVENT));
        return delFeeEventFlowable(filter);
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
            typedResponse.payer = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.payee = (String) eventValues.getIndexedValues().get(1).getValue();
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
                typedResponse.payer = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.payee = (String) eventValues.getIndexedValues().get(1).getValue();
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
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SettlementEventResponse> settlementEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETTLEMENT_EVENT));
        return settlementEventFlowable(filter);
    }

    public List<UpgradedEventResponse> getUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(UPGRADED_EVENT, transactionReceipt);
        ArrayList<UpgradedEventResponse> responses = new ArrayList<UpgradedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            UpgradedEventResponse typedResponse = new UpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpgradedEventResponse>() {
            @Override
            public UpgradedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(UPGRADED_EVENT, log);
                UpgradedEventResponse typedResponse = new UpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpgradedEventResponse> upgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPGRADED_EVENT));
        return upgradedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String accAddr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, accAddr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
                new Bytes4(sig)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pay(String payer, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAY, 
                Arrays.<Type>asList(new Address(160, payer),
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

    public RemoteFunctionCall<TransactionReceipt> recharge(String to, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECHARGE, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(amount)),
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

    public RemoteFunctionCall<TransactionReceipt> selfRecharge(BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELFRECHARGE, 
                Arrays.<Type>asList(new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setAuthorityProxyAddress(String authorityProxyAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAUTHORITYPROXYADDRESS, 
                Arrays.<Type>asList(new Address(160, authorityProxyAddress)),
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

    public RemoteFunctionCall<TransactionReceipt> settlement(String ddcAddr, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETTLEMENT, 
                Arrays.<Type>asList(new Address(160, ddcAddr),
                new Uint256(amount)),
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

    public RemoteFunctionCall<TransactionReceipt> upgradeTo(String newImplementation) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPGRADETO, 
                Arrays.<Type>asList(new Address(160, newImplementation)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> upgradeToAndCall(String newImplementation, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPGRADETOANDCALL, 
                Arrays.<Type>asList(new Address(160, newImplementation),
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Charge load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Charge(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Charge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Charge(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Charge load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Charge(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Charge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Charge(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Charge> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Charge.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Charge> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Charge.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Charge> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Charge.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Charge> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Charge.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AdminChangedEventResponse extends BaseEventResponse {
        public String previousAdmin;

        public String newAdmin;
    }

    public static class BeaconUpgradedEventResponse extends BaseEventResponse {
        public String beacon;
    }

    public static class DelDDCEventResponse extends BaseEventResponse {
        public String ddcAddr;
    }

    public static class DelFeeEventResponse extends BaseEventResponse {
        public String ddcAddr;

        public byte[] sig;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class PayEventResponse extends BaseEventResponse {
        public String payer;

        public String payee;

        public byte[] sig;

        public BigInteger amount;
    }

    public static class RechargeEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger amount;
    }

    public static class SetFeeEventResponse extends BaseEventResponse {
        public String ddcAddr;

        public byte[] sig;

        public BigInteger amount;
    }

    public static class SettlementEventResponse extends BaseEventResponse {
        public String accAddr;

        public String ddcAddr;

        public BigInteger amount;
    }

    public static class UpgradedEventResponse extends BaseEventResponse {
        public String implementation;
    }
}
