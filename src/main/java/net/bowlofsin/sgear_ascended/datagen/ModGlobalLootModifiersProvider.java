package net.bowlofsin.sgear_ascended.datagen;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SGearAscendedMod.MODID);
    }

    @Override
    protected void start() {
        add("mana_crystal_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.03f).build(),

        }, ModItems.MANA_CRYSTAL.get()));
    }
}
