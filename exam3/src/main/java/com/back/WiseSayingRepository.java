package com.back;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public boolean emptyByWiseSaying() {
        return wiseSayings.isEmpty();
    }

    public int findLastId() {
        return wiseSayings.getLast().getId();
    }

    public void save(WiseSaying wiseSaying) {
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public int findIdById(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public WiseSaying findById(int id) {
        String author = wiseSayings.get(id).getAuthor();
        String content = wiseSayings.get(id).getContent();
        return new WiseSaying(id, author, content);
    }

    public void deleteById(int findId) {
        wiseSayings.remove(findId);
    }

    public void update(int id, WiseSaying wiseSaying) {
        wiseSayings.set(id,wiseSaying);
    }
}
