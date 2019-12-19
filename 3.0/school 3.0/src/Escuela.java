import java.util.ArrayList;
import java.util.LinkedList;

public class Escuela {
	private LinkedList<Curso> cursos;
	private LinkedList<Solicitud> solicitudes;
	private Carrera[] carreras;
	private Materia[] materias;

	public Escuela() {
		cursos = new LinkedList<Curso>();
		solicitudes = new LinkedList<Solicitud>();
		carreras = new Carrera[15];
		materias = new Materia[30];
	}

	public void addCurso(Curso c) {
		cursos.addFirst(c);
	}

	public void addSolicitud(Solicitud s) {
		solicitudes.addFirst(s);
	}

	public Curso popCurso() {
		return cursos.removeFirst();
	}

	public Solicitud popSolicitud() {
		return solicitudes.removeFirst();
	}

	public Curso chequearSolicitud(Solicitud s) {
		int carrera = s.getCarrera();
		String materia = s.getMateria();
		Curso c = buscarCurso(materia, carrera);
		return c;
	}

	private Curso buscarCurso(String materia, int carrera) {
		Curso c = null, caux = cursos.removeFirst();
		ArrayList<Curso> laux = new ArrayList<Curso>();
		while (!cursos.isEmpty() && c == null) {
			if (caux.getCarrera() == carrera) {
				if (caux.getMateria().equals(materia)) {
					c = caux;
				}
			}
			laux.add(caux);
			caux = cursos.removeFirst();
		}
		laux.add(caux);
		while (!laux.isEmpty()) {
			caux = laux.remove(0);
			cursos.add(caux);
		}
		return c;
	}

	public Curso eliminarCurso(String id) {
		Curso c = buscarCurso(id);
		for (Alumno a : c.getAlu()) {
			crearSolicitud(new Solicitud(solicitudes.size() + 1,
					c.getCarrera(), Estado.ingresada, c.getMateria(), a));
		}
		return c;
	}

	public void crearSolicitud(Solicitud s) {
		Curso c = chequearSolicitud(s);
		Alumno a = s.getAlu();
		if (c != null) {
			if (c.getAlu().size() < c.getCupo()) {
				s.setState(Estado.aceptada);
			} else {
				if (a instanceof Becado) {
					if (a.getPromedio() >= 5 && a.getPorcentaje() == 100) {
						s.setState(Estado.aceptada);
					}
				} else {
					if (a.getPromedio() >= 6) {
						s.setState(Estado.aceptada);
					}
				}
			}
			if (!s.getState().equals(Estado.aceptada))
				s.setState(Estado.rechazada);
		} else {
			s.setState(Estado.ingresada);
		}
		addSolicitud(s);
	}

	public Curso buscarCurso(String id) {
		Curso c = null, caux = cursos.removeFirst();
		ArrayList<Curso> laux = new ArrayList<Curso>();
		do {
			if (caux.getId().equals(id)) {
				c = caux;
			} else {
				laux.add(caux);
				caux = cursos.removeFirst();
			}
		} while (!cursos.isEmpty() && c == null);
		if (caux.getId().equals(id)) {
			c = caux;
		} else {
			laux.add(caux);
		}
		while (!laux.isEmpty()) {
			caux = laux.remove(0);
			cursos.add(caux);
		}
		return c;
	}

	public void informarTot() {
		System.out.println("SOLICITUDES POR CARRERA:");
		mostrarSC();
		System.out.println("SOLICITUDES POR MATERIA:");
		mostrarSM();
		System.out.println("TOTAL SOLICITUDES: " + solicitudes.size());
	}

	private void mostrarSM() {
		int cantidad[] = cargarMateria();
		int indice = 0;
		for (Materia m : materias) {
			if (cantidad[indice] != 0) {
				System.out.println(m.getNombre() + ": " + cantidad[indice]);
			}
			indice++;
		}

	}

	private int[] cargarMateria() {
		int[] cantidad = new int[30];
		for (Solicitud s : solicitudes) {
			cantidad[indiceMateria(s.getMateria())]++;
		}
		return cantidad;
	}

	private int indiceMateria(String idmateria) {
		int indice = 0;
		boolean encontrada = false;
		Materia aux = materias[indice];
		while (indice < materias.length && !encontrada) {
			if (aux.getId().equals(idmateria)) {
				encontrada = true;
			} else {
				indice++;
				aux = materias[indice];
			}
		}
		return indice;
	}

	private void mostrarSC() {
		int[] cantidad = cargarCarrera();
		for (Carrera c : carreras) {
			if (cantidad[c.getId()] != 0)
				System.out.println(c.getNombre() + ": " + cantidad[c.getId()]);
		}

	}

	private int[] cargarCarrera() {
		int[] cantidad = new int[15];
		for (Solicitud s : solicitudes) {
			cantidad[s.getCarrera()]++;
		}
		return cantidad;
	}

	public LinkedList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(LinkedList<Curso> cursos) {
		this.cursos = cursos;
	}

	public LinkedList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(LinkedList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Carrera[] getCarreras() {
		return carreras;
	}

	public void setCarreras(Carrera[] carreras) {
		this.carreras = carreras;
	}

	public Materia[] getMaterias() {
		return materias;
	}

	public void setMaterias(Materia[] materias) {
		this.materias = materias;
	}
}
