package com.sorkopiko.fabricmod.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.minecraft.text.Text;

@Entrypoint
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> YetAnotherConfigLib.createBuilder()
                .title(Text.literal("FabricMod Configuration"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Category"))
                        .tooltip(Text.literal("Category description"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Group"))
                                .description(OptionDescription.of(Text.literal("Group description")))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Config Option"))
                                        .description(OptionDescription.of(Text.literal("Option description")))
                                        .binding(
                                                true,
                                                () -> FabricModConfig.HANDLER.instance().configOption,
                                                option -> FabricModConfig.HANDLER.instance().configOption = option)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .build())
                        .build())
                .save(FabricModConfig.HANDLER::save)
                .build()
                .generateScreen(parentScreen);
    }
}
