package com.example.chkimshop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass //매핑정보만 상속받는 Superclass라는 의미의 @MappedSuperclass 어노테이션 선언
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    private String createdBy;
    @CreatedDate
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;


}


