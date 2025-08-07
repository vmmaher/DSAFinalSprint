package com.example.binarytree;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BSTApiController.class)
public class BSTApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostBst() throws Exception {
        mockMvc.perform(post("/api/bst")
                .param("numbers", "5,3,7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.val", is(5)))
                .andExpect(jsonPath("$.left.val", is(3)))
                .andExpect(jsonPath("$.right.val", is(7)));
    }

    @Test
    public void testGetBst() throws Exception {
        mockMvc.perform(get("/api/bst")
                .param("numbers", "4,2,6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.val", is(4)));
    }
}