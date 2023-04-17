package com.campus.campus.member.audit;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 공통 속성을 가진 엔티티 클래스를 정의할 때 사용됨
@EntityListeners(AuditingEntityListener.class) // 엔티티에 이벤트 리스너를 등록
public abstract class Auditable {
    @CreatedDate // 엔티티가 생성될 때 자동으로 현재 시간을 할당해줌
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔티티가 수정될 때 자동으로 현재 시간을 갱신해줌
    @Column(name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt;
}
