package com.wru.wrubookstore.service;

import com.wru.wrubookstore.domain.OrderSearchCondition;
import com.wru.wrubookstore.dto.*;
import com.wru.wrubookstore.dto.request.order.OrderBookRequest;
import com.wru.wrubookstore.dto.request.order.OrderDetailRequest;
import com.wru.wrubookstore.dto.request.order.OrderHistoryRequest;
import com.wru.wrubookstore.dto.request.order.OrderPaymentRequest;
import com.wru.wrubookstore.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final DeliveryRepository deliveryRepository;
    private final AddressRepository addressRepository;
    private final BookRepository bookRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository, DeliveryRepository deliveryRepository, AddressRepository addressRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.deliveryRepository = deliveryRepository;
        this.addressRepository = addressRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<OrderHistoryRequest> selectListByOsc(Integer userId, OrderSearchCondition osc) throws Exception {
        return orderRepository.selectListByOsc(Map.of("userId", userId, "osc", osc));
    }

    @Override
    public int selectCntByOsc(Integer userId, OrderSearchCondition osc) throws Exception {
        return orderRepository.selectCntByOsc(Map.of("userId", userId, "osc", osc));
    }

    @Override
    public OrderDetailRequest selectOrderDetail(Integer orderId) throws Exception {
        OrderDto orderDto = orderRepository.select(orderId);
        PaymentDto paymentDto = paymentRepository.select(orderId);
        List<OrderBookRequest> orderBookRequestList = orderRepository.selectOrderBook(orderId);
        DeliveryDto deliveryDto = deliveryRepository.select(orderId);

        return new OrderDetailRequest(orderDto, paymentDto, orderBookRequestList, deliveryDto);
    }

    @Override
    public OrderPaymentRequest selectOrderPayment(Integer memberId, List<Integer> bookIdList) throws Exception {
        AddressDto addressDto = addressRepository.selectDefaultAddress(memberId);
        List<OrderBookRequest> orderBookRequestList = bookRepository.selectByBookIdList(bookIdList);

        return new OrderPaymentRequest(addressDto, orderBookRequestList);
    }
}
