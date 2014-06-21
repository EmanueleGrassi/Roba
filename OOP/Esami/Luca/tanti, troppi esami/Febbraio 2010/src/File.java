public class File extends Risorsa {
	private int dimensioni;

	public File(String nome, int dimensioni, Utente proprietario) {
		super(nome, proprietario);
		this.dimensioni = dimensioni;
	}

	@Override
	public int getDimensioni() {
		return this.dimensioni;
	}

	public void setDimensioni(int dimensioni) {
		this.dimensioni = dimensioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dimensioni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (dimensioni != other.dimensioni)
			return false;
		return true;
	}

}