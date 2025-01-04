package com.clasealuracursos.clasescreenmatch.service;

public interface IConvierteDatos {
    <T>T obtenerDatos(String json, Class<T> clase);
}
