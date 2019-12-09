package com.capg.currency;

import java.util.Currency;
import java.util.Set;

public class CurrencyExample
{

	public static void main(String[] args)
	{
		Currency currencycode1 = Currency.getInstance("INR");
		Currency currencycode2= Currency.getInstance("USD");
		
		String currencyCode1Symbol = currencycode1.getSymbol();
		String currencyCode2Symbol = currencycode2.getSymbol();
		
		System.out.println("Symbol for INR : " + currencyCode1Symbol);
		System.out.println("Symbol for USD : " + currencyCode2Symbol);
		System.out.println("****************************");
		
		String currencyCode1DisplayName = currencycode1.getDisplayName();
		String currencyCode2DisplayName = currencycode2.getDisplayName();
		
		System.out.println("Display Name for INR : "+currencyCode1DisplayName );
		System.out.println("Display Name for USD : "+currencyCode2DisplayName );
		System.out.println("*****************************************");
		
		Set<Currency> currencies = Currency.getAvailableCurrencies();
		System.out.println(currencies);
		System.out.println("******************");
		
		int currencyCode1DefaultFraction = currencycode1.getDefaultFractionDigits();
		int currencyCode2DefaultFraction = currencycode2.getDefaultFractionDigits();
		
		System.out.println("Default Fraction Digits for INR : " +currencyCode1DefaultFraction );
		System.out.println("Default Fraction Digits for USD  " +currencyCode2DefaultFraction );
		System.out.println("*****************************************");
		
		}

}
