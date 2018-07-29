package com.zoezhou.markovtext.controller;

import com.zoezhou.markovtext.exception.InvalidRequestException;
import com.zoezhou.markovtext.model.WordNode;
import com.zoezhou.markovtext.service.MarkovChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

@Controller
public class MarkovTextController {

    private MarkovChainService markovChainService;

    @Autowired
    public MarkovTextController(MarkovChainService markovChainService) {
        this.markovChainService = markovChainService;
    }

    @GetMapping("/")
    public String listForm(Model model)  {
        return "generateForm";
    }

    @PostMapping("/")
    public String handleGenerate(@RequestParam("file")MultipartFile file,
                                   @RequestParam("prefix") String prefix,
                                   @RequestParam("outputSize") Integer outputSize,
                                   RedirectAttributes redirectAttributes) {

        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new InvalidRequestException("Please check the input", e);
        }

        String output = markovChainService.getMarkovChainText(inputStream, prefix, outputSize);

        String msg = prefix + " " + output;
        redirectAttributes.addFlashAttribute("message",
                msg);
        return "redirect:/";
    }

}
