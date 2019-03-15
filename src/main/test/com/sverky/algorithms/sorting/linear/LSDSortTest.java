/**
 * 
 */
package com.sverky.algorithms.sorting.linear;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sverky.algorithms.sort.helpers.SortHelper;


/**
 * @author ssiripurapu
 *
 */

public class LSDSortTest  {
		
	 @Test
	 public void sortPrimaryTest() {
		 
		 sortTestHelper(5,5);
	 
	 }	
	 
	 
	 @Test
	 public void sortOneElementTest() {
		 
		 sortTestHelper(1,1);
		 
	 }		 
	 
	 @Test
	 public void sortLargeElementTest() {
		 
		 sortTestHelper(10,10);
		 
	 }	
	 
	 @Test
	 public void sortNullTest() {
		 
		 LSDSort sortingTechnique = new LSDSort();
		 
		 List<String> generatedStrings = sortingTechnique.sort(null);
		 
		 Assert.assertNull(generatedStrings);
		 
	 }	

	 @Test
     public void sortLSD() {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> strings = new ArrayList<String>();
		 
		 strings.add("abc");
		 strings.add("bbc");
		 strings.add("bsa");
		 strings.add("bad");
		
		 List<String> copy = new ArrayList<String>(strings);
		 
		 LSDSort sortingTechnique = new LSDSort();
		 
		 strings = sortingTechnique.sort(strings);
		 
		 sortHelper.validateStringSorts(copy, strings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, strings), true);
		 
	 }
	 
	 
	 public void sortTestHelper(int maxSize,int numberOfElements) {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> generatedStrings = sortHelper.generateRandomizedStrings(maxSize, numberOfElements);
		
		 List<String> copy = new ArrayList<String>(generatedStrings);
		 
		 LSDSort sortingTechnique = new LSDSort();
		 
		 generatedStrings = sortingTechnique.sort(generatedStrings);
		 
		 sortHelper.validateStringSorts(copy, generatedStrings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, generatedStrings), true);
		 
	 }
	
	
}
