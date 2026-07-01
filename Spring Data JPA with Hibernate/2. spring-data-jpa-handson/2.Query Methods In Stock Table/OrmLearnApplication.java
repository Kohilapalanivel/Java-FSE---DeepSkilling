package com.cognizant.ormlearn;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
@SpringBootApplication
public class OrmLearnApplication 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static StockRepository stockRepository;
    public static void main(String[] args) 
    {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);
        testFacebookStocks();
        testGoogleStocks();
        testTop3Volume(); 
        testNetflixLowest();
    }
    private static void testFacebookStocks() 
    {
        LOGGER.info("Facebook Stock Details");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB",LocalDate.of(2019, 9, 1),LocalDate.of(2019, 9, 30));
        stocks.forEach(System.out::println);
    }
    private static void testGoogleStocks() 
    {
        LOGGER.info("Google Stock Details");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL",1250);
        stocks.forEach(System.out::println);
    }
    private static void testTop3Volume()
     {
        LOGGER.info("Top 3 Highest Volume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(System.out::println);
    }
    private static void testNetflixLowest() 
    {
        LOGGER.info("Lowest Netflix Stocks");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(System.out::println);
    }
}
