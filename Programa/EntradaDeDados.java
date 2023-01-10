package Programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidade.ReservaDeQuarto;
import model.ececoes.DominioException;

public class EntradaDeDados {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Digite o numero do quarto: ");
			int numero = leitor.nextInt();
			System.out.print("Digite a data do check-In: ");
			Date checkIn = sdf.parse(leitor.next());
			System.out.print("Digite a data do check-Out: ");
			Date checkOut = sdf.parse(leitor.next());
			
			
			ReservaDeQuarto reserva = new ReservaDeQuarto(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Digite os dados para atualizar a reserva");
			
			System.out.print("Digite a data do check-In: ");
			checkIn = sdf.parse(leitor.next());
			System.out.print("Digite a data do check-Out: ");
			checkOut = sdf.parse(leitor.next());
			
			reserva.AtualizacaoDeData(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e){
			System.out.println("Data invalida.");
		}
		catch (DominioException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e){
			System.out.println("Houve um erro inesperado!");
		}
		
		leitor.close();
	}

}
