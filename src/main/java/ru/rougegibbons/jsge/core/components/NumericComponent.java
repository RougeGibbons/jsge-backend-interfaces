package ru.rougegibbons.jsge.core.components;

import org.jetbrains.annotations.NotNull;

/**
 * {@link ValueHolderComponent} interface extension for number components.
 *
 * @param <N> - any {@link Number} class derivative.
 * @author Kirill Cherkasov
 * @see ValueHolderComponent
 * @see Number
 * @since 0.0.1
 */
public interface NumericComponent<N extends Number> extends ValueHolderComponent<N> {
    /**
     * {@link NumericComponent} interface extension for dealing with integer numbers.
     *
     * @see Integer
     * @since 0.0.1
     */
    interface IntegerValue extends ValueHolderComponent<Integer> {

    }

    /**
     * {@link NumericComponent} interface extension for dealing with long integer ones.
     *
     * @see Long
     * @since 0.0.1
     */
    interface LongValue extends ValueHolderComponent<Long> {

    }

    /**
     * {@link NumericComponent} interface extension for dealing with floating point numbers.
     *
     * @see Float
     * @since 0.0.1
     */
    interface FloatValue extends ValueHolderComponent<Float> {

    }

    /**
     * {@link NumericComponent} interface extension for modifiable numeric components.
     *
     * @param <N> - see {@link NumericComponent}.
     * @see ru.rougegibbons.jsge.core.components.ValueHolderComponent.ModifiableValueHolderComponent
     * @since 0.0.1
     */
    interface ModifiableNumericComponent<N extends Number> extends ModifiableValueHolderComponent<N> {
        /**
         * add given number to component's current value.
         *
         * @param rhs - value to add.
         */
        void add(@NotNull N rhs);

        /**
         * subtract given number from component's current value.
         *
         * @param rhs - value to subtract.
         */
        void subtract(@NotNull N rhs);

        /**
         * multiply component's current value by given number.
         *
         * @param rhs - value to multiply by.
         */
        void multiply(@NotNull N rhs);

        /**
         * divide component's current value by given number.
         *
         * @param rhs - value to divide by.
         */
        void divide(@NotNull N rhs);

        /**
         * increase component's current value by one.
         */
        void increase();

        /**
         * decrease component's current value by one.
         */
        void decrease();

        /**
         * Modifiable version of {@link IntegerValue}.
         *
         * @since 0.0.1
         */
        interface ModifiableIntegerValue extends ModifiableNumericComponent<Integer>, IntegerValue {

        }

        /**
         * Modifiable version of {@link LongValue}.
         *
         * @since 0.0.1
         */
        interface ModifiableLongValue extends ModifiableNumericComponent<Long>, LongValue {

        }

        /**
         * Modifiable version of {@link FloatValue}.
         *
         * @since 0.0.1
         */
        interface ModifiableFloatValue extends ModifiableNumericComponent<Float>, FloatValue {

        }
    }
}
