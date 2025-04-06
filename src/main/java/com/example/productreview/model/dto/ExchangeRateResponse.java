package com.example.productreview.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {
    @JsonProperty("broj_tecajnice")
    private String exchangeRateNumber;

    @JsonProperty("datum_primjene")
    private String applicationDate;

    @JsonProperty("drzava")
    private String country;

    @JsonProperty("drzava_iso")
    private String countryIso;

    @JsonProperty("sifra_valute")
    private String currencyCode;

    @JsonProperty("valuta")
    private String currency;

    @JsonProperty("kupovni_tecaj")
    private String buyRate;

    @JsonProperty("srednji_tecaj")
    private String middleRate;

    @JsonProperty("prodajni_tecaj")
    private String sellRate;
}