package com.back;

import com.back.dto.request.WiseSayingRequest;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService = new WiseSayingService();

    public int createWiseSaying(WiseSayingRequest request){

        return wiseSayingService.createWiseSaying(request);
    }

}
