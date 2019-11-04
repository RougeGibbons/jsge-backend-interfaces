package ru.rougegibbons.jsge.core.systems;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.core.collections.Queue;
import ru.rougegibbons.jsge.core.systems.handlers.HandlerProvider;
import ru.rougegibbons.jsge.engine.versions.VersionInfo;

/**
 * {@link JsgeObject} extension representing systems - engine parts covering large,
 * logically connected parts of functionality (e.g. game mechanics, resources, databases, graphics, etc.)
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see HandlerProvider
 * @see VersionInfo
 * @since 0.0.1
 */
public interface System extends JsgeObject, HandlerProvider {
    /**
     * get system's version.
     *
     * @return system's version as {@link VersionInfo} instance.
     */
    @NotNull VersionInfo getVersion();

    /**
     * performs single system tick.
     */
    void update();

    /**
     * get inbox messages queue.
     *
     * @return inbox messages queue.
     */
    @NotNull Queue.Mailbox getInbox();

    /**
     * get outbox messages queue.
     *
     * @return outbox messages queue.
     */
    @NotNull Queue.Mailbox getOutbox();

    /**
     * check if this system is idle at the moment.
     *
     * @return true if this system has no inbox messages to process, false otherwise.
     */
    default @NotNull Boolean isIdle() {
        return getInbox().isEmpty();
    }
}
