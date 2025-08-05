package com.back;

import com.back.dto.request.WiseSayingRequest;
import com.back.dto.response.WiseSayingResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public int createWiseSaying(WiseSayingRequest request) {
        int lastId = 0;
        if(!wiseSayingRepository.emptyByWiseSaying())
            lastId = wiseSayingRepository.findLastId();
        WiseSaying wiseSaying = new WiseSaying(lastId + 1, request.content(), request.author());
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying.getId();
    }

    public String getWiseSaying() {
        StringBuilder sb = new StringBuilder();
        sb.append("번호 / 작가 . 명언").append("\n");
        sb.append("----------------------").append("\n");
        List<WiseSaying> wiseSayingList = wiseSayingRepository.findAll();
        List<WiseSaying> reverse = reverseWiseSaying(wiseSayingList);
        for (WiseSaying wiseSaying : reverse) {
            sb.append("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent())).append("\n");
        }
        return sb.toString().trim();
    }

    public List<WiseSaying> reverseWiseSaying(List<WiseSaying> wiseSayingList) {
        List<WiseSaying> reverse = new ArrayList<>(wiseSayingList);
        Collections.reverse(reverse);
        return reverse;
    }

    public String deleteWiseSaying(String command) {
        int deleteId = getId(command);
        int findId = wiseSayingRepository.findIdById(deleteId);
        if(findId == -1)
            return "%d번 명언이 존재하지 않습니다.".formatted(deleteId);
        wiseSayingRepository.deleteById(findId);
        return "%d번 명언이 삭제되었습니다.".formatted(deleteId);
    }

    public int getId(String command){
        return Integer.parseInt(command.split("=")[1]);
    }

    public String updateWiseSaying(int updateId, WiseSayingRequest request) {
        int findId = wiseSayingRepository.findIdById(updateId);
        WiseSaying wiseSaying = WiseSayingRequest.toEntity(updateId, request);
        wiseSayingRepository.update(findId,wiseSaying);
        return "";
    }


    public WiseSayingResponse getWiseSayingById(String command) {
        int updateId = getId(command);
        int findId = wiseSayingRepository.findIdById(updateId);
        String errorMsg = null;
        if(findId == -1){
            errorMsg = "%d번 명언이 존재하지 않습니다.".formatted(updateId);
            return WiseSayingResponse.of(updateId,null,errorMsg);
        }
        WiseSaying wiseSaying = wiseSayingRepository.findById(findId);
        return WiseSayingResponse.of(updateId,wiseSaying,errorMsg);
    }
}
