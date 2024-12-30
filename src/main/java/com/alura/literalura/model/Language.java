package com.alura.literalura.model;

import java.util.Arrays;

public enum Language {
    SPANISH("es"), ENGLISH("en"), FRENCH("fr"), PORTUGUESE("pt");

    private final String idioma;

    Language(String idioma) {
        this.idioma = idioma;
    }

    public static Language fromString(String text) {
        return Arrays.stream(values())
                .filter(lang -> lang.idioma.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Idioma no válido: " + text));
    }
}


