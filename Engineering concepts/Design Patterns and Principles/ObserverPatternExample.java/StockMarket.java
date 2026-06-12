import java.util.*;
public class StockMarket implements Stock 
{
	private List<Observer> observers = new ArrayList<>();
	private String stockName;
	private double price;
	public void registerObserver(Observer o) 
	{
		observers.add(o);
	}
	public void deregisterObserver(Observer o) 
	{
		observers.remove(o);
	}
	public void notifyObservers()
	{
		for(Observer o : observers) 
		{
			o.update(stockName, price);
		}
	}
	public void setStockPrice(String stockName, double price) 
	{
		this.stockName = stockName;
		this.price = price;
		System.out.println("\nStock Updated!");
		notifyObservers();
	}
}