package com.example.intromvvm;

import androidx.lifecycle.ViewModel;

public class HitungViewModel extends ViewModel {

    int resultData = 0;
    //buat method
    void calculate(String nilai1, String nilai2) {

        resultData = Integer.parseInt(nilai1) * Integer.parseInt(nilai2) ;
    }
}