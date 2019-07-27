package ru.rougegibbons.jsge.core;

import java.util.Map;

/**
 * {@link JsgeObject} extension describing map-like object pools.
 *
 * @param <T> - any class implementing {@link JsgeObject} interface or its extension.
 * @author Kirill Cherkasov
 * @see JsgeObject
 * @see Map
 * @see Long
 * @since 0.0.1
 */
public interface Pool<T extends JsgeObject> extends JsgeObject, Map<Long, T> {

}
