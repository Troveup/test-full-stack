package com.troveup.test.controllers;

import com.troveup.test.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Index controller, responsible for the business logic behind the various views.
 */
@Controller
public class IndexController {

    //Make sure we have a pointer to the application's context.  This way we can grab the Environment object
    //for the Item Builder
    @Autowired
    ApplicationContext ctx;

    /**
     * Default controller for the "/" GET request URL.  Retrieves a list of 9 "All" category items and places them
     * in the model under the "items" key for retrieval.  Will also include the
     * "pageTitle" key with the page title specified.
     *
     * @return ModelAndView object containing all necessary business logic data for view implementation
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView all()
    {
        ModelAndView rval = new ModelAndView();

        //Build the list of items and add them to the model
        List<Item> items = Item.getBuilder(Item.ITEM_TYPE.ALL, ctx.getEnvironment()).buildItemList();
        rval.addObject("items", items);

        //Add the page title
        rval.addObject("pageTitle", "All");

        //Set the view to all.jsp
        rval.setViewName("all");

        return rval;
    }

    /**
     * Controller responsible for handling AJAX requests for additional card data.  Will simply return an additional
     * set of card data, similar to what was originally passed, so that the view can be populated with more cards.
     *
     * @param cardtype Type of card to request.  Can be any of, "all", "bracelets", "necklaces", or "rings".
     * @return JSON response with a list of 9 Items.
     */
    @RequestMapping(value = "/cards/{cardtype}", method = {RequestMethod.GET}, headers="Accept=application/json")
    @ResponseBody
    public List<Item> getAdditionalCards(@PathVariable("cardtype") String cardtype)
    {
        Item.ITEM_TYPE cardRequestType;

        //Determine the request type
        if (cardtype.equals(Item.ITEM_TYPE.ALL.toString()))
            cardRequestType = Item.ITEM_TYPE.ALL;
        else if (cardtype.equals(Item.ITEM_TYPE.BRACELETS.toString()))
            cardRequestType = Item.ITEM_TYPE.BRACELETS;
        else if (cardtype.equals(Item.ITEM_TYPE.NECKLACES.toString()))
            cardRequestType = Item.ITEM_TYPE.NECKLACES;
        else
            cardRequestType = Item.ITEM_TYPE.RINGS;

        //Build the cards and return them
        List<Item> items = Item.getBuilder(cardRequestType, ctx.getEnvironment()).buildItemList();

        return items;
    }
}
