package com.cheese.springjpa.delivery;

import com.cheese.springjpa.delivery.exception.DeliveryNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery create(DeliveryDto.CreationReq dto) {
        final Delivery delivery = dto.toEntity();
        delivery.addLog(DeliveryStatus.PENDING);
        return deliveryRepository.save(delivery);
    }

    public Delivery updateStatus(long id, DeliveryDto.UpdateReq dto) {
        final Delivery delivery = findById(id);
        delivery.addLog(dto.getStatus());
        return delivery;
    }


    public Delivery findById(long id) {
        final Delivery delivery = deliveryRepository.findOne(id);
        if (delivery == null) throw new DeliveryNotFoundException(id);
        return delivery;
    }



}
