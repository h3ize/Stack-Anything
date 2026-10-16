package com.stackanything.mixin;

import com.mojang.serialization.Codec;
import com.stackanything.StackSizes;
import net.minecraft.util.ExtraCodecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ExtraCodecs.class)
public abstract class ExtraCodecsMixin {
    @Inject(method = "intRange(II)Lcom/mojang/serialization/Codec;", at = @At("HEAD"), cancellable = true)
    private static void stackanything$widenStackRange(int min, int max, CallbackInfoReturnable<Codec<Integer>> cir) {
        if (min == 1 && max == 99) {
            cir.setReturnValue(ExtraCodecs.intRange(1, StackSizes.HARD_LIMIT));
        }
    }
}
