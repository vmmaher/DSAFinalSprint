package com.example.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class BSTResultTest {
    
    @Test
    void testBSTResultCreation() {
        BSTResult result = new BSTResult("1,2,3", "1,2,3");
        
        assertEquals("1,2,3", result.getInputNumbers());
        assertEquals("1,2,3", result.getInOrderTraversal());
        assertNull(result.getId());
    }
    
    @Test
    void testBSTResultDefaultConstructor() {
        BSTResult result = new BSTResult();
        
        assertNull(result.getInputNumbers());
        assertNull(result.getInOrderTraversal());
        assertNull(result.getId());
    }
    
    @Test
    void testBSTResultSetters() {
        BSTResult result = new BSTResult();
        result.setInputNumbers("5,3,7");
        result.setInOrderTraversal("3,5,7");
        
        assertEquals("5,3,7", result.getInputNumbers());
        assertEquals("3,5,7", result.getInOrderTraversal());
    }
}