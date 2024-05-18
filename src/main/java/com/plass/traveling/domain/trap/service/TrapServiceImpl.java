package com.plass.traveling.domain.trap.service;

import com.plass.traveling.domain.coupon.repository.CouponRepository;
import com.plass.traveling.domain.trap.payload.request.CreateTrapRequest;
import com.plass.traveling.domain.trap.repository.TrapRepository;
import com.plass.traveling.global.common.BaseResponse;
import com.plass.traveling.global.exception.CustomException;
import com.plass.traveling.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrapServiceImpl implements TrapService{
    private final TrapRepository trapRepository;
    private final CouponRepository couponRepository;

    @Override
    public BaseResponse trapCreate(CreateTrapRequest createTrapRequest) {
        trapRepository.save(dtoToEntity(
                    createTrapRequest,
                    couponRepository.findById(createTrapRequest.couponId()).orElseThrow(
                            () -> new CustomException(ErrorCode.NOT_FOUND)
                    )
                )
        );

        return new BaseResponse(HttpStatus.OK, "생성 성공");
    }

    @Override
    public BaseResponse trapDelete(Long id) {
        trapRepository.deleteById(id);

        return new BaseResponse(HttpStatus.OK, "삭제 성공");
    }

    @Override
    public BaseResponse findAll() {
        return new BaseResponse(
                HttpStatus.OK,
                "불러오기 성공",
                trapRepository.findAll()
        );
    }
}
