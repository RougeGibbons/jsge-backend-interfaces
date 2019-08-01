package ru.rougegibbons.jsge.core.collections;

import ru.rougegibbons.jsge.core.Handle;
import ru.rougegibbons.jsge.core.JsgeObject;

import java.util.concurrent.ConcurrentMap;

/**
 * {@link Pool} extension for multi-threaded usage.
 *
 * @param <T> - any class implementing {@link JsgeObject} interface.
 * @author Kirill Cherkasov
 * @see Pool
 * @see JsgeObject
 * @see ConcurrentMap
 * @see Long
 * @since 0.0.1
 */
public interface ConcurrentPool<T extends JsgeObject> extends Pool<T>, ConcurrentMap<Long, T> {
    /**
     * {@link ConcurrentPool} extension for storing handles.
     *
     * @author Kirill Cherkasov
     * @see ConcurrentPool
     * @see Handle
     * @since 0.0.1
     */
    interface HandlesPool extends ConcurrentPool<Handle> {

    }
}
