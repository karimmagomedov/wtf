package com.epam.wtf.service;

import org.springframework.stereotype.Service;

@Service("catService")
public class CatServiceImpl implements CatService {
    private CatService catService;

    public CatServiceImpl() {
    }

    public CatServiceImpl(CatService catService) {
        this.catService = catService;
    }

    @Override
    public double add(double val1, double val2) {
        return catService.add(val1, val2);
    }

    @Override
    public double subtract(double val1, double val2) {
        return catService.subtract(val1, val2);
    }

    @Override
    public double multiply(double val1, double val2) {
        return catService.multiply(val1, val2);
    }

    @Override
    public double divide(double val1, double val2) {
        return catService.divide(val1, val2);
    }

    public double double15(){
        return 15.0;
    }
}
