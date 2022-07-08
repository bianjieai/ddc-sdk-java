package ai.bianjie.ddc.client;

import ai.bianjie.ddc.function.EventHandler;
import ai.bianjie.ddc.model.tx.EventQueryBuilder;
import ai.bianjie.ddc.model.ws.block.NewBlockBean;
import ai.bianjie.ddc.model.ws.tx.TxBean;

import java.io.IOException;

public interface WsEvent {
    void subscribeNewBlock(EventQueryBuilder builder, EventHandler<NewBlockBean> handler) throws IOException;

    void subscribeTx(EventQueryBuilder builder, EventHandler<TxBean> txHandler);
}
