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
	public void test() {
		int[] firstSeq = {};
		int[] secondSeq = {};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(1.0, result, 0.00001);
	}

}
