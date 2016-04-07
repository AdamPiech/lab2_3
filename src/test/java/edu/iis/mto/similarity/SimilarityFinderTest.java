package edu.iis.mto.similarity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {

	private SequenceSearcher searcher;
	private SimilarityFinder finder;
	
	@Before 
	public void start() {
		searcher = null; // Do zaimplementowania!!!
		finder = new SimilarityFinder(searcher);
	}
	
	@Test
	public void testFirst() {
		int[] firstSeq = {};
		int[] secondSeq = {};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(1.0, result, 0.00001);
	}
	
	@Test
	public void testSecond() {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 2, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(1.0, result, 0.00001);
	}

	@Test
	public void testThird() {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 4.0/6.0);
	}
	
	@Test
	public void testFourth() {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 6, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 3.0/7.0);
	}
	
	@Test
	public void testFifth() {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 6, 8};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 2.0/8.0);
	}
	
	@Test
	public void testSixth() {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {10, 7, 3, 6, 8};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 1.0/9.0);
	}
}
