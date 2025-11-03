package us.codezzops.zombii.rosegold.mixin.client

import net.minecraft.client.MinecraftClient
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(MinecraftClient::class)
class ExampleClientMixin {

    @Inject(at = [At("HEAD")], method = ["run"])
    fun runInject(info: CallbackInfo) {

    }

}