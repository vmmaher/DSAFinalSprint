package com.example.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BSTApiController {

    @PostMapping("/bst")
    public BinarySearchTree.TreeNode bstJson(@RequestParam("numbers") String numbersInput) {
        List<Integer> numbers = Arrays.stream(numbersInput.split("[,\\s]+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BinarySearchTree bst = new BinarySearchTree();
        for (int num : numbers) {
            bst.insert(num);
        }
        return bst.getRoot();
    }

    @GetMapping("/bst")
    public BinarySearchTree.TreeNode bstJsonGet(@RequestParam("numbers") String numbersInput) {
        return bstJson(numbersInput);
    }
}
