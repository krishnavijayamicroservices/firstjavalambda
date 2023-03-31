package com.awsdev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroceryStoreOutputModel implements Serializable {
    
    private List<Choice> choices = new ArrayList<>();

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }


}
