package com.company;

public class CDFactory implements AbsFactory {
    @Override
    public HotPot createHotpot(String orderType) {
        HotPot hotpot = null;
        if (orderType.equals("毛肚")) {
            hotpot = new CDMaoduHotpot();
        } else if (orderType.equals("羊肉")) {
            hotpot = new CDYangrouHotpot();
        }
        return hotpot;
    }
}
