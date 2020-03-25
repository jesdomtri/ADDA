package Test;



import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modelado.ConjuntoEnteros;


public class TestConjuntoEnteros {

	Set<Integer> ce;

	@Before
	public void setUp() throws Exception {
		ce = new ConjuntoEnteros(0, 10);
		ce.add(0);
		ce.add(2);
		ce.add(3);
		ce.add(9);
	}

	@After
	public void tearDown() throws Exception {
		ce = null;
	}

	@Test
	public void testAdd() {
		ce.add(4);
		assertTrue("Error en el metodo add, no se encuentra el elemento",
				ce.contains(4) && ce.size() == 5);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAdd2() {
		ce.add(10);
		assertTrue(
				"Error en el metodo add, ha insertado un elemento fuera de rango",
				!ce.contains(10) && ce.size() == 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAdd3() {
		ce.add(11);
		assertTrue(
				"Error en el metodo add, ha insertado un elemento fuera de rango",
				!ce.contains(11) && ce.size() == 4);
	}

	@Test
	public void testAddAllCollection() {
		// TODO Auto-generated method stub
		
		Set<Integer> s =  new HashSet<Integer>();
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.addAll(s);
		assertTrue("Error en el metodo addAll", ce.containsAll(s)
				&& ce.size() == 7);

	}

	@Test
	public void testAddAllConjuntoEnteros() {
		// TODO Auto-generated method stub
		
		Set<Integer> s = new ConjuntoEnteros(0, 10);
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.addAll(s);
		assertTrue("Error en el metodo addAll", ce.containsAll(s)
				&&ce.size() == 7);

	}

	@Test
	public void testClear() {
		ce.clear();
		assertTrue("Error en el metodo clear", ce.isEmpty());

	}

	@Test
	public void testIterator() {
	
		Set<Integer> s =  new HashSet<Integer>();
		s.addAll(ce);

		assertTrue("Error en el iterador", ce.size() == s.size());

	}

	@Test
	public void testRemove() {
		ce.remove(12);
		assertTrue("Error en el metodo remove", !ce.contains(12)
				&& ce.size() == 4);

	}

	@Test
	public void testRemoveAllConjuntoEnteros() {
		Set<Integer> s = new ConjuntoEnteros(0, 10);
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.removeAll(s);

		assertTrue("Error en el metodo removeAll",
				!ce.containsAll(s) && ce.size() == 1);

	}

	@Test
	public void testRemoveAllCollection() {
		Set<Integer> s =  new HashSet<Integer>();
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.removeAll(s);
		assertTrue("Error en el metodo removeAll",
				!ce.containsAll(s) && ce.size() == 1);

	}

	@Test
	public void testRetainAllCollection() {
		Set<Integer> s =  new HashSet<Integer>();
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.retainAll(s);
		assertTrue("Error en el metodo retainAll", !ce.contains(9)
				&& ce.size() == 3);

	}

	@Test
	public void testRetainAllConjuntoEnteros() {

		Set<Integer> s = new ConjuntoEnteros(0, 10);
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		ce.retainAll(s);
		
		assertTrue("Error en el metodo retainAll", !ce.contains(9)
				&& ce.size() == 3);

	}

	@Test
	public void testContainsAllCollection() {
		Set<Integer> s =  new HashSet<Integer>();
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		boolean res = ce.containsAll(s);

		assertTrue("Error en el metodo containsAll", !res);

	}

	@Test
	public void testContainsAllConjuntoEnteros() {
		
		Set<Integer> s = new ConjuntoEnteros(0, 10);
		s.add(0);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);

		assertTrue("Error en el metodo containsAll", !ce.containsAll(s));

	}

	@Test
	public void testSize() {
		ce.add(0);
		assertTrue("Error en el metodo size", ce.contains(0) && ce.size() == 4);
	}

}
