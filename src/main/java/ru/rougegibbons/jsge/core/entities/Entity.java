package ru.rougegibbons.jsge.core.entities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.jsge.core.Handle;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.collections.Pool;
import ru.rougegibbons.jsge.core.components.Component;

/**
 * {@link JsgeObject} interface extension describing generic interface for entities.
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see Pool.HandlesPool
 * @since 0.0.1
 */
public interface Entity extends JsgeObject {
    /**
     * get all components attached to the entity.
     *
     * @return {@link Pool.ComponentPool} storing all entity's components.
     */
    @NotNull Pool.HandlesPool getComponents();

    /**
     * get entity's component by key value.
     *
     * @param componentLabel - {@link Long} key of the component to get.
     * @return some {@link Component}'s derivative implementation instance if such key is present in entity's {@link Pool.ComponentPool}, null otherwise.
     */
    default @Nullable Handle getComponent(@NotNull Long componentLabel) {
        return getComponents().getOrDefault(componentLabel, null);
    }

    /**
     * add new component to the entity.
     *
     * @param componentLabel - label to attach to the new component.
     * @param toAdd          - component to add.
     */
    default void addComponent(@NotNull Long componentLabel,
                              @NotNull Handle toAdd) {
        if (!getComponents().containsKey(componentLabel)) {
            getComponents().put(componentLabel, toAdd);
        }
    }

    /**
     * remove component by label.
     *
     * @param componentLabel - label of the component to be removed.
     * @param invalidate     - is component handle to be invalidated before removal.
     */
    default void removeComponent(@NotNull Long componentLabel, @NotNull Boolean invalidate) {
        if (getComponents().containsKey(componentLabel)) {
            if (invalidate) {
                getComponents().get(componentLabel).invalidate();
            }
            getComponents().remove(componentLabel);
        }
    }

    /**
     * remove component by handle.
     *
     * @param toRemove - handle to remove.
     */
    default void removeComponent(@NotNull Handle toRemove) {
        for (Long componentLabel : getComponents().keySet()) {
            if (getComponents().get(componentLabel).equals(toRemove)) {
                getComponents().remove(componentLabel);
                break;
            }
        }
    }
}
