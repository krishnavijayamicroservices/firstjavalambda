package com.awsdev;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<GroceryStoreInputModel, GroceryStoreOutputModel> {

    public GroceryStoreOutputModel handleRequest(final GroceryStoreInputModel input,
    final Context context) {
        
    context.getLogger().log("size is ------------"+input.getBins().size());
    
    final GroceryStoreOutputModel grocStoreOutputModel = 
                new GroceryStoreOutputModel();

    List<Choice> choices = input.getBins().stream().map(e -> {
                                    Choice choice = new Choice();
                                    choice.setKind(e.getCategory());
                                    choice.setAvailable(e.getQuantity());
                                    choice.setSuggestedPrice(e.getPrice()+" per "+e.getUnit());
                                    return choice;
            }).collect(Collectors.toList());
            
            grocStoreOutputModel.getChoices().addAll(choices);


        return grocStoreOutputModel;
    }

}
