package com.coding.ProductApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.ProductApplication.entity.ApprovalQueueEntity;
import com.coding.ProductApplication.entity.ProductEntity;

@Repository
public interface ApprovalQueueRepository extends JpaRepository<ApprovalQueueEntity, Long> {

    public ApprovalQueueEntity findByproductEntity(ProductEntity productEntity);

    public ApprovalQueueEntity deleteByproductEntity(ProductEntity productEntity);
}
