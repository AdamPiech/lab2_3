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

}
