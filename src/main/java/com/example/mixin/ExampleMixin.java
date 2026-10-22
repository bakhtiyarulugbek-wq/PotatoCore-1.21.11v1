package com.example.mixin;

import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public class ExampleMixin {
    private int potatoCounter = 0;

    @Inject(method = "aiStep", at = @At("HEAD"), cancellable = true)
    private void freezeFarMobs(CallbackInfo ci) {
        Mob mob = (Mob) (Object) this;
        // Если моб ни с кем не сражается и просто бродит вдали
        if (mob.getTarget() == null) {
            potatoCounter++;
            // Пропускаем 3 из 4 тиков поиска пути, спасая ядра процессора
            if (potatoCounter % 4 != 0) {
                ci.cancel();
            }
        }
    }
}
