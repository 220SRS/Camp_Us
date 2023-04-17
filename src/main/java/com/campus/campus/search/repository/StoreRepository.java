package com.campus.campus.search.repository;


import com.campus.campus.search.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {


    Optional<Store> findById(long storeId);

    List<Store> findAll();

}

