package com.example.patternComposite;

import java.util.ArrayList;
import java.util.List;

public class HumanComposite implements Human{
    private List<Human> humans = new ArrayList<>();

    public void addHumanAccount(Human human){
        humans.add(human);
    }

    @Override
    public void getAccount() {
       for (Human human:humans){
           human.getAccount();
       }
    }
}
