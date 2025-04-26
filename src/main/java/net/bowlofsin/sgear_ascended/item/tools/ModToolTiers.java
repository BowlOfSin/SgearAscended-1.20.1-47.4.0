package net.bowlofsin.sgear_ascended.item.tools;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.tag.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ARCANITE = TierSortingRegistry.registerTier(
            new ForgeTier(10, 10000, 20f, 150, 100,
                    ModTags.Blocks.NEEDS_ARCANITE_TOOL, () -> Ingredient.of(ModItems.ARCANITE_INGOT.get())),
            ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID, "arcanite"), List.of(Tiers.NETHERITE), List.of());
}
