public abstract class Alumno {
	private int legajo;
	private String nombre;
	private double promedio;

	public Alumno(int legajo, String nombre, double promedio) {
		setLegajo(legajo);
		setNombre(nombre);
		setPromedio(promedio);
	}

	protected int getLegajo() {
		return legajo;
	}

	protected void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected double getPromedio() {
		return promedio;
	}

	protected void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	protected abstract int getPorcentaje();
}
