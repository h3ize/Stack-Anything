package com.stackanything;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue STACK_SIZE = BUILDER
            .comment("Max stack size for items that normally do not stack (totems, beds, tools, etc). Maximum is 1500.")
            .defineInRange("stackSize", 1500, 2, StackSizes.HARD_LIMIT);

    private static final ModConfigSpec.BooleanValue RAISE_STACKABLE = BUILDER
            .comment("Also raise items that already stack (like ender pearls or snowballs) up to stackSize.")
            .define("raiseStackableItems", false);

    private static final ModConfigSpec.BooleanValue INCLUDE_DAMAGEABLE = BUILDER
            .comment("Allow tools, weapons and armor (anything with durability) to stack. Off by default.")
            .define("includeDamageable", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int stackSize() {
        try {
            return STACK_SIZE.get();
        } catch (IllegalStateException e) {
            return StackSizes.HARD_LIMIT;
        }
    }

    public static boolean raiseStackableItems() {
        try {
            return RAISE_STACKABLE.get();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public static boolean includeDamageable() {
        try {
            return INCLUDE_DAMAGEABLE.get();
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
