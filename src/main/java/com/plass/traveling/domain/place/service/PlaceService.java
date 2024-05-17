package com.plass.traveling.domain.place.service;

import com.plass.traveling.global.common.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface PlaceService {
    BaseResponse findAll();
}