package com.awsdev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroceryStoreInputModel implements Serializable {
    
    private String department;
    private List<String> categories = new ArrayList<>();
    private List<Bin> bins = new ArrayList<>();
    
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    public List<Bin> getBins() {
        return bins;
    }
    public void setBins(List<Bin> bins) {
        this.bins = bins;
    }
    
    
}