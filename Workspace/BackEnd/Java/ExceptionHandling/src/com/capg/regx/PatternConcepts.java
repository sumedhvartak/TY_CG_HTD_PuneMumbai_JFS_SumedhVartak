package com.capg.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternConcepts 
{
	static Pattern pattern;
	static Matcher matcher;
	
	public static void main(String[] args)
	{
		pattern = pattern.compile("\\d");//single digit
		matcher = pattern.matcher("1"); 
		System.out.println("pattern \\d+: "+ matcher.matches());
		
		pattern = pattern.compile("\\d+");//single digit
		matcher = pattern.matcher("19"); 
		System.out.println("pattern \\d+: "+ matcher.matches());
		
		pattern = pattern.compile("\\D");//single but not digit
		matcher = pattern.matcher("a"); 
		System.out.println("pattern \\D: "+ matcher.matches());
		
		pattern = pattern.compile("\\D+");//more than one but not digit
		matcher = pattern.matcher("abc"); 
		System.out.println("pattern \\D+: "+ matcher.matches());
		
		pattern = pattern.compile("\\W");//single but not character
		matcher = pattern.matcher("*"); 
		System.out.println("pattern \\W: "+ matcher.matches());
		
		pattern = pattern.compile("\\W+");//not a single but not character
		matcher = pattern.matcher("^&"); 
		System.out.println("pattern \\W+: "+ matcher.matches());
		
		pattern = pattern.compile("\\w");
		matcher = pattern.matcher("A");
		System.out.println("pattern \\w :" + matcher.matches());
		
		pattern = pattern.compile("\\w+");
		matcher = pattern.matcher("ABC");
		System.out.println("pattern \\w :" + matcher.matches());
		
	}

}
