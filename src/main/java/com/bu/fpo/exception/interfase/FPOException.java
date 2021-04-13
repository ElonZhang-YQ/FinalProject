package com.bu.fpo.exception.interfase;

/**
 * This class created on 3/30/2021
 *
 * @author Elon.Zhang
 */
public abstract class FPOException extends Exception{

    private String exceptionId;
    
    private String exceptionName;
    
    private String detailException;
    
    public FPOException() {
    
    }
    
    public FPOException(String exceptionId, String exceptionName, String detailException) {
    
        this.exceptionId = exceptionId;
        this.exceptionName = exceptionName;
        this.detailException = detailException;
    }
    
    public String getExceptionId() {
        
        return exceptionId;
    }
    
    public void setExceptionId(String exceptionId) {
        
        this.exceptionId = exceptionId;
    }
    
    public String getExceptionName() {
        
        return exceptionName;
    }
    
    public void setExceptionName(String exceptionName) {
        
        this.exceptionName = exceptionName;
    }
    
    public String getDetailException() {
        
        return detailException;
    }
    
    public void setDetailException(String detailException) {
        
        this.detailException = detailException;
    }
}
