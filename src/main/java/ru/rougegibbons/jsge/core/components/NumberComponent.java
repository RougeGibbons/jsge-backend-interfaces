package ru.rougegibbons.jsge.core.components;

import org.jetbrains.annotations.NotNull;

/**
 * {@link Component} interface extension for number components.
 *
 * @param <N> - any {@link Number} class derivative.
 * @author Kirill Cherkasov
 * @see Component
 * @see Number
 * @since 0.0.1
 */
public interface NumberComponent<N extends Number> extends Component {
    /**
     * get value stored in this component.
     *
     * @return value stored in this component.
     */
    @NotNull N getValue();
}
