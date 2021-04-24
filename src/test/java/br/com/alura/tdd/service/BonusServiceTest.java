package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;

	@BeforeAll
	public static void antesDeTodosOsTestes() {
		System.out.println("ANTES DE TODOS OS TESTES");
	}
	
	@AfterAll
	public static void depoisDeTodosOsTestes() {
		System.out.println("DEPOIS DE TODOS OS TESTES");
	}

	@BeforeEach
	public void inicializar() {
		System.out.println("Inicio do teste");
		this.service = new BonusService();
	}
	
	@AfterEach
	public void terminar() {
		System.out.println("Fim do teste");
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		
		System.out.println("bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto");
		
		assertThrows(IllegalArgumentException.class, 
			() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

//		// tratando com bloco try/catch
//		try {
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail("nao deu exception");
//		} catch (IllegalArgumentException e) {
//			assertEquals("Funcionario com salario maior do que R$1000 nao pode receber bonus!", e.getMessage());
//		}

	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		
		System.out.println("bonusDeveriaSer10PorCentoDoSalario");
		
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		
		System.out.println("bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000");
		
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
