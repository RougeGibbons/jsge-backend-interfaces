package ru.rougegibbons.jsge.core.collections;

import ru.rougegibbons.jsge.core.Handle;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.components.Component;

import java.util.Map;

/**
 * {@link JsgeObject} extension describing map-like object pools.
 *
 * @param <T> - any class implementing {@link JsgeObject} interface or its extension.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see Map
 * @see Long
 * @since 0.0.1
 */
public interface Pool<T extends JsgeObject> extends JsgeObject, Map<Long, T> {
    /**
     * {@link Pool} interface extension for storing {@link Component} collections.
     *
     * @author Kirill Cherkasov
     * @see Pool
     * @see Component
     * @since 0.0.1
     */
    interface ComponentPool extends Pool<Component> {

    }

    /**
     * {@link Pool} interface extension for storing {@link Handle} collections.
     *
     * @author Kirill Cherkasov
     * @see Pool
     * @see Handle
     * @since 0.0.1
     */
    interface HandlesPool extends Pool<Handle> {

    }
}
