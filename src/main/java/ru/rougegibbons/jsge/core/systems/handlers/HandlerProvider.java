package ru.rougegibbons.jsge.core.systems.handlers;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.systems.messages.Message;

/**
 * interface mixin for classes and interfaces responsible for message handling.
 *
 * @see Handler
 * @since 0.0.1
 */
public interface HandlerProvider {
    /**
     * register handler for given class.
     *
     * @param toRegister - class to register handler for.
     * @param handler    - {@link Handler} interface implementation responsible for given class.
     * @param <T>        - class to register handler for.
     * @param <R>        - response type class.
     */
    <T extends JsgeObject, R extends JsgeObject> void registerHandler(@NotNull Class<T> toRegister,
                                                                      @NotNull Handler<T, R> handler);

    /**
     * unregister handler for given class.
     *
     * @param toUnregister - class to be unregistered as {@link Class} instance.
     * @param <T>          - class to be unregistered
     */
    <T extends JsgeObject> void unregisterHandler(@NotNull Class<T> toUnregister);

    /**
     * {@link HandlerProvider} extension for providers responsible for dealing with in-game messages.
     *
     * @see Message
     * @since 0.0.1
     */
    interface MessageHandlerProvider extends HandlerProvider {
        /**
         * see {@link HandlerProvider}.
         *
         * @param toRegister - see {@link HandlerProvider}.
         * @param handler    - see {@link HandlerProvider}.
         * @param <T>        - see {@link HandlerProvider}.
         */
        <T extends Message> void registerHandler(@NotNull Class<T> toRegister,
                                                 @NotNull Handler.MessageHandler<T> handler);
    }
}
