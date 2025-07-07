package com.sorkopiko.fabricmod.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class FabricModConfig {
    public static ConfigClassHandler<FabricModConfig> HANDLER = ConfigClassHandler.createBuilder(FabricModConfig.class)
            .id(Identifier.of("fabricmod", "config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("fabricmod.json5"))
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean configOption = true;
}
