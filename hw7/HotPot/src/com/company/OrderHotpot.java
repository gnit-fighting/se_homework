package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderHotpot {
    private AbsFactory factory;

    public OrderHotpot(AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        do {
            this.factory = factory;
            String orderType = getType();
            HotPot hotpot = factory.createHotpot(orderType);
            if (hotpot == null) {
                System.out.println("很遗憾！订购失败！");
                break;
            }
            hotpot.prepare();
            hotpot.cut();
            hotpot.serve();
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin;
            strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input hotpot 种类:");
            String str = strin.readLine();
            return str;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
