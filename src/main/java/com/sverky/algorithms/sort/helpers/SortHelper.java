package com.sverky.algorithms.sort.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortHelper {

	public List<String> generateRandomizedStrings(int numberOfElements,
			int maxSizeElement) {

		List<String> generatedList = new ArrayList<String>();

		for (int elementCounter = 0; elementCounter < numberOfElements; elementCounter++) {

			StringBuilder elementBuilder = new StringBuilder();

			// Without proper seed for Phase 1
			Random randomElementGenerator = new Random();

			for (int indexCounter = 0; indexCounter < maxSizeElement; indexCounter++) {

				elementBuilder.append((char) (randomElementGenerator
						.nextInt(256)));

			}

			generatedList.add(elementBuilder.toString());

		}

		return generatedList;

	}

	public boolean validateStringSorts(List<String> generatedList,
			List<String> sortedList) {

		if (generatedList != null && sortedList != null
				&& generatedList.size() == sortedList.size()) {

			Collections.sort(generatedList);

			for (int i = 0; i < generatedList.size(); i++) {

				if (!generatedList.get(i).equals(sortedList.get(i)))
					return Boolean.FALSE;

			}

			return Boolean.TRUE;

		}

		return Boolean.FALSE;

	}

}
