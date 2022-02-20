package test.com.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.com.domain.NameEditor;

class NameEditorTest {
	NameEditor nameEditor = new NameEditor();

	private void assertNameList(String[] names, String[] expectedList){
		String[] result = nameEditor.makeList(names);
		assertEquals(Arrays.toString(expectedList), Arrays.toString(result));
	}

	@Test
	void nameLengthOverFive(){
		String[] expectedList = {"12345", "abcde", "phils"};
		String[] names = {"1234567", "abcdefghij", "philsogood"};
		assertNameList(names, expectedList);
	}

	@Test
	void nameLengthBelowFive() {
		String[] expectedList = {"  a  ", " jk  ", " ivy ", "abcd "};
		String[] names = {"a", "jk", "ivy", "abcd"};
		assertNameList(names, expectedList);
	}

	@Test
	void emptyName() {
		String[] expectedList = {"     "};
		String[] names = {""};
		assertNameList(names, expectedList);
	}

	@Test
	void nameLengthFive() {
		String[] expectedList = {"honux", "crong", "12345"};
		String[] names = {"honux", "crong", "12345"};
		assertNameList(names, expectedList);
	}
}