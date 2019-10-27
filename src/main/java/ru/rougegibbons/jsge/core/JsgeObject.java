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

    /**
     * check if this object is to be removed from its manager's pool.
     *
     * @return true if the object is about to be removed, false otherwise.
     */
    @NotNull Boolean isToRemove();

    /**
     * mark object to be removed from its manager's pool.
     */
    void markToRemove();
}
