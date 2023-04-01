package com.awsdev;

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

        final GroceryStoreOutputModel grocStoreOutputModel = 
                new GroceryStoreOutputModel();
 
    try {       
        context.getLogger().log("size is ------------"+input.getBins().size());
    
        if(input.getDepartment() == null || input.getDepartment().length() < 2) {
            throw new RuntimeException("Department should be minimum 2 char");
        }

        List<Choice> choices = input.getBins().stream().map(e -> {
                                    Choice choice = new Choice();
                                    choice.setKind(e.getCategory());
                                    choice.setAvailable(e.getQuantity());
                                    choice.setSuggestedPrice(e.getPrice()+" per "+e.getUnit());
                                    return choice;
            }).collect(Collectors.toList());
            
            grocStoreOutputModel.getChoices().addAll(choices);

        if(choices == null || choices.size() < 1) {
            throw new CustomLambdaException("Exception:000:items can not be empty", null);
        }

    }
    
    catch(CustomLambdaException e) {
        throw e;   
    }
    
    catch(Exception e) {
         new RuntimeException("Exception:001:technical error occured");
    }
    
    return grocStoreOutputModel;
        
    }

}