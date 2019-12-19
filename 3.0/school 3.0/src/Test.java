public class Test {

	public static void main(String[] args) throws Exception {
		main();
		try {
			// main();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	Estado aceptada = Estado.aceptada;
	static Estado ingresada = Estado.ingresada;
	Estado rechazada = Estado.rechazada;

	private static Carrera[] carrera() throws Exception {
		String[] nom = carreras();
		Carrera[] ca = new Carrera[15];
		for (int i = 0; i < ca.length; i++) {
			ca[i] = new Carrera(i, nom[i]);
		}
		return ca;
	}

	private static void main() throws Exception {
		Escuela e = new Escuela();
		Alumno[] alumnos = alumnos();
		Carrera[] ca = carrera();
		Materia[] materias = materias();

		e.setCarreras(ca);
		e.setMaterias(materias);
		agregarCursos(e);
		agregars(e, alumnos);
		e.addSolicitud(new Solicitud(99, 4, ingresada, e.getMaterias()[9]
				.getId(), new Regular(99, "capo", 4.2)));

		mostrarm(e.getMaterias());
		System.out.println("--____--");
		mostrarc(e.getCarreras());
		System.out.println("--____--");
		System.out.println(e.eliminarCurso("3"));
		System.out.println("--____--");
		e.informarTot();
		System.out.println("--____--");
		mostrarcu(e);
		System.out.println("--____--");
		mostrars(e);
	}

	private static void mostrars(Escuela e) {
		System.out.println("SOLICITUDES:");
		for (Solicitud s : e.getSolicitudes()) {
			System.out.println(s);
		}
	}

	private static void mostrarcu(Escuela e) {
		System.out.println("CURSOS:");
		for (Curso c : e.getCursos()) {
			for (Alumno a : c.getAlu()) {
				System.out.println(a);
			}
			System.out.println(c);
		}

	}

	private static void agregarCursos(Escuela e) throws Exception {
		for (Curso cu : cursos()) {
			for (Alumno a : alumnos()) {
				cu.add(a);
			}
			e.addCurso(cu);
		}
		Curso[] cursous = { crear(1), crear(2), crear(3), crear(4), crear(5),
				crear(6) };
		for (Curso curso : cursous) {
			curso.setId(curso.getId() + "f");
			e.addCurso(curso);
		}
	}

	private static Curso[] cursos() throws Exception {
		Curso[] cursos = { crear(1), crear(2), crear(3), crear(4), crear(5),
				crear(6) };
		return cursos;
	}

	private static Curso crear(int id) throws Exception {
		Curso c = new Curso("" + id, 0, materias()[id].getId(), id);
		return c;
	}

	private static Alumno[] alumnos() {
		Alumno[] alumnos = { new Regular(0, "Gabriel", 6),
				new Becado(1, "Andres", 7, 99, 'a'), new Regular(2, "Ioel", 5),
				new Regular(3, "Pablo", 5.7), new Regular(4, "Matias", 8.5),
				new Regular(5, "Jose", 8), new Regular(6, "Raul", 9),
				new Regular(7, "perdedor", 0) };
		return alumnos;

	}

	private static void mostrarc(Carrera[] ca) {
		System.out.println("CARRERAS:");
		for (Carrera carrera : ca) {
			System.out.println(carrera);
		}
	}

	private static void agregars(Escuela e, Alumno[] a) throws Exception {
		e.addSolicitud(new Solicitud(1, 1, ingresada, materias()[1].getId(),
				new Regular(0, "gabriel", 6)));
		e.addSolicitud(new Solicitud(2, 2, ingresada, materias()[2].getId(),
				new Regular(0, "gabriel", 6)));
		e.addSolicitud(new Solicitud(3, 3, ingresada, materias()[3].getId(),
				new Regular(0, "gabriel", 6)));
		e.addSolicitud(new Solicitud(4, 4, ingresada, materias()[4].getId(),
				new Regular(0, "gabriel", 6)));
		e.addSolicitud(new Solicitud(5, 5, ingresada, materias()[5].getId(),
				new Regular(0, "gabriel", 6)));
	}

	private static void mostrarm(Materia[] materias) {
		System.out.println("MATERIAS:");
		for (Materia m : materias) {
			System.out.println(m);
		}
	}

	private static String[] carreras() {
		String[] nom = { "analista", "biotecnologia", "productor musical",
				"diseño digital", "diseño industrial", "videojuegos",
				"programador", "testing", "base de datos", "diseño web",
				"diseño grafico", "animación", "computación cientifica",
				"radiologia", "hardware" };
		return nom;
	}

	private static Materia[] materias() throws Exception {
		Materia[] materias = { new Materia("organizacion empresarial", 2),
				new Materia("introduccion a la informatica", 2),
				new Materia("fundamentos de programacion", 6),
				new Materia("taller de herramientas de programacion", 6),
				new Materia("matematica", 4), new Materia("ingles tecnico", 2),
				new Materia("taller de creatividad e innovacion", 2),
				new Materia("sistemas administrativos", 2),
				new Materia("arquitectura y sistemas operativos", 2),
				new Materia("programacion1", 6),
				new Materia("taller de programacion1", 6),
				new Materia("programacion en nuevas tecnologias1", 6),
				new Materia("base de datos1", 2),
				new Materia("analisis y metodologia de sistemas", 4),
				new Materia("base de datos2", 2),
				new Materia("programacion2", 6),
				new Materia("taller de programacion2", 6),
				new Materia("programacion en nuevas tecnologias2", 6),
				new Materia("programacion3", 6),
				new Materia("taller de programacion3", 6),
				new Materia("proyecto final", 6),
				new Materia("seguridad e integridad de sistemas", 2),
				new Materia("calidad de software", 2),
				new Materia("estudios judaicos", 2) };
		return materias;
	}

	public void aux(Escuela e) throws Exception {
		Alumno alumno = new Regular(0, "Gabriel", 6);
		Alumno becado = new Becado(1, "Andres", 7, 99, 'a');
		Carrera carrera = new Carrera(0, "analista");
		Curso curso = new Curso("12e", 14, "progra", 0);
		Materia materia = new Materia("progra", "programacion", 4);
		Solicitud solicitud = new Solicitud(2, 0, Estado.ingresada, "progra",
				alumno);
		System.out
				.println(String
						.format("alumno %s\nbecado %s\ncarrera %s\ncurso %s\nmateria %s\nsolicitud %s",
								alumno, becado, carrera, curso, materia,
								solicitud));
		// Regular(int legajo,String nombre,promedio)
		// Becado(int legajo,String nombre, promedio,int porcentaje, tipo)
		// Carrera(int id,String nombre)
		// Curso(id ,int cupo ,String materia ,int carrera)
		// Materia(String id ,String nombre ,int horas )
		// Solicitud(int id ,int carrera ,Estado state ,String materia ,Alumno
		// alu )

	}

}
