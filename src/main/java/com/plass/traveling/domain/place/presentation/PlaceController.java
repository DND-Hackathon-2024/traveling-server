package com.plass.traveling.domain.place.presentation;

import com.plass.traveling.domain.place.payload.request.CreatePlaceRequest;
import com.plass.traveling.domain.place.service.PlaceService;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping("/list")
    public BaseResponse allPlaces(){
        return placeService.findAll();
    }

    @PostMapping("/create")
    public BaseResponse createPlace(@RequestBody CreatePlaceRequest createPlaceRequest) {
        return placeService.placeCreate(createPlaceRequest);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteVideo(@PathVariable Long id){
        return placeService.placeDelete(id);
    }

}
