package com.back;

import com.back.dto.request.WiseSayingRequest;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public int createWiseSaying(WiseSayingRequest request) {
        int lastId = 0;
        if(!wiseSayingRepository.emptyByWiseSaying())
            lastId = wiseSayingRepository.findLastId();
        WiseSaying wiseSaying = new WiseSaying(lastId + 1, request.content(), request.author());
        wiseSayingRepository.createWisesSaying(wiseSaying);
        return wiseSaying.getId();
    }
}
