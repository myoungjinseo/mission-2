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

    public void deleteWiseSaying(String command){
        String response = wiseSayingService.deleteWiseSaying(command);
        System.out.println(response);
    }
}
