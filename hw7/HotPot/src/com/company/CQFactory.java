package com.company;

public class CQFactory implements AbsFactory {
    @Override
    public HotPot createHotpot(String orderType) {
        HotPot hotpot = null;
        if (orderType.equals("毛肚")) {
            hotpot = new CQMaoduHotpot();
        } else if (orderType.equals("羊肉")) {
            hotpot = new CQYangrouHotpot();
        }
        return hotpot;
    }
}
