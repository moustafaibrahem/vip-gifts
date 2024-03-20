package com.promo.vipgifts.service;

import com.promo.vipgifts.dto.GiftTypeDto;
import com.promo.vipgifts.entity.GiftType;
import com.promo.vipgifts.repository.GiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiftTypeService {
    private final GiftTypeRepository giftTypeRepository;
    @Autowired
    public GiftTypeService(GiftTypeRepository giftTypeRepository) {
        this.giftTypeRepository = giftTypeRepository;
    }
    private GiftTypeDto mapToDto(GiftType giftType){
        return new GiftTypeDto(giftType.giftTypeName(),giftType.giftTypeDescription(), giftType.giftTypeCode());
    }
    public List<GiftTypeDto> getAllGiftTypesDTOs(){
        List<GiftType> giftTypes = (List<GiftType>) giftTypeRepository.findAll();
        return giftTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    public List<GiftTypeDto> getAllCustomerGiftTypesDTOs(String phone){
        List<GiftType> giftTypes = giftTypeRepository.getAllGiftTypesByCustomerPhone(phone);
        return giftTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }
    public List<GiftTypeDto> getAvailableCustomerGiftTypesDTOs(String phone){
        List<GiftType> giftTypes = giftTypeRepository.getAvailableGiftTypesByCustomerPhone(phone);
        return giftTypes.stream().map(this::mapToDto).collect(Collectors.toList());
    }

}
