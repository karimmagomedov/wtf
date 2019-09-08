package com.epam.wtf.service;

import com.epam.wtf.model.Dog;

import java.util.List;

public interface DogService {
    List<String> getDogNames();
    int getDogCounts();
    int getDogCounts(String name);
    Dog addDog(String vaccine);
}
