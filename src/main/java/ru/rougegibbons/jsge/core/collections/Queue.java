package ru.rougegibbons.jsge.core.collections;

import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.systems.messages.Message;

/**
 * default generic interface for queues.
 *
 * @param <T> - any class implementing {@link JsgeObject} interface or its extensions.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see java.util.Queue
 * @since 0.0.1
 */
public interface Queue<T extends JsgeObject> extends JsgeObject, java.util.Queue<T> {
    /**
     * {@link Queue} interface extensions for dealing with {@link Message} queues.
     *
     * @author Kirill Cherkasov
     * @see Message
     * @since 0.0.1
     */
    interface Mailbox extends Queue<Message> {

    }
}
