package ru.rougegibbons.jsge.core.systems.handlers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.systems.messages.Message;

/**
 * base interface for classes responsible for handling messaging on low-level (concrete message classes).
 *
 * @param <IT> - class or interface of the context-providing object to handle, in form being passed to process() method.
 * @param <IR> - class or interface of the context-providing object storing the result, in form being returned from process() method.
 * @param <R>  - class or interface of the context-providing object storing the result.
 * @param <T>  - class or interface of the context-providing object to handle.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @since 0.0.1
 */
public interface Handler<IT, T, IR, R> extends JsgeObject {
    /**
     * get input class data.
     *
     * @return input class data.
     */
    @NotNull Class<T> getInputClass();

    /**
     * get result class data.
     *
     * @return result class data.
     */
    @NotNull Class<R> getResultClass();

    /**
     * process input data into some (optional result).
     *
     * @param input - data input.
     * @return some result data or null.
     */
    @Nullable IR process(@NotNull IT input);

    /**
     * {@link Handler} interface extension for handlers dealing
     * with {@link Message} interface implementations and their derivatives.
     *
     * @param <R> - class or interface of the context-providing object storing the result.
     * @param <T> - class or interface of the context-providing object to handle.
     * @see Message
     * @since 0.0.1
     */
    interface MessageHandler<T, R> extends Handler<Message, T, Message, R> {
    }
}
