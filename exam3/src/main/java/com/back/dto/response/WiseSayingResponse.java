package com.back.dto.response;

import com.back.WiseSaying;

public record WiseSayingResponse(
        int findId,
        String content,
        String author,
        String errorMsg
) {
    public static WiseSayingResponse of(int findId, WiseSaying wiseSaying, String errorMsg) {
        if (wiseSaying == null) {
            return new WiseSayingResponse(findId,"", "", errorMsg);
        }
        return new WiseSayingResponse(findId, wiseSaying.getContent(), wiseSaying.getAuthor(), errorMsg);
    }
}
