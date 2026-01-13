package com.example.plugin.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class ExampleConfig {
    // Codec for serializing and deserializing the ExampleConfig class.
    public static final BuilderCodec<ExampleConfig> CODEC = BuilderCodec
            .builder(ExampleConfig.class, ExampleConfig::new)
            .append(new KeyedCodec<String>("Text", Codec.STRING),
                    (oldConfig, newValue, extraInfo) -> oldConfig.text = newValue, // Setter
                    (oldConfig, extraInfo) -> oldConfig.text)// Getter
            .add()
            .append(new KeyedCodec<Boolean>("Bool", Codec.BOOLEAN),
                    (oldConfig, newValue, extraInfo) -> oldConfig.bool = newValue, // Setter
                    (oldConfig, extraInfo) -> oldConfig.bool) // Getter
            .add()
            .append(new KeyedCodec<Integer>("Number", Codec.INTEGER),
                    (oldConfig, newValue, extraInfo) -> oldConfig.number = newValue, // Setter
                    (oldConfig, extraInfo) -> oldConfig.number) // Getter
            .add()
            .build();

    // Configuration fields.
    private String text = "Welcome to the server!";
    private boolean bool = true;
    private int number = 100;

    // Default empty constructor.
    public ExampleConfig() {
    }

    // Getters for the configuration fields.
    public String getText() {
        return text;
    }

    public boolean isBool() {
        return bool;
    }

    public int getNumber() {
        return number;
    }
}
