public class Carrera {
	private int id;
	private String nombre;

	public Carrera(int id, String nombre) throws Exception {
		setId(id);
		setNombre(nombre);
	}

	public String toString() {
		return String.format("id: %s, nombre %s", id, nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if (id >= 0 && id <= 15)
			this.id = id;
		else
			throw new Exception("haha fuckyou");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
