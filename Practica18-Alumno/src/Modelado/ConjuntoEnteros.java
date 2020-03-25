package Modelado;

import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ConjuntoEnteros implements Set<Integer> {
	private Integer inf;
	private Integer sup;
	private BitSet conjunto;

	public ConjuntoEnteros(Integer inf, Integer sup) {
		super();
		if (sup <= inf)
			throw new IllegalArgumentException();
		this.inf = inf;
		this.sup = sup;
		this.conjunto = new BitSet(sup - inf);
	}

	public Integer getInf() {

		return inf;
	}

	public Integer getSup() {

		return sup;
	}

	public BitSet getConjunto() {

		return conjunto;
	}

	private Integer posicionToElemento(Integer pos) {
		return inf + pos;
	}

	private Integer elementoToPosicion(Integer valor) {
		return valor - inf;
	}

	/**************               INICIO METODOS POR COMPLETAR             *************************/


	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	/**************               FIN METODOS POR COMPLETAR             *************************/
	
	
	@Override
	public boolean containsAll(Collection<?> c) {
		boolean res = true;

		if (c instanceof ConjuntoEnteros) {
			if (((ConjuntoEnteros) c).getInf() != getInf()
					|| ((ConjuntoEnteros) c).getSup() != getSup())
				throw new IllegalArgumentException();

			ConjuntoEnteros caux = new ConjuntoEnteros(inf, sup);
			caux.addAll((ConjuntoEnteros) c);
			((ConjuntoEnteros) caux).getConjunto().andNot(this.getConjunto());
			// RemoveAll en c de los elementos de this
			res = caux.size() == 0;
			// Otra opcion hacer la interseccion de c y this
		} else {
			for (Object i : c) {
				res = contains(i) && res;
				if (!res)
					break;
			}
		}
		return res;
	}

	

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean res = false;

		if (c instanceof ConjuntoEnteros) {
			if (((ConjuntoEnteros) c).getInf() != getInf()
					|| ((ConjuntoEnteros) c).getSup() != getSup())
				throw new IllegalArgumentException();
			int size = size();
			this.getConjunto().and(((ConjuntoEnteros) c).getConjunto());
			res = size != size();

		} else {
			for (Integer i : this) {
				if (!c.contains(i))
					res = remove(i) || res;
			}
		}
		return res;

	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new IteratorConjuntoEnteros();
	}
	
	
	private class IteratorConjuntoEnteros implements Iterator<Integer> {
		private int i;

		public IteratorConjuntoEnteros() {
			i = -1;
			siguiente();
		}

		@Override
		public boolean hasNext() {

			return i != -1;
		}

		@Override
		public Integer next() {
			Integer e = posicionToElemento(i);
			siguiente();
			return e;
		}

		private void siguiente() {
			i = conjunto.nextSetBit(++i);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	

	@Override
	public Object[] toArray() {

		Iterator<Integer> it = new IteratorConjuntoEnteros();

		Object[] elems = new Object[conjunto.cardinality()];
		int i = 0;
		while (it.hasNext()) {
			elems[i] = it.next();
			i++;
		}

		return elems;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a == null)
			throw new NullPointerException();

		Object[] aux = toArray();

		if (a instanceof Integer[]) {
			a = (T[]) aux;
		} else
			throw new ArrayStoreException();

		return a;
	}

	

	@Override
	public String toString() {
		return "ConjuntoEnteros [inf=" + inf + ", sup=" + sup + ", conjunto="
				+ conjunto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inf == null) ? 0 : inf.hashCode());
		result = prime * result + ((sup == null) ? 0 : sup.hashCode());
		result = prime * result
				+ ((conjunto == null) ? 0 : conjunto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjuntoEnteros other = (ConjuntoEnteros) obj;
		if (inf == null) {
			if (other.inf != null)
				return false;
		} else if (!inf.equals(other.inf))
			return false;
		if (sup == null) {
			if (other.sup != null)
				return false;
		} else if (!sup.equals(other.sup))
			return false;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		return true;
	}

	@Override
	public ConjuntoEnteros clone() {
		ConjuntoEnteros copia = null;
		try {
			copia = (ConjuntoEnteros) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copia;
	}

}
