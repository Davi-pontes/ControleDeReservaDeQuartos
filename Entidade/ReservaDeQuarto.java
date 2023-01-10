package Entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.ececoes.DominioException;

public class ReservaDeQuarto {
	
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ReservaDeQuarto() {
	}

	public ReservaDeQuarto(Integer numeroDoQuarto, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DominioException("A data de check=Out deve ser posterior a data de check-In");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferença = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferença, TimeUnit.MILLISECONDS);
	}
	
	public void AtualizacaoDeData (Date checkIn, Date checkOut)  {
		Date hoje = new Date();
		if (checkIn.before(hoje) || checkOut.before(hoje)){
			throw new DominioException("As datas de reserva para atualizacao devem ser datas futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioException("A data de check=Out deve ser posterior a data de check-In");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", Check-In:"
				+ sdf.format(checkIn)
				+ " Check-Out:"
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " Noites";
	}

}
