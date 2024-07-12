package org.example.figma.controller;

import lombok.RequiredArgsConstructor;
import org.example.figma.entity.Order;
import org.example.figma.model.dto.request.OrderProductDTO;
import org.example.figma.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Order> saveOrder(@RequestBody List<OrderProductDTO> orderProductDTOList){
        return orderService.save(orderProductDTOList);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return orderService.getAllOrders();
    }


}