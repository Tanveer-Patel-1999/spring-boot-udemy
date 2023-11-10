package com.relation.onetomany.repository;

import com.relation.onetomany.entity.HostelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelEntityRepository extends JpaRepository<HostelEntity, Long> {
}