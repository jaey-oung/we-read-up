package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.FaqDto;
import com.wru.wrubookstore.repository.FaqRepository;
import com.wru.wrubookstore.repository.FaqRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FaqRepository faqRepository;

    public FaqService(FaqRepositoryImpl faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<FaqDto> getList() throws Exception{
        return faqRepository.selectAll();
    }

    public FaqDto read(Integer faqId) throws Exception{
        FaqDto faqDto = faqRepository.select(faqId);

        return faqDto;
    }

    public Integer remove(Integer faqId, String employeeId) throws Exception{
        return faqRepository.delete(faqId, employeeId);
    }

    public Integer write(FaqDto faqDto) throws Exception{
        return faqRepository.insert(faqDto);
    }





}
