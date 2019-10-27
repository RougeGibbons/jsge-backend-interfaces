package ru.rougegibbons.jsge.core.components.mxins;

import org.jetbrains.annotations.NotNull;

/**
 * mixin for the components with modifiable contents.
 *
 * @param <T> - component's stored value class.
 * @author Kirill Cherkasov
 * @since 0.0.1
 */
public interface Modifiable<T> {
    void setValue(@NotNull T newValue);
}
