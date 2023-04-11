package com.campus.campus.search.service;

import com.campus.campus.search.entity.SearchStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    public List<SearchStore> findAll(){

        System.out.println("service > findAll()");

        List<SearchStore> stores=new ArrayList<>();


        return stores;
    }
}
