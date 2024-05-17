package com.plass.traveling.domain.trap.presentation;

import com.plass.traveling.domain.trap.payload.request.CreateTrapRequest;
import com.plass.traveling.domain.trap.service.TrapService;
import com.plass.traveling.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/trap")
@RequiredArgsConstructor
public class TrapController {
    private final TrapService trapService;

    @GetMapping("/list")
    public BaseResponse allTraps(){
        return trapService.findAll();
    }

    @PostMapping("/create")
    public BaseResponse createTrap(@RequestBody CreateTrapRequest createTrapRequest) {
        return trapService.trapCreate(createTrapRequest);
    }

    @GetMapping("/{id}")
    public BaseResponse getTrap(
            @PathVariable Long id
    ) {
        return trapService.getTrap(id);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTrap(@PathVariable Long id){
        return trapService.trapDelete(id);
    }
}
