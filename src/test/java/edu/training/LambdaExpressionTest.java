package edu.training;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LambdaExpressionTest {

    @Test
    void stringLengthLessThan5() {
        Predicate<String> predicate = LambdaExpression.stringLengthPredicate();
        boolean actual = predicate.test("abcde");
        assertFalse(actual);
    }

    @Test
    void stringLengthMoreThan5() {
        Predicate<String> stringPredicate = LambdaExpression.stringLengthPredicate();
        boolean actual = stringPredicate.test("abcdef");
        assertTrue(actual);
    }

    @Test
    void evenNumberPositiveResult() {
        IntPredicate intPredicate = LambdaExpression.evenNumberPredicate();
        boolean actual = intPredicate.test(2);
        assertTrue(actual);
    }

    @Test
    void evenNumberNegativeResult() {
        IntPredicate intPredicate = LambdaExpression.evenNumberPredicate();
        boolean actual = intPredicate.test(3);
        assertFalse(actual);
    }

    @Test
    void stringLengthFunction() {
        Function<String, Integer> func = LambdaExpression.stringLengthFunction();
        Integer actual = func.apply("abc");
        assertEquals(3, actual);
    }

    @Test
    void toStringFunction() {
        Function<Integer, String> toStringFunction = LambdaExpression.toStringFunction();
        String actual = toStringFunction.apply(1234);
        assertEquals("1234", actual);
    }

    @Test
    void javaSupplier() {
        Supplier<String> stringSupplier = LambdaExpression.javaSupplier();
        String actual = stringSupplier.get();
        assertEquals("Java", actual);
    }

    @Test
    void collectionSupplier() {
        Supplier<List<String>> supplier = LambdaExpression.collectionSupplier();
        List<String> actual = supplier.get();
        assertEquals(List.of("one", "two", "three"), actual);
    }

    @Test
    void intSquare() {
        IntUnaryOperator intUnaryOperator = LambdaExpression.intSquare();
        int actual = intUnaryOperator.applyAsInt(5);
        assertEquals(25, actual);
    }

    @Test
    void multiplication() {
        IntBinaryOperator multiplication = LambdaExpression.multiplication();
        int actual = multiplication.applyAsInt(2, 6);
        assertEquals(12, actual);
    }

    @Test
    void multiplicationResultIsEvenPositive() {
        BiPredicate<Integer, Integer> biPredicate = LambdaExpression.multiplicationResultIsEven();
        boolean actual = biPredicate.test(5, 2);
        assertTrue(actual);
    }

    @Test
    void multiplicationResultIsEvenNegative() {
        BiPredicate<Integer, Integer> biPredicate = LambdaExpression.multiplicationResultIsEven();
        boolean actual = biPredicate.test(3, 7);
        assertFalse(actual);
    }
}