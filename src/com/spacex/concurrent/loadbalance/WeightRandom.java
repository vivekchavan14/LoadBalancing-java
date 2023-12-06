package com.spacex.concurrent.loadbalance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WeightRandom implements LoadBalance {
    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String server = iterator.next();
            Integer weight = IpPool.ipMap.get(server);
            if (weight != null && weight > 0) {
                for (int i = 0; i < weight; i++) {
                    serverList.add(server);
                }
            }
        }

        Integer index = new Random().nextInt(serverList.size());
        String target = serverList.get(index);
        return target;
    }
}