

public class Posizione {
	
	public int x, y;
	
	public Posizione (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	public String toString() {
		return this.x+"-"+this.y;
	}

	public boolean equals(Object o)
	{
		Posizione temp = (Posizione)o;
		if(this.x==temp.getX() && this.y==temp.getY())
			return true;
		else
			return false;
	}
	public int hashCode()
	{
		return ((Integer)this.x).hashCode() + ((Integer)this.y).hashCode();
	}
}