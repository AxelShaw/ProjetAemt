package be.helha.aemt.groupeA6.exceptions;

public class NotCompleteException extends Exception{
	public NotCompleteException()
	{
		super("Veuillez remplir tous les champs.");
	}
}
