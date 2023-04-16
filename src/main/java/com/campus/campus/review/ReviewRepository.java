package com.campus.campus.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT m.nickName FROM Review r JOIN Member m ON r.memberId = m.id WHERE r.memberId = :memberId")
    String findNickNamesByMemberId(Long memberId);


}
