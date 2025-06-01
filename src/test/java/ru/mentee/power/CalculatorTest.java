package ru.mentee.power;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты калькулятора")
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Тест сложения")
    void testAdd(){
        assertEquals(8, calculator.add(3, 5));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-8, calculator.add(-5, -3));
    }

    @Test
    @DisplayName("Тест операции вычитания")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-10, calculator.subtract(-5, 5));
        // Ой! В этой строке есть ошибка в ожидаемом результате. Найдите и исправьте её:
        assertEquals(-8, calculator.subtract(-5, 3));
    }

    @Test
    @DisplayName("Тест операции умножения")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(-15, calculator.multiply(-5, 3));
        assertEquals(15, calculator.multiply(-5, -3));
        assertEquals(0, calculator.multiply(0, 10));
    }

    @Test
    @DisplayName("Тест операции деления")
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.5, calculator.divide(-5, 2));
        assertEquals(2.5, calculator.divide(-5, -2));
    }

    @Test
    @DisplayName("Тест деления на ноль")
    public void testDivideByZero() {
        double resultDiv = calculator.divide(3, 0);
        assertEquals("Divide by zero gives infinity as result", true, Double.isInfinite(resultDiv));
    }
}