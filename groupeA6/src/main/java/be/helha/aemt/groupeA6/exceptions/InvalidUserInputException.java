package be.helha.aemt.groupeA6.exceptions;

import java.io.IOException;

import javax.swing.JOptionPane;

import jakarta.faces.context.FacesContext;

public class InvalidUserInputException extends Exception {

	private static final long serialVersion = 1L;
	
	public InvalidUserInputException(String emailVal) {
		super("L'email  est invalide\n Format : email@helha.be");
	}
}
