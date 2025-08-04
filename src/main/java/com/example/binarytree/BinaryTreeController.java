package com.example.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryTreeController {

    @Autowired
    private BSTResultRepository bstResultRepository;

    @GetMapping("/enter-numbers")
    public String showInputForm() {
        return "index";
    }

     @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<BSTResult> previousTrees = bstResultRepository.findAll();
        model.addAttribute("previousTrees", previousTrees);
        return "previous";
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

        // Save to DB
        BSTResult bstResult = new BSTResult(
                numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")),
                inorder.stream().map(String::valueOf).collect(Collectors.joining(", "))
        );
        bstResultRepository.save(bstResult);

        model.addAttribute("numbers", numbers);
        model.addAttribute("inorder", inorder);

        return "result";
    }
}
