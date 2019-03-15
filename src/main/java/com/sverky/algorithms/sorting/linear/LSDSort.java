/**
 * 
 */
package com.sverky.algorithms.sorting.linear;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sverky.algorithms.base.ISort;

/**
 * @author ssiripurapu
 *
 */
public class LSDSort implements ISort {
	
	
	public List<String> sort(List<String> inputSeries) {

		int maxLength = getMaxLength(inputSeries);

		if (maxLength != 0) {

			for (int indexDigit = maxLength - 1; indexDigit >= 0; indexDigit++) {

				inputSeries = indexCountingStep(inputSeries, indexDigit);

			}

		}

		return inputSeries;
	}

	private List<String> indexCountingStep(List<String> inputSeries,
			int keyIndex) {

		int[] countingIndexMap = counting(inputSeries, keyIndex);

		int[] auxIndexMap = getAuxPosition(countingIndexMap);

		inputSeries = getCopyAtAuxPositionByIndex(auxIndexMap, inputSeries,
				keyIndex);

		return inputSeries;

	}

	private Character getKeyIndexCharacter(String word, int keyIndex) {

		if (StringUtils.isBlank(word) || word.length() <= keyIndex) {
			return null;
		}

		return word.charAt(keyIndex);

	}

	private int[] counting(List<String> inputSeries, int keyIndex) {

		int[] indexMap = new int[257];

		for (String processingString : inputSeries) {

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

	private List<String> getCopyAtAuxPositionByIndex(int[] auxPositions,
			List<String> inputSeries, int keyIndex) {

		String[] auxPositionMap = new String[inputSeries.size()];

		for (int index = 0; index < inputSeries.size(); index++) {

			Character keyValue = getKeyIndexCharacter(inputSeries.get(index),
					keyIndex);

			if (keyValue == null) {

				auxPositionMap[auxPositions[0]++] = inputSeries.get(index);

			} else

				auxPositionMap[auxPositions[(int) (keyValue + 1)]++] = inputSeries
						.get(index);

		}

		inputSeries = new ArrayList<String>();

		for (int index = 0; index < auxPositionMap.length; index++) {

			inputSeries.add(auxPositionMap[index]);

		}

		return inputSeries;

	}

	
}
