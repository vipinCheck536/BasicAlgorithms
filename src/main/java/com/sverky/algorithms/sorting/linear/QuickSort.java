package com.sverky.algorithms.sorting.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.sverky.algorithms.base.ISort;

public class QuickSort implements ISort {

	public List<String> sort(List<String> inputSeries) {

		String[] sortingStrings = new String[inputSeries.size()];

		int index = 0;

		for (String sortString : inputSeries) {
			sortingStrings[index++] = sortString;
		}
		quickSort(sortingStrings,0,sortingStrings.length-1);

		return Arrays.asList(sortingStrings);
	}

	public String[] quickSort(String[] sortingStrings, int low, int high) {

		if (low >= high)
			return sortingStrings;

		int pivotIndex = getRandomPivot(sortingStrings, low, high);

		int finalPivotLocation = quick3WayPartition(sortingStrings, low, high,
				pivotIndex);

		quickSort(sortingStrings, low, finalPivotLocation - 1);

		quickSort(sortingStrings, finalPivotLocation + 1, high);

		return sortingStrings;

	}

	private int quick3WayPartition(String[] sortingStrings, int low, int high,
			int pivotIndex) {
		
		String pivotData = sortingStrings[pivotIndex];
		
		sortingStrings[pivotIndex] = sortingStrings[low];
		
		sortingStrings[low] = pivotData;
		
		pivotIndex = low;
		
		while(low<=high){
			if(sortingStrings[low].compareTo(pivotData) < 0){
				swap(sortingStrings,low,pivotIndex);
				low++;
				pivotIndex++;
			}
			else if(sortingStrings[high].compareTo(pivotData) < 0){
				swap(sortingStrings,low,high);
				high--;
			}
			else {
				high--;
				low++;
			}				
		}
		
		return pivotIndex;

	}

	private void swap(String[] sortingStrings, int low, int pivotIndex) {
		String lowData =  sortingStrings[low];
		sortingStrings[low]=sortingStrings[pivotIndex];
		sortingStrings[pivotIndex]=lowData;
	}

	private int getRandomPivot(String[] sortingStrings, int low, int high) {
		Random rand = new Random();
		int window = high - low;
		List<String> list = new ArrayList<String>();
		HashMap<String, Integer> randoms = new HashMap<String, Integer>();
		for (int i = 0; i < 3; i++) {
			int index = rand.nextInt(low+window);
			list.add(sortingStrings[index]);
			randoms.put(sortingStrings[index], index);
		}
		Collections.sort(list);
		return randoms.get(list.get(1));
	}

}
