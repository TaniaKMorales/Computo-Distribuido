package segunda;

public interface Lock 
{
	public void requestCR(int pid);
	public void releaseCR(int pid);
}
