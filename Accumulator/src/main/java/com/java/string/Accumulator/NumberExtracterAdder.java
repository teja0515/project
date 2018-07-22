package com.java.string.Accumulator;
/**
 * This class handles the functionality to extract numbers based on delimeter
 * and add the numbers
 * 
 * @author Teja
 * 
 */
public class NumberExtracterAdder {
	/**
	 * this method extracts numbers from a given string based on the default
	 * delimiter and line separator or supplied delimiter and line separator and
	 * returns their sum
	 * 
	 * @param numbers
	 * 				the string containing  the numbers to be added
	 * 
	 * @return the sum of the numbers extracted from the provided string
	 * @throws NegativeNumberException
	 * 				the exception if negative numbers are present in the
	 * 				input
	 */
	public int add(String numbers) throws  NegativeNumberException{
		/* Initializing result */
		int result = 0;
		boolean negativeFlag = false;
		String updateNumber = ApplicationConstants.EMPTY_STRING;
		StringBuilder neagativeNumbers = new StringBuilder(
				ApplicationConstants.NEGATIVE_EXCEPTION_MESSAGE);
		/* return 0 for empty string */
		if(numbers.isEmpty()){
			return result;
		}
		
		/* setting default delimiter as , */
		StringBuilder delimiter = new StringBuilder(ApplicationConstants.COMMA);
		
		/* changing delimiter if input contains delimiter */
		if(numbers.startsWith(ApplicationConstants.FORWARD_SLASH)){
			int indexLineSeparator = numbers.indexOf('\n');
			
			String newDelimiter = numbers.substring(2, indexLineSeparator);
			
			/* adding escape characters for star*/
			if(newDelimiter.contains(ApplicationConstants.STAR)){
				newDelimiter = newDelimiter.replaceAll(ApplicationConstants.STAR, 
						ApplicationConstants.BACKWARD_SLASH_STAR);
			}
			/* adding escape characters for plus*/
			if(newDelimiter.contains(ApplicationConstants.PLUS)){
				newDelimiter = newDelimiter.replaceAll(ApplicationConstants.PLUS, 
						ApplicationConstants.BACKWARD_SLASH_PLUS);
			}
			/*
			 * removing the delimiter part from input string to process only
			 * numbers for addition
			 */
			updateNumber = numbers.substring(indexLineSeparator+1).
					replaceAll(newDelimiter, delimiter.toString());
		}else{
			updateNumber = numbers;
		}
		
		/* adding new line delimiter */
		delimiter.append(ApplicationConstants.PIPE).append(
				ApplicationConstants.NEW_LINE);
		
		/* splitting the input string based on delimiter */
		String[] numbersString = updateNumber.split(delimiter.toString());
		
		/* adding extracted numbers */
		for(String singleNumber : numbersString){
			int number = 0;
			if(!singleNumber.isEmpty()){
				number = Integer.parseInt(singleNumber);
			}
			if(!negativeFlag && number <= 1000 && number >= 0){
				result += number;
			}else if(number < 0){
				negativeFlag = true;
				neagativeNumbers = neagativeNumbers.append(number).append(
						ApplicationConstants.COMMA);
			}
		}
		/* In the string contains the negative numbers it throws custom exception*/
		if(negativeFlag){
			throw new NegativeNumberException(new Exception(),
					neagativeNumbers.substring(0, neagativeNumbers.length()-1));
		}
		
		return result;
	}

}
