package com.bryhas.project.mailrutest.data;

interface ILetterTitle {
	IBuildLetter setLetterTitle(String letterTitle);
}

interface IBuildLetter {
	ILetter build();
}

/**
 * @author Andrew
 *
 */

public class Letter implements ILetterTitle, IBuildLetter, ILetter  {
	private String letterTitle;
		
	private Letter() {
	}

	private Letter(String letterTitle) {
		this.letterTitle = letterTitle;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public static ILetterTitle get() {
		return new Letter();
	}
	
	public IBuildLetter setLetterTitle(String letterTitle) {
		this.letterTitle = letterTitle;
		return this;
	}

	public ILetter build() {
		return this;
	}

	// - - - - - - - - - - - - - - - - - - - -

	public String getLetterTitle() {
		return letterTitle;
	}

}