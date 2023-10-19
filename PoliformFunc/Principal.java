package PoliformFunc;
public class Principal {

	public static void main (String [] args) {

		Jornada jornada = new Jornada(1, "Giovana", "15 991577126", 12, "Rua dos Brilhantes, 81");
		System.out.println("O Salário de Giovana é:" + jornada.calculaSalario(200, 36));
		
		System.out.println("\n");
		
		Horista horista = new Horista(2, "Renan", "11 967064002", 11, "Rua dos Brilhantes, 81");
		System.out.println("O Salário de Renan é:" + horista.calculaSalario(150, 20));
		
		System.out.println("\n");
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica(3, "Marcia", "11 967064002", 11, "Rua dos Brilhantes, 81");
		System.out.println("O Salário da pessoa jurídica é:" + pessoaJuridica.calculaSalario(300, 10));

	}
}
