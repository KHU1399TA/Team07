package main;

enum AccessLevel{

    MANAGER("manager"),
    CASHIER("cashier"),
    CHEF("chef"),
    DELIVERYMAN("deliveryman"),
    CLIENT("client"),
    NOTHING("nothing");
    
    private String accesslevel;

    AccessLevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    @Override
    public String toString() {
        return " Access level = " + accesslevel;
    }
}

enum Typeofrestaurant{
    
    FASTFOOD("fast food"),
    FASTCASUAL("Fast Casual"),
    CASUALDINING("Casual Dining"),
    CASUALPREMIUM("Casual Premium"),
    FINEDINING("Fine-Dining"),
    NOTHING("nothing");
    
    private String typeofrestaurant;

    Typeofrestaurant(String typeofrestaurant) {
        this.typeofrestaurant = typeofrestaurant;
    }

    @Override
    public String toString() {
        return " Type of restaurant = " + typeofrestaurant;
    }
}

enum ActionResult{
    
    SUCCESSLOGIN(" [ Login done ]"),
    SUCCESSADD(" [ Add done ]"),
    SUCCESSSHOW(" [ Show done ]"),
    SUCCESSEDIT(" [ Edit done ]"),
    SUCCESSREMOVE(" [ Remove done ]"),
    SUCCESSMADE(" [ Cook done ]"),
    SUCCESSCONFIRMED(" [ Cook done ]"),
    SUCCESSCOOKED(" [ Cook done ]"),
    SUCCESSDELIVERED(" [ Cook done ]"),
    
    USERNAME_NOT_FOUND(" [ Wrong username or password, try again ]"),
    USERNAME_ALREADY_EXIST(" [ This username is already used, try again ]"),
    
    RESTAURANT_NOT_FOUND(" [ Wrong restaurant's name or password, try again ]"),
    RESTAURANTNAME_ALREADY_EXIST(" [ This restaurantname is already used, try again ]"),
    
    FOOD_NOT_FOUND(" [ Food not found, try again ]"),
    FOOD_ALREADY_EXIST(" [ This food is already used, try again ]"),
    FOOD_NOT_AVAILABLE(" [ This food is not available, try again ]"),
    
    ORDER_NOT_FOUND(" [ Oeder not found, try again ]"),
    ORDER_ALREADY_EXIST(" [ This order's id is already used, try again ]"),
    
    UNKNOWN_ERROR(" Error: [ please try again ]");
    
    private String actionresult;

    ActionResult(String actionresult) {
        this.actionresult = actionresult;
    }

    @Override
    public String toString() {
        return actionresult;
    }    
}

enum OrderState {
    
    MADE(" [ Made done ]"),
    CONFIRMED(" [ Confirmed done ]"),
    COOKED(" [ Cook done ]"),
    DELIVERED(" [ Deliver done ]");
    
    private String orderstate;
    
    OrderState(String orderstate) {
        this.orderstate = orderstate;
    }
    
    @Override
    public String toString() {
        return orderstate;
    } 
}