package ru.rougegibbons.jsge.core.systems.managers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.jsge.core.Handle;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.collections.ConcurrentPool;

/**
 * {@link ConcurrentPool} extension representing systems that control various objects' lifecycle.
 *
 * @param <T> - any class extending {@link JsgeObject}.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see Handle
 * @see ConcurrentPool
 * @since 0.0.1
 */
public interface Manager<T extends JsgeObject> extends ConcurrentPool<T> {
    /**
     * check if object with given handle belongs to the manager.
     *
     * @param handle - object's handle.
     * @return true if object with this handle belongs to this manager, false otherwise.
     */
    default @NotNull Boolean hasObject(@NotNull Handle handle) {
        return handle.getManagerId().equals(getId()) && containsKey(handle.getObjectId());
    }

    /**
     * create new object of class {@link T} using its default constructor.
     */
    void createObject();

    /**
     * destroy object by handle.
     *
     * @param handle {@link Handle} of the object to destroy.
     */
    default void destroyObject(@NotNull Handle handle) {
        if (hasObject(handle)) {
            remove(handle.getObjectId());
            handle.invalidate();
        }
    }

    /**
     * get stored object by given {@link Handle}.
     *
     * @param handle - given {@link Handle} to get requested object by.
     * @return requested object if given handle belongs to this manager and is valid, null otherwise.
     */
    default @Nullable T get(@NotNull Handle handle) {
        return hasObject(handle) ? get(handle.getObjectId()) : null;
    }
}
