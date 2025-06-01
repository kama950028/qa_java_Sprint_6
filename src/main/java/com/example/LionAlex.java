package com.example;

import java.util.List;

public class LionAlex extends Lion {

    public LionAlex() throws Exception {
        super("Самец", new Feline());
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

}
