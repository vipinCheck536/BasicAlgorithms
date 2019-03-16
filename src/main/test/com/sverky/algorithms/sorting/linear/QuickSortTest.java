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

public class QuickSortTest  {
		
//	 @Test
//	 public void sortOneElementTest() {
//		 
//		 sortTestHelper(1,1);
//		 
//	 }		 
	 
	 @Test
     public void sortQuickSort() {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> strings = new ArrayList<String>();
		 
		 strings.add("5");
		 strings.add("1");
		 strings.add("2");
		 strings.add("4");
		 strings.add("3");
		
		
		 List<String> copy = new ArrayList<String>(strings);
		 
		 QuickSort sortingTechnique = new QuickSort();
		 
		 strings = sortingTechnique.sort(strings);
		 
		 sortHelper.validateStringSorts(copy, strings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, strings), true);
		 
	 }
	 
	 
	 public void sortTestHelper(int maxSize,int numberOfElements) {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> generatedStrings = sortHelper.generateRandomizedStrings(maxSize, numberOfElements);
		
		 List<String> copy = new ArrayList<String>(generatedStrings);
		 
		 QuickSort sortingTechnique = new QuickSort();
		 
		 generatedStrings = sortingTechnique.sort(generatedStrings);
		 
		 sortHelper.validateStringSorts(copy, generatedStrings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, generatedStrings), true);
		 
	 }
	
	
}
