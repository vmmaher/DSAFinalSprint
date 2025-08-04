package com.example.binarytree;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BinaryTreeController {

    @GetMapping("/enter-numbers")
    public String showInputForm() {
        return "index";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(
            @RequestParam("numbers") String numbersInput,
            Model model
    ) {
        List<Integer> numbers = Arrays.stream(numbersInput.split("[,\\s]+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BinarySearchTree bst = new BinarySearchTree();
        for (int num : numbers) {
            bst.insert(num);
        }

        List<Integer> inorder = bst.inOrderTraversal();

        model.addAttribute("numbers", numbers);
        model.addAttribute("inorder", inorder);

        return "result";
    }
}
