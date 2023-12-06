package com.spacex.concurrent.loadbalance;

public interface LoadBalance {
    String getServer(String clientIp);
}