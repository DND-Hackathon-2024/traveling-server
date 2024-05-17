package com.plass.traveling.domain.place.service;

import com.plass.traveling.domain.place.payload.request.CreatePlaceRequest;
import com.plass.traveling.domain.place.repository.PlaceRepository;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{
    private final PlaceRepository placeRepository;

    @Override
    public BaseResponse placeCreate(CreatePlaceRequest placeCreateRequest) {
        placeRepository.save(dtoToEntity(placeCreateRequest));

        return new BaseResponse(HttpStatus.OK, "생성 성공");
    }

    @Override
    public BaseResponse placeDelete(Long id) {
        placeRepository.deleteById(id);

        return new BaseResponse(HttpStatus.OK, "삭제 성공");
    }

    @Override
    public BaseResponse findAll() {
        return null;
    }
}
