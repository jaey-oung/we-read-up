package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.InquiryDto;
import com.wru.wrubookstore.repository.InquiryRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InquiryServiceImpl {

    private final InquiryRepositoryImpl inquiryRepository;

    public InquiryServiceImpl(InquiryRepositoryImpl inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public List<InquiryDto> getList() throws Exception{
        return inquiryRepository.selectAll();
    }

    public int write(InquiryDto inquiryDto) throws Exception{
        inquiryDto.setInquiry_status_id("ID_1");    // 고객 문의 등록시 상태를 "ID_1"으로 설정
        inquiryRepository.insert(inquiryDto);

        Map<String, Object> params = new HashMap<>();
        params.put("inquiryId", inquiryDto.getInquiryId());
        params.put("inquiryStatusId", "ID_1");
        inquiryRepository.updateInquiryStatus(params);

        return inquiryDto.getInquiryId();
    }

    public int remove(Integer inquiryId, Integer memberId) throws Exception{
        return inquiryRepository.delete(inquiryId, memberId);
    }

    public int removeForAdmin(Integer inquiryId) throws Exception{
        return inquiryRepository.deleteForAdmin(inquiryId);
    }

    public int modify(InquiryDto inquiryDto) throws Exception{
        return inquiryRepository.update(inquiryDto);
    }

    public int reply(InquiryDto inquiryDto) throws Exception {
        inquiryRepository.updateReply(inquiryDto);

        Map<String, Object> params = new HashMap<>();
        params.put("inquiryId", inquiryDto.getInquiryId());
        params.put("inquiryStatusId", "ID_2");
        inquiryRepository.updateInquiryStatus(params);

        return inquiryDto.getInquiryId();
    }
}
