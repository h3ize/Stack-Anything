package com.stackanything;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;

public final class StackSizes {
    public static final int HARD_LIMIT = 1500;

    private StackSizes() {
    }

    public static int adjust(Item item, int current) {
        int size = Config.stackSize();
        if (current >= size) {
            return current;
        }
        if (!Config.includeDamageable() && item.components().has(DataComponents.MAX_DAMAGE)) {
            return current;
        }
        if (current == 1 || Config.raiseStackableItems()) {
            return size;
        }
        return current;
    }
}
