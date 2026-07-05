package com.tamara.bankappli.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tamara.bankappli.enums.AccountType;
import com.tamara.bankappli.enums.InvestmentType;

import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "INVESTMENT")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "name", length = 30)
    private String name; // e.g., "CGI Group Inc" or "S&P 500 Index Fund"

    @Column(name = "symbol", length = 10)
    private String symbol; // e.g., "GIB.A", "RY", "TD"
    
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "investment_type")
	private InvestmentType type;

    @Column(name = "market_value")
    private Float marketValue;

    public Investment() {}

    public Investment(String name, String symbol, InvestmentType type, Float marketValue) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
        this.marketValue = marketValue;
    }

    // Getters and Setters
    public Long getId() { return ID; }
    public void setId(Long id) { this.ID = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public InvestmentType getType() { return type; }
    public void setType(InvestmentType type) { this.type = type; }

    public Float getMarketValue() { return marketValue; }
    public void setMarketValue(Float marketValue) { this.marketValue = marketValue; }

    @Override
    public String toString() {
        return "Investment [id=" + ID + ", name=" + name + ", symbol=" + symbol + ", type=" + type + ", marketValue=" + marketValue + "]";
    }
}
