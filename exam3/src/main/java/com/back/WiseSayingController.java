package com.back;

import com.back.dto.request.WiseSayingRequest;
import com.back.dto.response.WiseSayingResponse;

import javax.imageio.IIOException;
import java.io.IOException;

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

    public String updateWiseSaying(int id, WiseSayingRequest request) {
        return wiseSayingService.updateWiseSaying(id,request);
    }

    public WiseSayingResponse getWiseSayingById(String command) {
        WiseSayingResponse response = wiseSayingService.getWiseSayingById(command);
        if(response.errorMsg() != null){
            System.out.println(response.errorMsg());
            return null;
        }
        return response;
    }

    public void createWiseSayingJson() throws IOException {
        System.out.println(wiseSayingService.getWiseSaying());
        wiseSayingService.createWiseSayingJson();
    }

    public void initializeFiles() {
        wiseSayingService.initializeFiles();
    }
}
