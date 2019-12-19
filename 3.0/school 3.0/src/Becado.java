public class Becado extends Alumno {
	private int porcentaje;
	private char tipo;

	public Becado(int legajo, String nombre, double promedio, int porcentaje,
			char tipo) {
		super(legajo, nombre, promedio);
		setPorcentaje(porcentaje);
		setTipo(tipo);
	}

	public String toString() {
		return String
				.format("legajo: %s, nombre: %s, promedio: %s, porcentaje: %s, tipo: %s",
						getLegajo(), getNombre(), getPromedio(), porcentaje,
						tipo);
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		switch (tipo) {
		case 'a':
			this.tipo = tipo;
			break;
		case 'b':
			this.tipo = tipo;
		default:
			this.tipo = 'a';
			break;
		}

	}

}
