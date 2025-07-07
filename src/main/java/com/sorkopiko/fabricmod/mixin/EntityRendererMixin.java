package com.sorkopiko.fabricmod.mixin;

import com.sorkopiko.fabricmod.client.FabricModClient;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class) @MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class EntityRendererMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void initDispatcher(EntityRendererFactory.Context ctx, CallbackInfo ci) {
        FabricModClient.LOGGER.info("EntityRendererMixin initialized!");
    }
}
