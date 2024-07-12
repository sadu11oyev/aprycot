package org.example.figma.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.figma.entity.Order;
import org.example.figma.entity.OrderProduct;
import org.example.figma.entity.User;
import org.example.figma.entity.enums.OrderStatus;
import org.example.figma.mappers.OrderProductMapper;
import org.example.figma.model.dto.request.OrderProductReqDTO;
import org.example.figma.repo.OrderProductRepository;
import org.example.figma.repo.OrderRepository;
import org.example.figma.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final User authenticatedUser;
    private final OrderRepository orderRepository;
    private final OrderProductMapper orderProductMapper;
    private final OrderProductRepository orderProductRepository;

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> userOrders = orderRepository.findAllByUserId(authenticatedUser.getId());
        return ResponseEntity.status(200).body(userOrders);
    }

    @Override
    public ResponseEntity<Order> save(List<OrderProductReqDTO> orderProductReqDTOList) {
        Order order=new Order();
        order.setUser(authenticatedUser);
        order.setOrderStatus(OrderStatus.OPEN);
        orderRepository.save(order);
        for (OrderProductReqDTO orderProductReqDTO : orderProductReqDTOList) {
            OrderProduct orderProduct = orderProductMapper.toEntity(orderProductReqDTO);
            orderProduct.setOrder(order);
            orderProductRepository.save(orderProduct);
        }
        return ResponseEntity.status(200).body(order);
    }
}
