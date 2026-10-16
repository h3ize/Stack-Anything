package com.stackanything.mixin;

import com.stackanything.StackSizes;
import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Container.class)
public interface ContainerMixin {
    @Overwrite
    default int getMaxStackSize() {
        return StackSizes.HARD_LIMIT;
    }
}
