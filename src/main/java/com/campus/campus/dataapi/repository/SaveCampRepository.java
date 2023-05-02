package com.campus.campus.dataapi.repository;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveCampRepository extends JpaRepository<CampBaseInfo, Long> {

    //Page<CampBaseInfo> fin
    Page<CampBaseInfo> findAllByStoreIdLessThanOrderByStoreIdDesc(long StoreId, Pageable pageable);
    //List<CampBaseInfo> findAll();
}
