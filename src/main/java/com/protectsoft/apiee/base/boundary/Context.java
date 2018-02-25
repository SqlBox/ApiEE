package com.protectsoft.apiee.base.boundary;

import com.protectsoft.apiee.base.entities.BaseEntity;
import com.protectsoft.apiee.core.masterdetail.MasterDetail;
import com.protectsoft.apiee.core.masterdetail.MasterDetailFunction;
import com.protectsoft.apiee.core.masterdetail.MoveOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Avraam Piperidis
 * @param <T>
 */
public abstract class Context<T extends BaseEntity> implements IContext<T> {

    private final List<Pair<MasterDetail,Api<T>>> childs;
    private Api<T> parent;
    
    public Context() {     
        this.childs = new ArrayList<>();
        this.setParent();
    }
    
    abstract void setParent();
    
    @Override
    public abstract Api<T> getService();
    
    @Override
    public Api<T> getParent() {
        return parent;
    }
    
    
    <M extends BaseEntity> void setParent(Api<M> parent) {
        this.setParent(null,(Api<T>) parent);
    }
    
    
    @Override
    public void addChild(Api<T> child) {
        this.addChild(null,child);    
    }
    
    
    public <D extends BaseEntity> void addChildDetail(Class<T> masterClass, Class<D> detailClass, MasterDetailFunction<T, D> masterDetailFunction, Api<D> detailService, MoveOption moveOption) {
        this.addChild(new MasterDetail<>(masterClass,detailClass,masterDetailFunction,moveOption),detailService);
    }
    
    
    /**
     * @return the child services
     */
    @Override
    public List<Pair<MasterDetail,Api<T>>> getChilds() {
        return childs;
    }

    
    private <D extends BaseEntity> void addChild(MasterDetail<T,D> mDetail,Api<D> child) {
        child.setParent((Api<D>)this);
        if(!this.childs.stream().anyMatch(x->Objects.equals(x.getApi(),child))) {
            this.childs.add(new Pair(mDetail,child));
        }     
    }
    
    <D extends BaseEntity> void setParent(MasterDetail<T,D> mDetail,Api<T> parent) {
         this.parent = parent;
    }
    
}
