package com.awsdev;

import java.io.Serializable;

public class Choice  implements Serializable {

    private String kind;
    private String suggestedPrice;
    private Integer available;
    
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public Integer getAvailable() {
        return available;
    }
    public void setAvailable(Integer available) {
        this.available = available;
    }
    public String getSuggestedPrice() {
        return suggestedPrice;
    }
    public void setSuggestedPrice(String suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }
    
}