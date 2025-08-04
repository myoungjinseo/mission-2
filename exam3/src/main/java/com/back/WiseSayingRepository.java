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

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public int findId(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void deleteWiseSaying(int findId) {
        wiseSayings.remove(findId);
    }
}
