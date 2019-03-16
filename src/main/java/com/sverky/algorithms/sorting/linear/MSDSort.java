/**
 * 
 */
package com.sverky.algorithms.sorting.linear;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sverky.algorithms.base.ISort;

/**
 * @author ssiripurapu
 *
 */
public class MSDSort implements ISort {

	public List<String> sort(List<String> inputSeries) {

		int maxLength = getMaxLength(inputSeries);

		String[] sortingStrings = new String[inputSeries.size()];

		int index = 0;

		for (String sortString : inputSeries) {
			sortingStrings[index++] = sortString;
		}

		if (maxLength != 0) {

			inputSeries = Arrays.asList((indexCountingStep(sortingStrings, 0,
					0, sortingStrings.length, maxLength)));

		}

		return inputSeries;
	}

	private String[] indexCountingStep(String[] inputSeries, int keyIndex,
			int low, int high, int maxLength) {

		int[] countingIndexMap = counting(inputSeries, keyIndex, low, high);

		int[] auxIndexMap = getAuxPosition(countingIndexMap);

		inputSeries = getCopyAtAuxPositionByIndex(auxIndexMap, inputSeries,
				keyIndex, low, high);
		int nextlow = low;
		if (maxLength > keyIndex + 1) {
			Character nextCharacter = getKeyIndexCharacter(inputSeries[low],
					(keyIndex));
			for (int i = low; i < high; i++) {
				if (nextCharacter != getKeyIndexCharacter(inputSeries[i],
						keyIndex)) {
					indexCountingStep(inputSeries, keyIndex + 1, nextlow, i,
							maxLength);
					nextlow = i;
					nextCharacter = getKeyIndexCharacter(inputSeries[i],
							(keyIndex));
				}

			}
			indexCountingStep(inputSeries, keyIndex + 1, nextlow, high,
					maxLength);
		}

		return inputSeries;

	}

	private Character getKeyIndexCharacter(String word, int keyIndex) {
		if (StringUtils.isBlank(word) || word.length() <= keyIndex) {
			return null;
		}
		return word.charAt(keyIndex);
	}

	private int[] counting(String[] inputSeries, int keyIndex, int low, int high) {

		int[] indexMap = new int[257];

		for (int i = low; i < high; i++) {

			String processingString = inputSeries[i];

			Character keyValue = getKeyIndexCharacter(processingString,
					keyIndex);

			if (keyValue == null) {
				indexMap[0]++;
			} else
				indexMap[((int) keyValue) + 2]++;
		}

		return indexMap;

	}

	private int getMaxLength(List<String> inputSeries) {
		int maxLength = 0;
		for (String input : inputSeries)
			maxLength = input == null ? 0 : Math.max(input.length(), maxLength);

		return maxLength;

	}

	private int[] getAuxPosition(int[] countMap) {
		for (int i = 0; i < 256; i++) {
			countMap[i + 1] += countMap[i];
		}
		return countMap;
	}

	private String[] getCopyAtAuxPositionByIndex(int[] auxPositions,
			String[] inputSeries, int keyIndex, int low, int high) {

		String[] auxPositionMap = new String[high - low];

		for (int index = low; index < high; index++) {

			Character keyValue = getKeyIndexCharacter(inputSeries[index],
					keyIndex);

			if (keyValue == null) {

				auxPositionMap[auxPositions[0]++] = inputSeries[index];

			} else

				auxPositionMap[auxPositions[(int) (keyValue + 1)]++] = inputSeries[index];

		}


		for (int index = 0; index < auxPositionMap.length; index++) {

			inputSeries[low + index] = auxPositionMap[index];

		}

		return inputSeries;

	}

}