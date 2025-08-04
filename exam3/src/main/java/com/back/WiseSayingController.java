package com.back;

import com.back.dto.request.WiseSayingRequest;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService = new WiseSayingService();

    public int createWiseSaying(WiseSayingRequest request){
        return wiseSayingService.createWiseSaying(request);
    }


    public String getWiseSaying() {
        return wiseSayingService.getWiseSaying();
    }

    public String deleteWiseSaying(String command){
        return wiseSayingService.deleteWiseSaying(command);
    }
}
