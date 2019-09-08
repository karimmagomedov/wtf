package com.epam.wtf.service;

import static org.mockito.Mockito.when;

import com.epam.wtf.model.Dog;
import com.epam.wtf.service.impl.DogServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DogServiceImplTest {

    @Mock
    DogServiceImpl dogServiceImpl;

    @InjectMocks
    DogServiceImpl dogService = new DogServiceImpl();

    @Before
    public void init(){
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Psina", "pitbull", (short) 2,true));
        dogList.add(new Dog("Pyos", "bulldog", (short) 4,true));
        dogList.add(new Dog("Snoop", "Dogg", (short) 42,false));
        dogList.add(new Dog("Sharik", "afador", (short) 10,true));
        dogList.add(new Dog("Psina", "american escimo dog", (short) 11,false));
    }

    @Test
    public void getDogCounts() {
        when(dogServiceImpl.getDogCounts()).thenReturn(5);

    }
}
