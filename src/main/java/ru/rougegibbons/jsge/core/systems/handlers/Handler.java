package ru.rougegibbons.jsge.core.systems.handlers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.systems.messages.Message;

import java.util.function.Function;

/**
 * base interface for classes responsible for handling messaging on low-level (concrete message classes).
 *
 * @param <T> - class or interface of the context-providing object to handle
 * @param <R> - class or interface of the context-providing object storing the result.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @since 0.0.1
 */
public interface Handler<T, R> extends JsgeObject, Function<@NotNull T, @Nullable R> {
    /**
     * {@link Handler} interface extension for handlers dealing
     * with {@link Message} interface implementations and their derivatives.
     *
     * @param <I> - {@link Message} interface implementation or its derivative storing the input.
     * @see Message
     * @since 0.0.1
     */
    interface MessageHandler<I extends Message> extends Handler<I, Message> {

    }
}
