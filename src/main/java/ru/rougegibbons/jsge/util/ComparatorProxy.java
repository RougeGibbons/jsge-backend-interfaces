package ru.rougegibbons.jsge.util;

import org.jetbrains.annotations.NotNull;

/**
 * interface describing proxies used to compare various numbers.
 *
 * @param <N> - some {@link Number} class derivative.
 * @author Kirill Cherkasov
 * @since 0.0.1
 */
public interface ComparatorProxy<N extends Number> {
    /**
     * check if the first number is lesser than second.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs is lesser than rhs, false otherwise.
     */
    @NotNull Boolean isLess(@NotNull N lhs, @NotNull N rhs);

    /**
     * check if the first number is greater than second.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs is greater than rhs, false otherwise.
     */
    @NotNull Boolean isMore(@NotNull N lhs, @NotNull N rhs);

    /**
     * check if two numbers are equal.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs is equal to rhs, false otherwise.
     */
    default @NotNull Boolean areEqual(@NotNull N lhs, @NotNull N rhs) {
        return !(isLess(lhs, rhs) || isMore(lhs, rhs));
    }

    /**
     * check if the first nuumber is lesser or equal to second.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs is lesser or equal to rhs, false otherwise.
     */
    default @NotNull Boolean isLessOrEqual(@NotNull N lhs, @NotNull N rhs) {
        return !isMore(lhs, rhs);
    }

    /**
     * check if the first number is greater or equal to second.
     *
     * @param lhs - first number.
     * @param rhs - second number.
     * @return true if lhs is greater or equal to rhs, false otherwise.
     */
    default @NotNull Boolean isGreaterOrEqual(@NotNull N lhs, @NotNull N rhs) {
        return !isLess(lhs, rhs);
    }

    /**
     * {@link ComparatorProxy} extension for dealing with {@link Integer} numbers.
     *
     * @author Kirill Cherkasov
     * @see ComparatorProxy
     * @see Integer
     * @since 0.0.1
     */
    interface IntComparatorProxy extends ComparatorProxy<Integer> {

    }

    /**
     * {@link ComparatorProxy} extension for dealing with {@link Long} numbers.
     *
     * @author Kirill Cherkasov
     * @see ComparatorProxy
     * @see Long
     * @since 0.0.1
     */
    interface LongComparatorProxy extends ComparatorProxy<Long> {

    }

    /**
     * {@link ComparatorProxy} extension for dealing with {@link Float} numbers.
     *
     * @author Kirill Cherkasov
     * @see ComparatorProxy
     * @see Float
     * @since 0.0.1
     */
    interface FloatComparatorProxy extends ComparatorProxy<Float> {

    }
}
