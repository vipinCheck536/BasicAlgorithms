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
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> generatedStrings = sortHelper.generateRandomizedStrings(4, 4);
		
		 List<String> copy = new ArrayList<String>(generatedStrings);
		 
		 LSDSort sortingTechnique = new LSDSort();
		 
		 generatedStrings = sortingTechnique.sort(generatedStrings);
		 
		 sortHelper.validateStringSorts(copy, generatedStrings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, generatedStrings), true);
		 
	 }
	
	
}
