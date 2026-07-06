package com.cognizant.springlearn.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testUpdateEmployeeValidation() throws Exception 
    {
        String json = """
        {
            "id":1,
            "name":"",
            "salary":50000,
            "permanent":true,
            "dateOfBirth":"15/08/2000",
            "department":{
                "id":1,
                "name":"IT"
            },
            "skills":[
                {
                    "id":1,
                    "name":"Java"
                }
            ]
        }
        """;

        mockMvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest());
    }
}
