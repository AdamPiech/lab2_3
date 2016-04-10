package edu.iis.mto.similarity;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {

	private SequenceSearcher searcher;
	private SimilarityFinder finder;
	
	@Before 
	public void start() {
		searcher = MyMock.getSequenceSearcher();
		finder = new SimilarityFinder(searcher);
	}
	
	@Test
	public void testFirst() throws Exception {
		int[] firstSeq = {};
		int[] secondSeq = {};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(1.0, result, 0.00001);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(0));
	}
	
	@Test
	public void testSecond()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 2, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(1.0, result, 0.00001);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}

	@Test
	public void testThird()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 4.0/6.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testFourth()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 6, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 3.0/7.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testFifth()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 7, 3, 6, 8};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 2.0/8.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testSixth()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {10, 7, 3, 6, 8};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 1.0/9.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testSeventh()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {10, 7, 9, 6, 8};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertEquals(0.0, result, 0.00001);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testEighth()throws Exception  {
		int[] firstSeq = {1, 2, 3, 4, 5};
		int[] secondSeq = {1, 2, 3};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 3.0/5.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(5));
	}
	
	@Test
	public void testNinth()throws Exception  {
		int[] firstSeq = {1, 2, 3};
		int[] secondSeq = {1, 2, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 3.0/5.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(3));
	}
	
	@Test
	public void testtenth()throws Exception  {
		int[] firstSeq = {1, 10, 3};
		int[] secondSeq = {1, 2, 3, 4, 5};
		double result = finder.calculateJackardSimilarity(firstSeq, secondSeq);
		assertTrue(0 <= result && result <= 2.0/6.0);
		assertThat(MyMock.verify(searcher, searcher.getClass().getMethod("search", int.class, int[].class)), Matchers.is(3));
	}
}
