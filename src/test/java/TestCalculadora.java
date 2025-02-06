// 1- Pacotes do projeto

// 2- Bibliotecas / Imports
import static org.junit.jupiter.api.Assertions.assertEquals; // Asserts do JUnit 5

import org.junit.jupiter.api.Test; // JUnit 5
import org.junit.jupiter.params.ParameterizedTest; // DDT
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource; // DDT

import com.iterasys.Main; // Classe que será testada

// 3- Classe
public class TestCalculadora {
    // 3.1- Atributos
    float num1 = 10;
    float num2 = 5;

    // 3.2 - Métodos e Funções
    @Test
    public void testSomar() {
        // AAA - Arrange, Act, Assert
        // CEV - Configuração, Execução, Verificação

        // -> Configuração
        // Dados de entrada
        // Dados de saída, resultado esperado
        float resultEsperado = 15;

        // -> Execução
        float resultAtual = Main.somar(num1, num2);

        // -> Verificação
        assertEquals(resultEsperado, resultAtual);
    }

    @Test
    public void testSubtrair() {
        float resultEsperado = 5;
        assertEquals(resultEsperado, Main.subtrair(num1, num2)); // Otimização do código 1
        // float resultAtual = Main.subtrair(num1, num2);
        // assertEquals(resultEsperado, resultAtual);
    }

    @Test
    public void testMultiplicar() {
        assertEquals(50, Main.multiplicar(num1, num2)); // Otimização do código 2
    }

    @Test
    public void dividirTry() {
        int number1 = 27;
        int number2 = 3;
        assertEquals("9", Main.dividirTry(number1, number2));
    }

    @Test
    public void dividirTryPorZero() {
        int number1 = 27;
        int number2 = 0;
        assertEquals("Não é possível dividir por zero", Main.dividirTry(number1, number2));
    }

    // DDT - Data Driven Testing -> Teste directionado a dados
    // Popular -> Teste com massa de dados
    @ParameterizedTest
    @CsvSource(value = {
            "15, 25, 40.0",
            "0, 12, 12.0",
            "-5, 9, 4.0",
            "-7, -8, -15.0",
            "0.5, 3.7, 4.2"
    }, delimiter = ',')

    public void testSomarDDT(float num1, float num2, float resultEsperado) {
        // Os dados de entrada e o resultado esperado são lidos da massa de teste acima
        float resultAtual = Main.somar(num1, num2); // Execução
        assertEquals(resultEsperado, resultAtual); // Verificação
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/somar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testSomarCSV(float num1, float num2, float resultEsperado) {
        // Os dados de entrada e o resultado esperado são lidos da massa de teste acima
        float resultAtual = Main.somar(num1, num2); // Execução
        assertEquals(resultEsperado, resultAtual); // Verificação
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/multiplicar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testMultiplicarCSV(float num1, float num2, float resultEsperado) {
        float resultAtual = Main.multiplicar(num1, num2);
        assertEquals(resultEsperado, resultAtual);
    }

    // Testar velocidade de execução dos testes -> mvn test
}
