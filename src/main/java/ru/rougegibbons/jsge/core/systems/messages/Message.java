package ru.rougegibbons.jsge.core.systems.messages;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.jsge.core.JsgeObject;

/**
 * {@link JsgeObject} extension for all messages.
 * Message is a way to send a command from one {@link JsgeObject} to another.
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @since 0.0.1
 */
public interface Message extends JsgeObject {
    /**
     * check if message is blocking.
     *
     * @return true if the operation requires blocking, false otherwise.
     */
    @NotNull Boolean isBlocking();

    /**
     * get this message's current status.
     *
     * @return this message's current {@link MessageStatus} code.
     */
    @NotNull MessageStatus getStatus();

    /**
     * check if the message is pending for being processed.
     *
     * @return true if this message is pending, false otherwise.
     */
    default @NotNull Boolean isPending() {
        return getStatus() == MessageStatus.MS_PENDING;
    }

    /**
     * check if the message is in progress.
     *
     * @return true if this message is in progress, false otherwise.
     */
    default @NotNull Boolean isInProgress() {
        return getStatus() == MessageStatus.MS_IN_PROGRESS;
    }

    /**
     * check if this message already processed.
     *
     * @return true if the message is processed, false otherwise.
     */
    default @NotNull Boolean isProcessed() {
        return getStatus() == MessageStatus.MS_PROCESSED;
    }

    /**
     * raises message's status - pending becomes in progress, in progress becomes processed.
     */
    void raiseStatus();
}
