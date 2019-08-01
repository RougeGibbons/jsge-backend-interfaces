package ru.rougegibbons.jsge.core.components;

import org.jetbrains.annotations.NotNull;

/**
 * {@link Component} interface extension for various text components.
 *
 * @author Kirill Cherkasov
 * @see Component
 * @see String
 * @since 0.0.1
 */
public interface TextComponent extends Component {
    /**
     * get stored value.
     *
     * @return value stored in this component.
     */
    @NotNull String getValue();
}
