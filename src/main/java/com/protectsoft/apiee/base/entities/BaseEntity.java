
package com.protectsoft.apiee.base.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Ancestor of every <i>Entity</i> in the Application.
 */
public abstract class BaseEntity implements Serializable  {

    protected BaseEntity() {
    }
    
    public abstract  Long getId();
    
    
    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null)  
            return false;  
        if (!(object instanceof BaseEntity && object.getClass().equals(getClass()))) {
            return false;
        }

        BaseEntity other = (BaseEntity)object;
        return this.getId() != null && this.getId().equals(other.getId());
    }

    @Override
    public final int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(getId());
        return hash;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + "[ id=" + getId() + " ]";
    }
    
    public Set<ConstraintViolation<BaseEntity>> getConstraintVaiolations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = (Validator) factory.getValidator();
        return validator.validate(this);
    }
    
    public boolean isValid() {
        return true;
    }
    
    protected Long getFieldId(BaseEntity field) {
        return null!=field ? field.getId() : null;
    }
    
}
