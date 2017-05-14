package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for SubString.
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class SubStringTest {
	/**
	* Test.
	*/
	@Test
	public void searchSubStringInOriginalString() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("huston", "ton");
		boolean expect = true;
	assertThat(result, is(expect));
	}
	/**
	* Test2.
	*/
	@Test
	public void searchSubStringInOriginalString2() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("hustory", "ton");
		boolean expect = false;
	assertThat(result, is(expect));
	}
	/**
	* Test3.
	*/
	@Test
	public void searchSubStringInOriginalString3() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("husto", "ton");
		boolean expect = false;
	assertThat(result, is(expect));
	}
	/**
	* Test4.
	*/
	@Test
	public void searchSubStringInOriginalString4() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("hutson", "ton");
		boolean expect = false;
	assertThat(result, is(expect));
	}
	/**
	* Test5.
	*/
	@Test
	public void searchSubStringInOriginalString5() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("hustton", "ton");
		boolean expect = true;
	assertThat(result, is(expect));
	}
	/**
	* Test6.
	*/
	@Test
	public void searchSubStringInOriginalString6() {
		SubString subSt = new SubString();
		boolean result = subSt.contains("hu", "ton");
		boolean expect = false;
	assertThat(result, is(expect));
	}
}