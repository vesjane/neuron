package org.kimrgrey.neuron.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * Класс, который отвечает за формирование списка доступных веб-сервису ресурсов.
 * 
 * @author Сергей Цветков
 */
public class WebServiceApplication extends Application {
    /**
     * Набор синглтонов, которые используются веб-сервисом.
     */
    private final Set<Object> singletons = new HashSet<Object>();
    /**
     * Набор ресурсов, которые используются веб-сервисом.
     */
    private final Set<Class<?>> resources = new HashSet<Class<?>>();

    /**
     * Конструктор по умолчанию. Создает список ресурсов, доступных сервису во время исполнения.
     */
    public WebServiceApplication() {
        resources.add(NetworksWebResource.class);
    }

    /**
     * Получение списка доступных синглтонов.
     * 
     * @return Возвращает список синглтонов, доступных веб-сервису.
     */
    public Set<Object> getSingletons() {
        return singletons;
    }

    /**
     * Получение списка доступных ресурсов.
     * 
     * @return Возвращает список ресурсов, доступных веб-сервису.
     */
    public Set<Class<?>> getClasses() {
        return resources;
    }
}