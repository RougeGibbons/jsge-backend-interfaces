package ru.rougegibbons.jsge.core.systems;

import org.jetbrains.annotations.NotNull;
import ru.rougegibbons.jsge.core.JsgeObject;
import ru.rougegibbons.jsge.engine.versions.VersionInfo;

/**
 * {@link JsgeObject} extension representing systems - engine parts covering large,
 * logically connected parts of functionality (e.g. game mechanics, resources, databases, graphics, etc.)
 *
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see VersionInfo
 * @since 0.0.1
 */
public interface System extends JsgeObject {
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
}
