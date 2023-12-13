package com.coding.ProductApplication.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "approval_queue")
public class ApprovalQueueEntity {

    public ApprovalQueueEntity() {
		super();
	}


	public ApprovalQueueEntity(long approvalQueueId, ProductEntity productEntity, Date dateCreated) {
		super();
		ApprovalQueueId = approvalQueueId;
		this.productEntity = productEntity;
		this.dateCreated = dateCreated;
	}


	public long getApprovalQueueId() {
		return ApprovalQueueId;
	}


	public void setApprovalQueueId(long approvalQueueId) {
		ApprovalQueueId = approvalQueueId;
	}


	public ProductEntity getProductEntity() {
		return productEntity;
	}


	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_queue_id")
    private long ApprovalQueueId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

	private  Date dateCreated; {
		
		
	}

    
}
