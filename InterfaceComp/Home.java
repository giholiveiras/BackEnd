package InterfaceComp;

public class Home implements Computador {

	@Override
	public void ligar() {
		System.out.println("O computador de casa está ligando");
	}
	@Override
	public void reiniciar() {
		System.out.println("O computador de casa está reiniciando");
	}
	@Override
	public void desligar() {
		System.out.println("O computador de casa está desligando");
	}
	@Override
	public void carregSistema() {
		System.out.println("O computador de casa está carrgando seu sistema");
	}
}



