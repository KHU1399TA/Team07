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
    SUCCESSADDUSER(" [ Adduser done ]"),
    SUCCESSADDRESTAURANT(" [ Addrestaurant done ]"),
    SUCCESSSHOW(" [ Show done ]"),
    SUCCESSEDIT(" [ Edit done ]"),
    SUCCESSREMOVE(" [ Remove done ]"),
    USERNAME_NOT_FOUND(" [ Wrong username or password, try again ]"),
    RESTAURANT_NOT_FOUND(" [ Restaurant not found, try again ]"),
    USERNAME_ALREADY_EXIST(" [ This username is already used, try again ]"),
    RESTAURANTNAME_ALREADY_EXIST(" [ This restaurantname is already used, try again ]"),
    //FOOD_NOT_FOUND(""),
    //FOOD_ALREADY_EXIST(""),
    //ORDER_NOT_FOUND(""),
    //ORDER_ALREADY_EXIST(""),
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