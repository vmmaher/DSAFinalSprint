package com.example.binarytree;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BSTResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputNumbers;
    private String inOrderTraversal;

    // Constructors
    public BSTResult() {}

    public BSTResult(String inputNumbers, String inOrderTraversal) {
        this.inputNumbers = inputNumbers;
        this.inOrderTraversal = inOrderTraversal;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }
    public String getInOrderTraversal() { return inOrderTraversal; }
    public void setInOrderTraversal(String inOrderTraversal) { this.inOrderTraversal = inOrderTraversal; }
}
