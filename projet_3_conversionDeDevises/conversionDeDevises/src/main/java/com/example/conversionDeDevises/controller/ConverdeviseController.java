package com.example.conversionDeDevises.controller;

import com.example.conversionDeDevises.model.ConvertResponse;
import com.example.conversionDeDevises.service.ConverdeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convertDevise")
public class ConverdeviseController {
    @Autowired
    private ConverdeviseService converdeviseService;

    @GetMapping("/convert/{fromCurrency}/{toCurrency}/{amount}")
    public ResponseEntity<ConvertResponse> convertDevise(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @PathVariable double amount) {
        return (ResponseEntity<ConvertResponse>) converdeviseService.convertCurrency(fromCurrency, toCurrency, amount);
    }
}
