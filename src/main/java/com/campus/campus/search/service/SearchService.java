package com.campus.campus.search.service;

import com.campus.campus.search.entity.SearchStore;
import com.campus.campus.search.entity.Store;
import com.campus.campus.search.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {


    private final StoreRepository storeRepository;

    public SearchService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public SearchStore findById(long storeId){

        System.out.println("service > findById()");

        Optional<Store> store = storeRepository.findById(storeId);
        System.out.println(store.get().getStoreName());
        //SearchStore searchStore=SearchStore.of(store);

        return new SearchStore();
    }

    public List<SearchStore> findAll(){

        System.out.println("service > findAll()");

        List<Store> stores=storeRepository.findAll();
        List<SearchStore> searchStores=new ArrayList<>();
        System.out.println(searchStores.get(0).getSearchStoreName());

        return searchStores;
    }
}
