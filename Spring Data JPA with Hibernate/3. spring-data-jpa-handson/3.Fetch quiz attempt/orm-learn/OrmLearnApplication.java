package com.cognizant.ormlearn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.service.AttemptService;
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner
{
    @Autowired
    private AttemptService attemptService;
    public static void main(String[] args) 
    {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception 
    {
        testGetAttemptDetails();
    }
    public void testGetAttemptDetails() 
    {
        int userId = 1;
        int attemptId = 1;
        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        if (attempt == null) 
        {
            System.out.println("No attempt found!");
            return;
        }
        System.out.println("Username: " + attempt.getUser().getName());
        System.out.println("Attempt Date: " + attempt.getDate());
        System.out.println("Score: " + attempt.getScore());
        System.out.println();
        for (AttemptQuestion aq : attempt.getAttemptQuestions())
        {
            System.out.println("\n" + aq.getQuestion().getText());
            int optionNo = 1;
            for (AttemptOption ao : aq.getAttemptOptions()) 
            {
                String optionText = ao.getOption().getText();
                double score = ao.getOption().getScore();
                boolean selected = ao.isSelected();
                System.out.println(optionNo + ") " +optionText + "   " +score + "   " + selected);
                optionNo++;
            }
        }
    }
}
