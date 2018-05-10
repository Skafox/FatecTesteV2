package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.emprestimo.modelo.Usuario;


@RunWith(Parameterized.class)
public class UC10CadastrarUsuarioV2 {
	Usuario usuario;
	@Parameter
	public String ra;
	@Parameter(1)
	public String nome;
	@Parameter(2)
	public String resultadoEsperado;
	
	@Parameters
	public static Collection<Object[]> dadosDeTeste() {
		return Arrays.asList(new Object[][] { 
			{ "1111", "Jose Silva", "Delamaro", "valido" },
			{ "", "Jose Silva", "Delamaro", "RA invalido" },
		});
	}
	
	@Test
	public void CT01UC06ValidaComportamentoDoCadastrarUsuario() {
		try {
			usuario.setRa(ra);
			usuario.setNome(nome);
			assertTrue(resultadoEsperado.equals("valido"));
		}catch (Exception e) {
			assertTrue(resultadoEsperado.equals(e.getMessage()));
		}
	}
	
}