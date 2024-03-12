package com.rhontproject.service.events.marketgoods.goods;

import com.rhontproject.service.events.marketgoods.MarketObject;

import static com.rhontproject.fabrics.global.StateGame.setMarketExit;

/**
 *
 */
public class Exit extends MarketObject {

    @Override
    public void buy() {
        setMarketExit(true);
    }

    @Override
    protected void initComponent() {
        this.articular=0;
        this.name = "Выход";
        this.cost = 0;
    }
}
