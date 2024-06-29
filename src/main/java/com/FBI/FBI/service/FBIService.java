package com.FBI.FBI.service;

import java.util.List;

import com.FBI.FBI.entity.FBI;

public interface FBIService {
    
    
    FBI saveFBI(FBI fbi);

    FBI getFBIById(Long id);

    FBI updateFBI(FBI fbi);

    void deleteFBIById(Long id);


}