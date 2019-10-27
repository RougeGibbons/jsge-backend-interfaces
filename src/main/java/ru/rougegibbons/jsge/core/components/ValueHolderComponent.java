package ru.rougegibbons.jsge.core.components;

import jdk.internal.jline.internal.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.jsge.core.components.mxins.Modifiable;

/**
 * {@link Component} interface extension for components that store values.
 *
 * @param <T> - stored value type.
 * @author Kirill Cherkasov
 * @see Component
 * @since 0.0.1
 */
public interface ValueHolderComponent<T> extends Component {
    /**
     * get stored value.
     *
     * @return stored value.
     */
    @Nullable
    T getValue();

    /**
     * check if component's contents is empty.
     *
     * @return true if stored value is null, false otherwise.
     */
    default @NotNull Boolean isEmpty() {
        return getValue() == null;
    }

    /**
     * {@link ValueHolderComponent} interface extensions for components with modifiable contents.
     *
     * @param <T> - stored value type.
     * @since 0.0.1
     */
    interface ModifiableValueHolderComponent<T> extends ValueHolderComponent<T>, Modifiable<T> {

    }
}
