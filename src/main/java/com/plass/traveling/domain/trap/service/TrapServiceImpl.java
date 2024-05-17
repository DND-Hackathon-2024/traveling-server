package com.plass.traveling.domain.trap.service;

import com.plass.traveling.domain.trap.payload.request.CreateTrapRequest;
import com.plass.traveling.domain.trap.repository.TrapRepository;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrapServiceImpl implements TrapService{
    private final TrapRepository trapRepository;

    @Override
    public BaseResponse trapCreate(CreateTrapRequest createTrapRequest) {
        trapRepository.save(dtoToEntity(createTrapRequest));

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
