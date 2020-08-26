package cn.tedu.controller;

import cn.tedu.pojo.Item;
import cn.tedu.pojo.Order;
import cn.tedu.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RibbonController {
    @Resource
    private RestTemplate rt;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        //向指定微服务地址发送 get 请求，并获得该服务的返回结果
        //{1} 占位符，用 orderId 填充
        return rt.getForObject("http://localhost:8001/{1}", JsonResult.class, orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        //发送 post 请求
        return rt.postForObject("http://localhost:8001/decreaseNumber", items, JsonResult.class);
    }


    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return rt.getForObject("http://localhost:8101/{1}", JsonResult.class, userId);
    }

    @GetMapping("/user-service/{userId}/score")
    public JsonResult addScore(
            @PathVariable Integer userId, Integer score) {
        return rt.getForObject("http://localhost:8101/{1}/score?score={2}", JsonResult.class, userId, score);
    }


    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return rt.getForObject("http://localhost:8201/{1}", JsonResult.class, orderId);
    }

    @GetMapping("/order-service")
    public JsonResult addOrder() {
        return rt.getForObject("http://localhost:8201/", JsonResult.class);
    }
}