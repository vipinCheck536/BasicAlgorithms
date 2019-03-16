package com.sverky.algorithms.sorting.linear;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sverky.algorithms.sort.helpers.SortHelper;

public class MSDSortTechnique {
	
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
		 
		 sortTestHelper(10000,1000);
		 
	 }	
	 
	 @Test
     public void sortMSD() {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> strings = new ArrayList<String>();
		 
		 strings.add("abc");
		 strings.add("bbc");
		 strings.add("aba");
		 strings.add("bad");
		
		 List<String> copy = new ArrayList<String>(strings);
		 
		 MSDSort sortingTechnique = new MSDSort();
		 
		 strings = sortingTechnique.sort(strings);
		 
		 sortHelper.validateStringSorts(copy, strings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, strings), true);
		 
	 }
	 
	 
	 
	 @Test
	 public void sortNullTest() {
		 
		 MSDSort sortingTechnique = new MSDSort();
		 
		 List<String> generatedStrings = sortingTechnique.sort(null);
		 
		 Assert.assertNull(generatedStrings);
		 
	 }	

	 
	 public void sortTestHelper(int maxSize,int numberOfElements) {
		 
		 SortHelper sortHelper = new SortHelper();
		 
		 List<String> generatedStrings = sortHelper.generateRandomizedStrings(maxSize, numberOfElements);
		
		 List<String> copy = new ArrayList<String>(generatedStrings);
		 
		 MSDSort sortingTechnique = new MSDSort();
		 
		 generatedStrings = sortingTechnique.sort(generatedStrings);
		 
		 sortHelper.validateStringSorts(copy, generatedStrings);
		 
		 Assert.assertEquals(sortHelper.validateStringSorts(copy, generatedStrings), true);
		 
	 }

}
