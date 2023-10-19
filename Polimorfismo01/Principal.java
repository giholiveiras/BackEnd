package Polimorfismo01;

public class Principal {
	
	public static void main (String [] args) {
		Lobo lobo = new Lobo ("Thor", "M", "Qualquer");
		lobo.emitirSom();
		
		Leao leao = new Leao ("Leao", "M", "Qualquer");
		leao.emitirSom();
	}
}
