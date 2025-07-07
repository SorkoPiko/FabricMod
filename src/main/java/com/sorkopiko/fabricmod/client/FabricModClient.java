package com.sorkopiko.fabricmod.client;

import com.sorkopiko.fabricmod.config.FabricModConfig;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entrypoint
public class FabricModClient implements ClientModInitializer {
    public static final String MOD_ID = "fabricmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("FabricMod initialized!");

        FabricModConfig.HANDLER.load();
    }
}
