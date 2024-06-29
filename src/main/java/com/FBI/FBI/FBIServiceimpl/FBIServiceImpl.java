
package com.FBI.FBI.FBIServiceimpl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.FBI.FBI.entity.FBI;
import com.FBI.FBI.repository.FBIRepository;
import com.FBI.FBI.service.FBIService;

@Service
public class FBIServiceImpl implements FBIService{

    private FBIRepository fbiRepository;


    public FBIServiceImpl(FBIRepository fbiRepository) {
        super();
        this.fbiRepository = fbiRepository;
    }

    @Override
    public List<FBI> getAllFBI() {
        return fbiRepository.findAll();
    }

    @Override
    public FBI saveFBI(FBI fbi) {
        return fbiRepository.save(fbi);
    }

    @Override
    public FBI getFBIById(Long id) {
        return fbiRepository.findById(id).get();
    }

    @Override
    public FBI updateFBI(FBI fbi) {
        return fbiRepository.save(fbi);
    }

    @Override
    public void deleteFBIById(Long id) {
        fbiRepository.deleteById(id);
    }

}
