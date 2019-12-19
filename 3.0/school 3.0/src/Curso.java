import java.util.ArrayList;

public class Curso {
	private String id, materia;
	private int cupo, carrera;
	private ArrayList<Alumno> alu;

	public Curso(String id, int cupo, String materia, int carrera) {
		setCupo(cupo);
		setId(id);
		setMateria(materia);
		setCarrera(carrera);
		this.alu = new ArrayList<Alumno>();
	}

	public String toString() {
		return String.format("id: %s, materia: %s, carrera: %s, cupo: %s", id,
				materia, carrera, cupo);
	}

	public void add(Alumno a) {
		alu.add(a);
	}

	public void add(Becado a) {
		alu.add(a);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getCarrera() {
		return carrera;
	}

	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}

	public ArrayList<Alumno> getAlu() {
		return alu;
	}

	public void setAlu(ArrayList<Alumno> alu) {
		this.alu = alu;
	}
}
