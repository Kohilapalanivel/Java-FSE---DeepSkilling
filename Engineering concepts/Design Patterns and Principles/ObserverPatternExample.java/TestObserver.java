public class TestObserver 
{
    public static void main(String[] args)
    {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp("User");
        Observer web = new WebApp("Admin");
        market.registerObserver(mobile);
        market.registerObserver(web);
        market.setStockPrice("TCS", 4200);
        market.deregisterObserver(web);
        market.setStockPrice("Infosys", 1800);
    }
}