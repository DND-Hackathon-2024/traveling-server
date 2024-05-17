package com.plass.traveling.domain.place.service;

import com.plass.traveling.domain.place.entity.Place;
import com.plass.traveling.domain.place.payload.response.PlaceCreateResponse;
import com.plass.traveling.domain.place.payload.response.PlaceResponseDto;
import com.plass.traveling.domain.place.repository.PlaceRepository;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.exception.place.PlaceError;
import com.plass.traveling.global.exception.place.PlaceException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl {
    private final PlaceRepository placeRepository;

    @Override
    public BaseResponse findAll() {
        List<Place> places = placeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<PlaceResponseDto> dtos = places.stream()
                .map(this::entityToDto)
                .toList();

        return new BaseResponse(HttpStatus.OK, "모든 장소 불러오기 성공", dtos);
    }

    @Override
    public BaseResponse placeCreate(PlaceCreateResponse deviceCreateRequest,
                                    MultipartFile multipartFile,
                                    Authentication authentication) {
        if (multipartFile.isEmpty()) throw new PlaceException(PlaceError.PLACE_NOT_FOUND_EXCEPTION);

        else {
            String url = S3Uploader.upload(multipartFile, "device");
        }
    }

    @Override
    public BaseResponse findAll() {
        return new BaseResponse(
                HttpStatus.OK,
                "불러오기 성공",
                placeRepository.findAll()
        );
    }
}
