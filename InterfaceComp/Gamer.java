package InterfaceComp;

public class Gamer implements Computador {
	
	@Override
	public void ligar() {
		System.out.println("O computador Gamer está ligando");
	}
	@Override
	public void reiniciar() {
		System.out.println("O computador Gamer está reiniciando");
	}
	@Override
	public void desligar() {
		System.out.println("O computador Gamer está desligando");
	}
	@Override
	public void carregSistema() {
		System.out.println("O computador Gamer está carrgando seu sistema");
	}
}
