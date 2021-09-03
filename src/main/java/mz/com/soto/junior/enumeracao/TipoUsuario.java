package mz.com.soto.junior.enumeracao;

public enum TipoUsuario {
	ADMINISTRADOR,
	GERENTE,
	CLIENTE,
	BALCONISTA;
	
	@Override
	public String toString() {
		switch (this) {
		case ADMINISTRADOR:
			return "Administrador";
		case GERENTE:
			return "Gerente";
		case CLIENTE:
			return "Cliente";
		case BALCONISTA:
			return "Balconista";
		default:
			return null;
		}
	}

}
