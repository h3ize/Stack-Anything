package com.stackanything.mixin;

import com.stackanything.StackSizes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract Item getItem();

    @Inject(method = "getMaxStackSize", at = @At("RETURN"), cancellable = true)
    private void stackanything$maxStackSize(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(StackSizes.adjust(this.getItem(), cir.getReturnValue()));
    }
}
