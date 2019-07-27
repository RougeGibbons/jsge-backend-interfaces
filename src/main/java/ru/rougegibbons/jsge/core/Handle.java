package ru.rougegibbons.jsge.core;

import org.jetbrains.annotations.NotNull;

/**
 * Innterface implementing object handle.
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @since 0.0.1
 */
public interface Handle extends JsgeObject {
    /**
     * get object id.
     *
     * @return id of the object handle represents.
     */
    @NotNull Long getObjectId();

    /**
     * get manager id.
     *
     * @return id of the manager that stores object represented by handle.
     */
    @NotNull Long getManagerId();

    /**
     * check if handle is still valid and can be dereferenced.
     *
     * @return true if handle is valid, false otherwise.
     */
    @NotNull Boolean isValid();

    /**
     * invalidate handle.
     */
    void invalidate();
}
