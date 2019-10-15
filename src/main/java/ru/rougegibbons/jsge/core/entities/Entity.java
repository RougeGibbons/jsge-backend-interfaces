package ru.rougegibbons.jsge.core.entities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.collections.Pool;
import ru.rougegibbons.jsge.core.components.Component;

/**
 * {@link JsgeObject} interface extension describing generic interface for entities.
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see Pool.ComponentPool
 * @since 0.0.1
 */
public interface Entity extends JsgeObject {
    /**
     * get all components attached to the entity.
     *
     * @return {@link Pool.ComponentPool} storing all entity's components.
     */
    @NotNull Pool.ComponentPool getComponents();

    /**
     * get entity's component by key value.
     *
     * @param componentId - {@link Long} key of the component to get.
     * @return some {@link Component}'s derivative implementation instance if such key is present in entity's {@link Pool.ComponentPool}, null otherwise.
     */
    default @Nullable Component getComponent(@NotNull Long componentId) {
        return getComponents().getOrDefault(componentId, null);
    }
}
