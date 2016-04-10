package edu.iis.mto.similarity;

import java.lang.reflect.Method;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MyMock {

	public static SequenceSearcher getSequenceSearcher() {
		return new SequenceSearcherMock();
	}

//	public static void verify(Object object, Method method, int howMuch) throws Exception {
//		assert (howMuch == object.getClass().getDeclaredField(method.getName()).getInt(object));
//	}
	
	public static int verify(Object object, Method method) {
		try {
			return object.getClass().getDeclaredField(method.getName()).getInt(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}

class SearchResultMock implements SearchResult {

	private boolean isFound;
	private int position;

	SearchResultMock(boolean isFound, int position) {
		this.isFound = isFound;
		this.position = position;
	}

	public boolean isFound() {
		return isFound;
	}

	public int getPosition() {
		return position;
	}

}

class SequenceSearcherMock implements SequenceSearcher {
	int search = 0;

	public SearchResult search(int key, int[] seq) {
		search++;
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] == key) {
				return new SearchResultMock(true, i);
			}
		}
		return new SearchResultMock(false, -1);
	}
}