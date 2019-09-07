package com.protectsoft.apiee.masterdetail;

import com.protectsoft.apiee.entities.BaseEntity;

/**
 *
 * @author Abraham Piperidis
 * @param <M>
 * @param <D>
 */
public interface OneToOneFunction<M extends BaseEntity,D extends BaseEntity> extends MasterDetailFunction<M,D> {
    
    @Override
    D getDetail(M master);
    
    @Override
    void setDetail(M master,D detail);

    @Override
    void setMaster(M master,D detail);
}
