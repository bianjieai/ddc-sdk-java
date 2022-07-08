package ai.bianjie.ddc.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

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
    public static final String BINARY = "60a06040523060805234801561001457600080fd5b50600054610100900460ff168061002e575060005460ff16155b6100955760405162461bcd60e51b815260206004820152602e60248201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160448201526d191e481a5b9a5d1a585b1a5e995960921b606482015260840160405180910390fd5b600054610100900460ff161580156100b7576000805461ffff19166101011790555b80156100c9576000805461ff00191690555b50608051612585620000fb60003960008181610509015281816105490152818161067f01526106bf01526125856000f3fe6080604052600436106101135760003560e01c8063715018a6116100a0578063c9c45a0f11610064578063c9c45a0f146102d0578063d213fe4514610305578063ef18e3c914610325578063f1e8b16814610345578063f2fde38b1461036557600080fd5b8063715018a61461023e5780638129fc1c146102535780638a27a80d146102685780638da5cb5b14610288578063c5837d82146102b057600080fd5b80633659cfe6116100e75780633659cfe61461019e578063458c738e146101be5780634f1ef286146101eb57806363569189146101fe57806370a082311461021e57600080fd5b80620b8f7014610118578063093f28e01461013a57806318160ddd1461015a57806336351c7c1461017e575b600080fd5b34801561012457600080fd5b50610138610133366004611cf7565b610385565b005b34801561014657600080fd5b50610138610155366004611d2a565b610408565b34801561016657600080fd5b5060c9545b6040519081526020015b60405180910390f35b34801561018a57600080fd5b50610138610199366004611d5d565b6104a4565b3480156101aa57600080fd5b506101386101b9366004611cf7565b6104ff565b3480156101ca57600080fd5b506101de6101d9366004611e64565b6105c7565b6040516101759190611ea1565b6101386101f9366004611f0d565b610675565b34801561020a57600080fd5b50610138610219366004611f99565b61072e565b34801561022a57600080fd5b5061016b610239366004611cf7565b6107ee565b34801561024a57600080fd5b50610138610834565b34801561025f57600080fd5b5061013861086a565b34801561027457600080fd5b50610138610283366004611d5d565b6108e5565b34801561029457600080fd5b506033546040516001600160a01b039091168152602001610175565b3480156102bc57600080fd5b506101386102cb366004611cf7565b610a06565b3480156102dc57600080fd5b506102f06102eb366004611d2a565b610aab565b60405163ffffffff9091168152602001610175565b34801561031157600080fd5b50610138610320366004611fe9565b610b8a565b34801561033157600080fd5b50610138610340366004612002565b610c28565b34801561035157600080fd5b5061013861036036600461203e565b610d28565b34801561037157600080fd5b50610138610380366004611cf7565b610e60565b6001600160a01b0381166103b45760405162461bcd60e51b81526004016103ab906120f9565b60405180910390fd5b6103bc610ef8565b6001600160a01b038116600081815260ca6020526040808220600101805460ff19169055517f0ba05d508af447342f624920545278b6e2d2320ee40cb9eff56b89d21e1b25e89190a250565b6001600160a01b03821661042e5760405162461bcd60e51b81526004016103ab906120f9565b610436610ef8565b6001600160a01b038216600081815260ca602090815260408083206001600160e01b0319861680855290835292819020805463ffffffff19169055519182527f2f93e067617701594eddb2443d90441c5bb959df555ae8e4d150f0a8bf8b006d910160405180910390a25050565b6104af338383610fc5565b6104ba338383611131565b6040518181526001600160a01b0383169033907f4ade20d82044693c0d3331ba1d2a482d103734f274166989491c8d30d3f2ecb1906020015b60405180910390a35050565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001630036105475760405162461bcd60e51b81526004016103ab90612126565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316610579611223565b6001600160a01b03161461059f5760405162461bcd60e51b81526004016103ab90612172565b6105a881611251565b604080516000808252602082019092526105c49183919061127b565b50565b60606000825167ffffffffffffffff8111156105e5576105e5611d87565b60405190808252806020026020018201604052801561060e578160200160208202803683370190505b50905060005b835181101561066e5761063f848281518110610632576106326121be565b60200260200101516107ee565b828281518110610651576106516121be565b602090810291909101015280610666816121ea565b915050610614565b5092915050565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001630036106bd5760405162461bcd60e51b81526004016103ab90612126565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166106ef611223565b6001600160a01b0316146107155760405162461bcd60e51b81526004016103ab90612172565b61071e82611251565b61072a8282600161127b565b5050565b6001600160a01b0383166107545760405162461bcd60e51b81526004016103ab906120f9565b61075c610ef8565b6001600160a01b038316600081815260ca602090815260408083206001808201805460ff191690911790556001600160e01b0319871680855290835292819020805463ffffffff191663ffffffff87169081179091558151938452918301919091527f929dc21675623ba3d42ef9e085962b7d88bf57ba159fe8f0a86d6785195e2acc910160405180910390a2505050565b60006001600160a01b03821681036108185760405162461bcd60e51b81526004016103ab906120f9565b506001600160a01b0316600090815260cb602052604090205490565b6033546001600160a01b0316331461085e5760405162461bcd60e51b81526004016103ab90612203565b61086860006113c6565b565b600054610100900460ff1680610883575060005460ff16155b61089f5760405162461bcd60e51b81526004016103ab90612238565b600054610100900460ff161580156108c1576000805461ffff19166101011790555b6108c9611418565b6108d161147f565b80156105c4576000805461ff001916905550565b806000036109355760405162461bcd60e51b815260206004820181905260248201527f6368617267653a206e6f207472616e73666572206973206e656365737361727960448201526064016103ab565b6001600160a01b0382163b1515801561096957506001600160a01b038216600090815260ca602052604090206001015460ff165b6109b55760405162461bcd60e51b815260206004820152601860248201527f6368617267653a206e6f742044444320636f6e7472616374000000000000000060448201526064016103ab565b6109bd610ef8565b6109c982335b83611131565b6040518181526001600160a01b0383169033907fca2ce982d63c71a419517d389df253be4b0d6f4da85fe1491e49608b139ee0be906020016104f3565b6033546001600160a01b03163314610a305760405162461bcd60e51b81526004016103ab90612203565b6001600160a01b038116600003610a895760405162461bcd60e51b815260206004820152601d60248201527f6368617267653a206175746820746865207a65726f206164647265737300000060448201526064016103ab565b60cc80546001600160a01b0319166001600160a01b0392909216919091179055565b60006001600160a01b0383168103610ad55760405162461bcd60e51b81526004016103ab906120f9565b6001600160a01b038316600090815260ca602052604090206001015460ff16610b4e5760405162461bcd60e51b815260206004820152602560248201527f6368617267653a6464632070726f787920636f6e747261637420756e617661696044820152646c61626c6560d81b60648201526084016103ab565b506001600160a01b038216600090815260ca602090815260408083206001600160e01b03198516845290915290205463ffffffff165b92915050565b80600003610bda5760405162461bcd60e51b815260206004820181905260248201527f6368617267653a206e6f207472616e73666572206973206e656365737361727960448201526064016103ab565b610be2610ef8565b610bed6000336109c3565b60405181815233906000907f4ade20d82044693c0d3331ba1d2a482d103734f274166989491c8d30d3f2ecb19060200160405180910390a350565b6001600160a01b038316610c4e5760405162461bcd60e51b81526004016103ab906120f9565b80600003610c955760405162461bcd60e51b815260206004820152601460248201527318da185c99d94e9a5b9d985b1a5908191918d25960621b60448201526064016103ab565b336000610ca28285610aab565b905063ffffffff811615610cc157610cc185838363ffffffff16611131565b604080516001600160e01b03198616815263ffffffff831660208201529081018490526001600160a01b0380841691908716907f750e56f33a72767cd99db8943f4d04ca416c55fb783003107a869f5d5062dbab9060600160405180910390a35050505050565b8051825114610d725760405162461bcd60e51b81526020600482015260166024820152750c6d0c2e4ceca74d8cadccee8d040dad2e6dac2e8c6d60531b60448201526064016103ab565b60005b8251811015610e0a57610dbb33848381518110610d9457610d946121be565b6020026020010151848481518110610dae57610dae6121be565b6020026020010151610fc5565b610df833848381518110610dd157610dd16121be565b6020026020010151848481518110610deb57610deb6121be565b6020026020010151611131565b80610e02816121ea565b915050610d75565b5081604051610e199190612286565b6040518091039020610e283390565b6001600160a01b03167f744c96b20cd1add6104a750930b0e49658e6c5542ed4e9c9a90ae33359ceb8f9836040516104f39190611ea1565b6033546001600160a01b03163314610e8a5760405162461bcd60e51b81526004016103ab90612203565b6001600160a01b038116610eef5760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084016103ab565b6105c4816113c6565b60cc546001600160a01b031663ed5cad643360006040518363ffffffff1660e01b8152600401610f299291906122db565b602060405180830381865afa158015610f46573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610f6a9190612316565b6108685760405162461bcd60e51b815260206004820152602660248201527f4444433732313a6e6f742061206f70657261746f7220726f6c65206f722064696044820152651cd8589b195960d21b60648201526084016103ab565b6001600160a01b0382166110125760405162461bcd60e51b81526020600482015260146024820152736368617267653a207a65726f206164647265737360601b60448201526064016103ab565b816001600160a01b0316836001600160a01b03160361107e5760405162461bcd60e51b815260206004820152602260248201527f6368617267653a20696e76616c6964207265636861726765206f70657261746960448201526137b760f11b60648201526084016103ab565b806000036110c75760405162461bcd60e51b815260206004820152601660248201527518da185c99d94e881a5b9d985b1a5908185b5bdd5b9d60521b60448201526064016103ab565b6110d183836114e6565b61112c5760405162461bcd60e51b815260206004820152602660248201527f6368617267653a20756e737570706f72746564207265636861726765206f70656044820152653930ba34b7b760d11b60648201526084016103ab565b505050565b6001600160a01b038316156111d9578061114a846107ee565b10156111a65760405162461bcd60e51b815260206004820152602560248201527f6368617267653a206163636f756e742062616c616e6365206973206e6f7420656044820152640dcdeeaced60db1b60648201526084016103ab565b6001600160a01b038316600090815260cb6020526040812080548392906111ce908490612338565b909155506111f19050565b8060c960008282546111eb919061234f565b90915550505b6001600160a01b038216600090815260cb60205260408120805483929061121990849061234f565b9091555050505050565b7f360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc546001600160a01b031690565b6033546001600160a01b031633146105c45760405162461bcd60e51b81526004016103ab90612203565b6000611285611223565b905061129084611969565b60008351118061129d5750815b156112ae576112ac8484611a0e565b505b7f4910fdfa16fed3260ed0e7147f7cc6da11a60208b5b9406d12a635614ffd9143805460ff166113bf57805460ff191660011781556040516001600160a01b038316602482015261132d90869060440160408051601f198184030181529190526020810180516001600160e01b0316631b2ce7f360e11b179052611a0e565b50805460ff1916815561133e611223565b6001600160a01b0316826001600160a01b0316146113b65760405162461bcd60e51b815260206004820152602f60248201527f45524331393637557067726164653a207570677261646520627265616b73206660448201526e75727468657220757067726164657360881b60648201526084016103ab565b6113bf85611af0565b5050505050565b603380546001600160a01b038381166001600160a01b0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b600054610100900460ff1680611431575060005460ff16155b61144d5760405162461bcd60e51b81526004016103ab90612238565b600054610100900460ff1615801561146f576000805461ffff19166101011790555b611477611b30565b6108d1611b9a565b600054610100900460ff1680611498575060005460ff16155b6114b45760405162461bcd60e51b81526004016103ab90612238565b600054610100900460ff161580156114d6576000805461ffff19166101011790555b6114de611b30565b6108d1611b30565b60006115266040805160e0810182526060808252602082015290810160008152606060208201526040016000815260200160008152602001606081525090565b60cc5460405163fbcbc0f160e01b81526001600160a01b0386811660048301529091169063fbcbc0f190602401600060405180830381865afa158015611570573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261159891908101906123fa565b5092935090918560408101606082016080830160a084018560018111156115c1576115c16122c5565b60018111156115d2576115d26122c5565b90528560018111156115e6576115e66122c5565b60018111156115f7576115f76122c5565b905285905285600281111561160e5761160e6122c5565b600281111561161f5761161f6122c5565b9052949094525060019250611632915050565b81608001516001811115611648576116486122c5565b14801561166a575060018160a001516001811115611668576116686122c5565b145b6116b65760405162461bcd60e51b815260206004820152601860248201527f6368617267653a206066726f6d602069732066726f7a656e000000000000000060448201526064016103ab565b6002816040015160028111156116ce576116ce6122c5565b0361171b5760405162461bcd60e51b815260206004820152601e60248201527f6368617267653a206e6f207265636861726765207065726d697373696f6e000060448201526064016103ab565b6117596040805160e0810182526060808252602082015290810160008152606060208201526040016000815260200160008152602001606081525090565b60cc5460405163fbcbc0f160e01b81526001600160a01b0386811660048301529091169063fbcbc0f190602401600060405180830381865afa1580156117a3573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526117cb91908101906123fa565b5092935090918560408101606082016080830160a084018560018111156117f4576117f46122c5565b6001811115611805576118056122c5565b9052856001811115611819576118196122c5565b600181111561182a5761182a6122c5565b9052859052856002811115611841576118416122c5565b6002811115611852576118526122c5565b9052949094525060019250611865915050565b8160800151600181111561187b5761187b6122c5565b14801561189d575060018160a00151600181111561189b5761189b6122c5565b145b6118e25760405162461bcd60e51b815260206004820152601660248201527531b430b933b29d10303a37b01034b990333937bd32b760511b60448201526064016103ab565b6000826040015160028111156118fa576118fa6122c5565b148061191157506060810151825161191191611bfa565b8061196057506060808201519083015161192a91611bfa565b801561193e57508051825161193e91611bfa565b8015611960575060028160400151600281111561195d5761195d6122c5565b14155b95945050505050565b803b6119cd5760405162461bcd60e51b815260206004820152602d60248201527f455243313936373a206e657720696d706c656d656e746174696f6e206973206e60448201526c1bdd08184818dbdb9d1c9858dd609a1b60648201526084016103ab565b7f360894a13ba1a3210667c828492db98dca3e2076cc3735a920a3ca505d382bbc80546001600160a01b0319166001600160a01b0392909216919091179055565b6060823b611a6d5760405162461bcd60e51b815260206004820152602660248201527f416464726573733a2064656c65676174652063616c6c20746f206e6f6e2d636f6044820152651b9d1c9858dd60d21b60648201526084016103ab565b600080846001600160a01b031684604051611a8891906124d9565b600060405180830381855af49150503d8060008114611ac3576040519150601f19603f3d011682016040523d82523d6000602084013e611ac8565b606091505b5091509150611960828260405180606001604052806027815260200161252960279139611c9b565b611af981611969565b6040516001600160a01b038216907fbc7cd75a20ee27fd9adebab32041f755214dbc6bffa90cc0225b39da2e5c2d3b90600090a250565b600054610100900460ff1680611b49575060005460ff16155b611b655760405162461bcd60e51b81526004016103ab90612238565b600054610100900460ff161580156108d1576000805461ffff191661010117905580156105c4576000805461ff001916905550565b600054610100900460ff1680611bb3575060005460ff16155b611bcf5760405162461bcd60e51b81526004016103ab90612238565b600054610100900460ff16158015611bf1576000805461ffff19166101011790555b6108d1336113c6565b805182516000918491849114611c1557600092505050610b84565b815160005b81811015611c8e57828181518110611c3457611c346121be565b602001015160f81c60f81b6001600160f81b031916848281518110611c5b57611c5b6121be565b01602001516001600160f81b03191614611c7c576000945050505050610b84565b80611c86816121ea565b915050611c1a565b5060019695505050505050565b60608315611caa575081611cd4565b825115611cba5782518084602001fd5b8160405162461bcd60e51b81526004016103ab91906124f5565b9392505050565b80356001600160a01b0381168114611cf257600080fd5b919050565b600060208284031215611d0957600080fd5b611cd482611cdb565b80356001600160e01b031981168114611cf257600080fd5b60008060408385031215611d3d57600080fd5b611d4683611cdb565b9150611d5460208401611d12565b90509250929050565b60008060408385031215611d7057600080fd5b611d7983611cdb565b946020939093013593505050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff81118282101715611dc657611dc6611d87565b604052919050565b600067ffffffffffffffff821115611de857611de8611d87565b5060051b60200190565b600082601f830112611e0357600080fd5b81356020611e18611e1383611dce565b611d9d565b82815260059290921b84018101918181019086841115611e3757600080fd5b8286015b84811015611e5957611e4c81611cdb565b8352918301918301611e3b565b509695505050505050565b600060208284031215611e7657600080fd5b813567ffffffffffffffff811115611e8d57600080fd5b611e9984828501611df2565b949350505050565b6020808252825182820181905260009190848201906040850190845b81811015611ed957835183529284019291840191600101611ebd565b50909695505050505050565b600067ffffffffffffffff821115611eff57611eff611d87565b50601f01601f191660200190565b60008060408385031215611f2057600080fd5b611f2983611cdb565b9150602083013567ffffffffffffffff811115611f4557600080fd5b8301601f81018513611f5657600080fd5b8035611f64611e1382611ee5565b818152866020838501011115611f7957600080fd5b816020840160208301376000602083830101528093505050509250929050565b600080600060608486031215611fae57600080fd5b611fb784611cdb565b9250611fc560208501611d12565b9150604084013563ffffffff81168114611fde57600080fd5b809150509250925092565b600060208284031215611ffb57600080fd5b5035919050565b60008060006060848603121561201757600080fd5b61202084611cdb565b925061202e60208501611d12565b9150604084013590509250925092565b6000806040838503121561205157600080fd5b823567ffffffffffffffff8082111561206957600080fd5b61207586838701611df2565b935060209150818501358181111561208c57600080fd5b85019050601f8101861361209f57600080fd5b80356120ad611e1382611dce565b81815260059190911b820183019083810190888311156120cc57600080fd5b928401925b828410156120ea578335825292840192908401906120d1565b80955050505050509250929050565b6020808252601390820152726368617267653a7a65726f206164647265737360681b604082015260600190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b19195b1959d85d1958d85b1b60a21b606082015260800190565b6020808252602c908201527f46756e6374696f6e206d7573742062652063616c6c6564207468726f7567682060408201526b6163746976652070726f787960a01b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600182016121fc576121fc6121d4565b5060010190565b6020808252818101527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572604082015260600190565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b815160009082906020808601845b838110156122b95781516001600160a01b031685529382019390820190600101612294565b50929695505050505050565b634e487b7160e01b600052602160045260246000fd5b6001600160a01b0383168152604081016003831061230957634e487b7160e01b600052602160045260246000fd5b8260208301529392505050565b60006020828403121561232857600080fd5b81518015158114611cd457600080fd5b60008282101561234a5761234a6121d4565b500390565b60008219821115612362576123626121d4565b500190565b60005b8381101561238257818101518382015260200161236a565b83811115612391576000848401525b50505050565b600082601f8301126123a857600080fd5b81516123b6611e1382611ee5565b8181528460208386010111156123cb57600080fd5b611e99826020830160208701612367565b805160038110611cf257600080fd5b805160028110611cf257600080fd5b600080600080600080600060e0888a03121561241557600080fd5b875167ffffffffffffffff8082111561242d57600080fd5b6124398b838c01612397565b985060208a015191508082111561244f57600080fd5b61245b8b838c01612397565b975061246960408b016123dc565b965060608a015191508082111561247f57600080fd5b61248b8b838c01612397565b955061249960808b016123eb565b94506124a760a08b016123eb565b935060c08a01519150808211156124bd57600080fd5b506124ca8a828b01612397565b91505092959891949750929550565b600082516124eb818460208701612367565b9190910192915050565b6020815260008251806020840152612514816040850160208701612367565b601f01601f1916919091016040019291505056fe416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a2646970667358221220af075978a1fbae41e441558cbcddc3b977d668a2d3a3c033b886a2b08e46c30e64736f6c634300080e0033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFBATCH = "balanceOfBatch";

    public static final String FUNC_DELDDC = "delDDC";

    public static final String FUNC_DELFEE = "delFee";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PAY = "pay";

    public static final String FUNC_QUERYFEE = "queryFee";

    public static final String FUNC_RECHARGE = "recharge";

    public static final String FUNC_RECHARGEBATCH = "rechargeBatch";

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
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Address>() {
            }));
    ;

    public static final Event BEACONUPGRADED_EVENT = new Event("BeaconUpgraded",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }));
    ;

    public static final Event DELDDC_EVENT = new Event("DelDDC",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }));
    ;

    public static final Event DELFEE_EVENT = new Event("DelFee",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Bytes4>() {
            }));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));
    ;

    public static final Event PAY_EVENT = new Event("Pay",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Bytes4>() {
            }, new TypeReference<Uint32>() {
            }, new TypeReference<Uint256>() {
            }));
    ;

    public static final Event RECHARGE_EVENT = new Event("Recharge",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));
    ;

    public static final Event RECHARGEBATCH_EVENT = new Event("RechargeBatch",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<DynamicArray<Address>>(true) {
            }, new TypeReference<DynamicArray<Uint256>>() {
            }));
    ;

    public static final Event SETFEE_EVENT = new Event("SetFee",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Bytes4>() {
            }, new TypeReference<Uint32>() {
            }));
    ;

    public static final Event SETTLEMENT_EVENT = new Event("Settlement",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }, new TypeReference<Uint256>() {
            }));
    ;

    public static final Event UPGRADED_EVENT = new Event("Upgraded",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }));
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
            typedResponse.ddcId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
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
                typedResponse.ddcId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
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

    public List<RechargeBatchEventResponse> getRechargeBatchEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(RECHARGEBATCH_EVENT, transactionReceipt);
        ArrayList<RechargeBatchEventResponse> responses = new ArrayList<RechargeBatchEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RechargeBatchEventResponse typedResponse = new RechargeBatchEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.toList = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amounts = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RechargeBatchEventResponse> rechargeBatchEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RechargeBatchEventResponse>() {
            @Override
            public RechargeBatchEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(RECHARGEBATCH_EVENT, log);
                RechargeBatchEventResponse typedResponse = new RechargeBatchEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.toList = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amounts = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RechargeBatchEventResponse> rechargeBatchEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECHARGEBATCH_EVENT));
        return rechargeBatchEventFlowable(filter);
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> balanceOfBatch(List<String> accAddrs) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOFBATCH,
                Arrays.<Type>asList(new DynamicArray<Address>(
                        Address.class,
                        org.web3j.abi.Utils.typeMap(accAddrs, Address.class))),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {
                }));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> pay(String payer, byte[] sig, BigInteger ddcId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAY,
                Arrays.<Type>asList(new Address(160, payer),
                        new Bytes4(sig),
                        new Uint256(ddcId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> queryFee(String ddcAddr, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUERYFEE,
                Arrays.<Type>asList(new Address(160, ddcAddr),
                        new Bytes4(sig)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {
                }));
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

    public RemoteFunctionCall<TransactionReceipt> rechargeBatch(List<String> toList, List<BigInteger> amounts) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECHARGEBATCH,
                Arrays.<Type>asList(new DynamicArray<Address>(
                                Address.class,
                                org.web3j.abi.Utils.typeMap(toList, Address.class)),
                        new DynamicArray<Uint256>(
                                Uint256.class,
                                org.web3j.abi.Utils.typeMap(amounts, Uint256.class))),
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
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

        public BigInteger ddcId;
    }

    public static class RechargeEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger amount;
    }

    public static class RechargeBatchEventResponse extends BaseEventResponse {
        public String from;

        public byte[] toList;

        public List<BigInteger> amounts;
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
