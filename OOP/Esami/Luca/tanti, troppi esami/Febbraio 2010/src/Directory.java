import java.util.*;

public class Directory extends Risorsa {

	private Set<Risorsa> risorse;

	public Directory(String nome, Utente proprietario) {
		super(nome, proprietario);
		this.risorse = new HashSet<Risorsa>();
	}

	@Override
	public int getDimensioni() {
		int dimensioni = 0;
		for (Risorsa file : this.risorse)
			dimensioni += file.getDimensioni();
		return dimensioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((risorse == null) ? 0 : risorse.hashCode());
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
		Directory other = (Directory) obj;
		if (risorse == null) {
			if (other.risorse != null)
				return false;
		} else if (!risorse.equals(other.risorse))
			return false;
		return true;
	}
}