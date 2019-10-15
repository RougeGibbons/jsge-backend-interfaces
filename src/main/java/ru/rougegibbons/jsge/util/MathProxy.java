package ru.rougegibbons.jsge.util;

import org.jetbrains.annotations.NotNull;

/**
 * interface for proxy objects implementing math operations wrappers.
 *
 * @param <N> - {@link Number} class derivative.
 * @author Kirill Cherkasov
 * @since 0.0.1
 */
public interface MathProxy<N extends Number> {
    /**
     * add first number to second and return the sum.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return lhs + rhs.
     */
    @NotNull N add(@NotNull N lhs, @NotNull N rhs);

    /**
     * subtract the first number from the second and return the result.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return lhs - rhs.
     */
    @NotNull N subtract(@NotNull N lhs, @NotNull N rhs);

    /**
     * multiply two numbers and return the result.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return lhs * rhs.
     */
    @NotNull N multiply(@NotNull N lhs, @NotNull N rhs);

    /**
     * divide first number by second and return the result.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return lhs / rhs.
     */
    @NotNull Float divide(@NotNull N lhs, @NotNull N rhs);

    /**
     * {@link MathProxy} interface expansion for dealing with {@link Integer} numbers.
     *
     * @author Kirill Cherkasov
     * @see MathProxy
     * @see Integer
     * @since 0.0.1
     */
    interface IntMathProxy extends MathProxy<Integer> {

    }

    /**
     * {@link MathProxy} interface extension for dealing with {@link Long} numbers.
     *
     * @author Kirill Cherkasov
     * @see MathProxy
     * @see Long
     * @since 0.0.1
     */
    interface LongMathProxy extends MathProxy<Long> {

    }

    /**
     * {@link MathProxy} interface extension for dealing with {@link Float} numbers.
     *
     * @author Kirill Cherkasov
     * @see MathProxy
     * @see Float
     * @since 0.0.1
     */
    interface FloatMathProxy extends MathProxy<Float> {

    }
}
