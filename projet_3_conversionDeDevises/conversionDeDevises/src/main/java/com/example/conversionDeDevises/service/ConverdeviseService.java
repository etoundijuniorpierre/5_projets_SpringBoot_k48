package com.example.conversionDeDevises.service;

import com.example.conversionDeDevises.model.ConvertResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@Service
public class ConverdeviseService {
    private final RestTemplate restTemplate;

    private static final Set<String> CURRENCY_CODES = Set.of(
            "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
            "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
            "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
            "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP",
            "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS",
            "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
            "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD",
            "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT",
            "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
            "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN",
            "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
            "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
            "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP",
            "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
            "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND",
            "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW",
            "ZWL" );

    public ConverdeviseService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Object convertCurrency(String fromCurrency, String toCurrency, double amount) {

        if (!isValidCurrency(fromCurrency)) {
            return createErrorResponse("La devise source '" + fromCurrency + "' n'est pas valide...veuillez visiter https://www.iban.com/currency-codes");
        }

        if (!isValidCurrency(toCurrency)) {
            return createErrorResponse("La devise cible '" + toCurrency + "' n'est pas valide...veuillez visiter https://www.iban.com/currency-codes");
        }

        if (amount <= 0) {
            return createErrorResponse("Le montant doit être supérieur à zéro");
        }

        // Appel à l'API externe
        try {
            String apiUrl = "https://v6.exchangerate-api.com/v6/a87e3d3f3fda78377fe19fbd/pair/{from}/{to}/{amount}";

            URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .buildAndExpand(fromCurrency, toCurrency, amount)
                    .toUri();

            // Appel à l'API et récupération de la réponse
            ResponseEntity<ConvertResponse> response = restTemplate.getForEntity(uri, ConvertResponse.class);

            // Vérifier que la réponse obtenue n'est pas null
            if (response.getBody() == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erreur : Réponse vide de l'API de conversion");
            }

            ConvertResponse apiResponse = response.getBody();

            // Retourner un ResponseEntity contenant l'objet ConvertResponse
            return ResponseEntity.ok(new ConvertResponse(
                    apiResponse.getBase_code(),
                    apiResponse.getTarget_code(),
                    apiResponse.getConversion_rate(),
                    amount,
                    apiResponse.getConversion_result()
            ));

        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la conversion : " + e.getMessage());
        }
    }


    private boolean isValidCurrency(String currencyCode) {
        return currencyCode != null
                && currencyCode.length() == 3
                && CURRENCY_CODES.contains(currencyCode.toUpperCase());
    }

    private ResponseEntity<String> createErrorResponse(String message) {
        return ResponseEntity.badRequest()
                .body("{\"error\": \"" + message + "\"}");
    }


}




