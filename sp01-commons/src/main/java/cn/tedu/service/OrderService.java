package cn.tedu.service;

import cn.tedu.pojo.Order;

public interface OrderService {
    Order getOrder(String orderId);
    void addOrder(Order order);
}
