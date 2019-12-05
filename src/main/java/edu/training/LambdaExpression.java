package edu.training;


import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpression {

    /**
     * Implement the predicate that check if input string length is higher than 5
     *
     * @return Predicate that return
     * - false if string length is 5 or less
     * - true if string length is 6 of more
     */
    public static Predicate<String> stringLengthPredicate() {
        throw new UnsupportedOperationException();  //need to implement
    }

    /**
     * Implement the predicate that check if input number is even
     *
     * @return Predicate that return
     * - false if number is odd
     * - true if number is even
     */
    public static IntPredicate evenNumberPredicate() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement function that take a string and return string length
     *
     * @return String to Integer function
     */
    public static Function<String, Integer> stringLengthFunction() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement function that take an integer and return string value of integer e.q. 123 -> "123"
     *
     * @return Integer to string function
     */
    public static Function<Integer, String> toStringFunction() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement supplier that returns string "Java"
     *
     * @return Supplier
     */
    public static Supplier<String> javaSupplier() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement supplier that returns ArrayList of Strings with 3 elements "one", "two", "three"
     *
     * @return Supplier
     */
    public static Supplier<List<String>> collectionSupplier() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement UnaryOperator that returns square of input value
     *
     * @return IntUnaryOperator
     */
    public static IntUnaryOperator intSquare() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement BinaryOperator that returns multiplication of two input values
     * @return IntBinaryOperator
     */
    public static IntBinaryOperator multiplication() {
        throw new UnsupportedOperationException(); //need to implement
    }

    /**
     * Implement BiPredicate that check if the result of multiplication of two Integers is even number
     * @return BiPredicate
     */
    public static BiPredicate<Integer, Integer> multiplicationResultIsEven() {
        throw new UnsupportedOperationException();
    }


}
