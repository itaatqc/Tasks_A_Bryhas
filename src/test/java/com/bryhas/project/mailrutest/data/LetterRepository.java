package com.bryhas.project.mailrutest.data;

/**
 * @author Andrew
 *
 */

public class LetterRepository {

	public static ILetter getTestLetter() {
		return Letter.get()
			.setLetterTitle("Weather")
			.build();
	}

}
