package com.example.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class ExampleMixin {
    private int potatoTickCounter = 0;

    @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
    private void freezeFarMobs(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance(
