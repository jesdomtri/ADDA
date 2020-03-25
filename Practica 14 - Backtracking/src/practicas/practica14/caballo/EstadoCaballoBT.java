package practicas.practica14.caballo;

import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import us.lsi.bt.EstadoBT;

//TODO ALUMNOS: OTRAS IMPORTACIONES.

public class EstadoCaballoBT implements EstadoBT<SolucionCaballoBT, Integer> {

	private Integer posx = null;
	private Integer posy = null;
	private Integer casillasProcesadas = null;
	private Table<Integer, Integer, Integer> tablero = null;

	/*************************************/
	private Integer tam = null;
	private Integer[] movx = null;
	private Integer[] movy = null;

	public static EstadoCaballoBT create() {
		return new EstadoCaballoBT();
	}

	private EstadoCaballoBT() {
		tam = ProblemaCaballo.getLadoTablero();
		movx = ProblemaCaballo.getMovimientosX();
		movy = ProblemaCaballo.getMovimientosY();
		/**********************************/
		casillasProcesadas = 1;
		posx = ProblemaCaballo.getCasillaInicialX();
		posy = ProblemaCaballo.getCasillaInicialY();
		tablero = HashBasedTable.create();
		tablero.put(posx, posy, casillasProcesadas);
	}

	public EstadoCaballoBT avanza(Integer movimiento) {
		casillasProcesadas++;
		posx += movx[movimiento];
		posy += movy[movimiento];
		tablero.put(posx, posy, casillasProcesadas);
		return this;
	}

	public EstadoCaballoBT retrocede(Integer movimiento) {
		tablero.remove(posx, posy);
		casillasProcesadas -= 1;
		posx -= movx[movimiento];
		posy -= movy[movimiento];
		return this;
	}

	public List<Integer> getAlternativas() {
		List<Integer> res = Lists.newArrayList();
		Integer tam = ProblemaCaballo.getLadoTablero();
		for (int i = 0; i < 8; i++) {
			if ((0 <= (posx + movx[i]) && (posx + movx[i]) < tam) && (0 <= (posy + movy[i]) && (posy + movy[i]) < tam)
					&& (tablero.get(posx + movx[i], posy + movy[i])) == null) {
				res.add(i);
			}
		}
		return res;
		// return IntStream.range(0,8).boxed().filter(i -> 0<=posx + movx[i] && posx +
		// movx[i]<tam).filter(i -> 0<=posy + movy[i] && posy + movy[i]<tam)
		// .filter(i -> tablero.get(posx+ movx[i], posy +
		// movy[i])==null).collect(Collectors.toList());
	}

	public SolucionCaballoBT getSolucion() {
		return SolucionCaballoBT.create(tablero);
	}

	public int size() {
		return ProblemaCaballo.getLadoTablero() * ProblemaCaballo.getLadoTablero() - casillasProcesadas;
	}

	public Tipo getTipo() {
		return Tipo.AlgunasSoluciones;
	}

	public EstadoCaballoBT getEstadoInicial() {
		return EstadoCaballoBT.create();
	}

	public boolean esCasoBase() {
		return casillasProcesadas == ProblemaCaballo.getLadoTablero() * ProblemaCaballo.getLadoTablero();
	}

}
