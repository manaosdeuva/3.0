public class Materia {
	private String id, nombre;
	private int horasPorSemana;

	public Materia(String id, String nombre, int horasPorSemana)
			throws Exception {
		setId(id);
		setNombre(nombre);
		setHorasPorSemana(horasPorSemana);
	}

	public Materia(String nombre, int horasPorSemana) throws Exception {
		setId(nombre.substring(0, 3) + nombre.substring(nombre.length() - 3));
		setNombre(nombre);
		setHorasPorSemana(horasPorSemana);
	}

	public String toString() {
		return String.format("id: %s, nombre: %s, horas por semana: %s", id,
				nombre, horasPorSemana);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		if (id.length() <= 6) {
			this.id = id;
		} else {
			this.id = id.substring(0, 6);
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {

		this.nombre = nombre;

	}

	public int getHorasPorSemana() {
		return horasPorSemana;
	}

	public void setHorasPorSemana(int horasPorSemana) {
		this.horasPorSemana = horasPorSemana;
	}
}
