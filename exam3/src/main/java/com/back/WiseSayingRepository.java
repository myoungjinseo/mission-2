package com.back;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayings = new ArrayList<WiseSaying>();
    public boolean emptyByWiseSaying() {
        return wiseSayings.isEmpty();
    }

    public int findLastId() {
        return wiseSayings.getLast().getId();
    }

    public void createWisesSaying(WiseSaying wiseSaying) {
        wiseSayings.add(wiseSaying);
    }
}
