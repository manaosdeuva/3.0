public class Solicitud {
	private int id, carrera;
	private Estado state;
	private String materia;
	private Alumno alu;

	public Solicitud(int id, int carrera, Estado state, String materia,
			Alumno alu) {
		setAlu(alu);
		setCarrera(carrera);
		setId(id);
		setMateria(materia);
		setState(state);
	}

	public String toString() {
		return String.format(
				"id: %s, carrera: %s, state: %s, materia: %s, alu: %s", id,
				carrera, state, materia, alu);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarrera() {
		return carrera;
	}

	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}

	public Estado getState() {
		return state;
	}

	public void setState(Estado state) {
		this.state = state;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Alumno getAlu() {
		return alu;
	}

	public void setAlu(Alumno alu) {
		this.alu = alu;
	}
}
