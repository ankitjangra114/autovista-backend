package com.autovista.autovista_backend.dto;

import java.math.BigDecimal;

public class VariantEmiDto {
    private BigDecimal downPayment;
    private BigDecimal loanAmount;
    private BigDecimal monthlyEmi;
    private int tenureMonths;
    private double interestRate;
    public VariantEmiDto(BigDecimal downPayment, BigDecimal loanAmount, BigDecimal monthlyEmi, int tenureMonths, double interestRate){
        this.downPayment=downPayment;
        this.loanAmount=loanAmount;
        this.monthlyEmi=monthlyEmi;
        this.tenureMonths=tenureMonths;
        this.interestRate=interestRate;
    }
    public BigDecimal getDownPayment(){return downPayment;}
    public BigDecimal getLoanAmount(){return loanAmount;}
    public BigDecimal getMonthlyEmi(){return monthlyEmi;}
    public int getTenureMonths(){return tenureMonths;}
    public double getInterestRate(){return interestRate;}
}
