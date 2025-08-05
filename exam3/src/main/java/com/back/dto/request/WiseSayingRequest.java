package com.back.dto.request;

import com.back.WiseSaying;

public record WiseSayingRequest(
        String content,
        String author
) {
    public static WiseSaying toEntity(int id,WiseSayingRequest wiseSayingRequest) {
        return new WiseSaying(id,wiseSayingRequest.content,wiseSayingRequest.author);
    }
}
