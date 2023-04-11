package com.campus.campus.dataapi.repository;

import com.campus.campus.dataapi.entity.CampBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveCampRepository extends JpaRepository<CampBaseInfo, Long> {

}
