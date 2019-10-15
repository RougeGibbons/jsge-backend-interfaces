package ru.rougegibbons.jsge.core;

import org.jetbrains.annotations.NotNull;

/**
 * interface for generic JSGE objects.
 *
 * @author Kirill Cherkasov
 * @since 0.0.1
 */
public interface JsgeObject {
    /**
     * get object id.
     *
     * @return object id.
     */
    @NotNull Long getId();
}
