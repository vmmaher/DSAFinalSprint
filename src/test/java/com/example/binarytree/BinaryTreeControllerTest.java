package com.example.binarytree;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BinaryTreeController.class)
public class BinaryTreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BSTResultRepository bstResultRepository;

    @Test
    void testShowInputForm() throws Exception {
        mockMvc.perform(get("/enter-numbers"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testProcessNumbers() throws Exception {
        when(bstResultRepository.save(any(BSTResult.class))).thenReturn(new BSTResult());
        
        mockMvc.perform(post("/process-numbers")
                .param("numbers", "5,3,7"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"));
    }
}