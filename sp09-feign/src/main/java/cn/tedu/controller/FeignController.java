package cn.tedu.controller;

import cn.tedu.pojo.Item;
import cn.tedu.pojo.Order;
import cn.tedu.pojo.User;
import cn.tedu.service.ItemFeignService;
import cn.tedu.service.OrderFeignService;
import cn.tedu.service.UserFeignService;
import cn.tedu.web.util.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FeignController {
    @Resource
    private ItemFeignService itemService;
    @Resource
    private UserFeignService userService;
    @Resource
    private OrderFeignService orderService;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return itemService.getItems(orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return itemService.decreaseNumber(items);
    }


    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        return userService.addScore(userId, score);
    }


    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return orderService.addOrder();
    }
}