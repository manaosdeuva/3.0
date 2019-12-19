public class Regular extends Alumno {

	public Regular(int legajo, String nombre, double promedio) {
		super(legajo, nombre, promedio);
	}

	public int getPorcentaje() {
		return 0;
	}

	public String toString() {
		return String.format("legajo: %s, nombre: %s, promedio: %s",
				getLegajo(), getNombre(), getPromedio());
	}

}
