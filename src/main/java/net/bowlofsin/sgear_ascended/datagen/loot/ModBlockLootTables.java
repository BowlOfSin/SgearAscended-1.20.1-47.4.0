package net.bowlofsin.sgear_ascended.datagen.loot;

import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.block.crops.FertileOFruitCropBlock;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MANA_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_MANA_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.MANA_CRYSTAL_STAIRS.get());
        this.add(ModBlocks.MANA_CRYSTAL_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(ModBlocks.MANA_CRYSTAL_BUTTON.get());
        this.add(ModBlocks.MANA_CRYSTAL_DOOR.get(), this::createDoorTable);
        this.dropSelf(ModBlocks.MANA_CRYSTAL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MANA_CRYSTAL_FENCE.get());
        this.dropSelf(ModBlocks.MANA_CRYSTAL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MANA_CRYSTAL_WALL.get());
        this.dropSelf(ModBlocks.MANA_CRYSTAL_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MILKING_STATION.get());

//        this.dropSelf(ModBlocks.MANA_INFUSED_FURNACE.get());

        LootItemCondition.Builder lootitemcondition$fertileofuitbuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.FERTILEOFRUIT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FertileOFruitCropBlock.AGE, 5));

        this.add(ModBlocks.FERTILEOFRUIT_CROP.get(), this.createCropDrops(ModBlocks.FERTILEOFRUIT_CROP.get(), ModItems.FERTILEOFRUIT.get(),
                ModItems.FERTILEOFRUIT_SEEDS.get(), lootitemcondition$fertileofuitbuilder));

        this.add(ModBlocks.MANA_CRYSTAL_ORE.get(),
                block -> createBaseMultiplicativeOreDrops(ModBlocks.MANA_CRYSTAL_ORE.get(), ModItems.RAW_MANA_CRYSTAL.get(), 2f, 4f));
        this.add(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),
                block -> createBaseMultiplicativeOreDrops(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(), ModItems.RAW_MANA_CRYSTAL.get(), 2f, 5f));
        this.add(ModBlocks.NETHER_MANA_CRYSTAL_ORE.get(),
                block -> createBaseMultiplicativeOreDrops(ModBlocks.NETHER_MANA_CRYSTAL_ORE.get(), ModItems.RAW_MANA_CRYSTAL.get(), 2f, 6f));
        this.add(ModBlocks.END_MANA_CRYSTAL_ORE.get(),
                block -> createBaseMultiplicativeOreDrops(ModBlocks.END_MANA_CRYSTAL_ORE.get(), ModItems.RAW_MANA_CRYSTAL.get(), 3f, 9f));


        this.dropSelf(ModBlocks.MYSTICAL_LOG.get());
        this.dropSelf(ModBlocks.MYSTICAL_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MYSTICAL_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MYSTICAL_WOOD.get());
        this.dropSelf(ModBlocks.MYSTICAL_PLANKS.get());
        this.dropSelf(ModBlocks.MYSTICAL_SAPLING.get());

        this.add(ModBlocks.MYSTICAL_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.MYSTICAL_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }


    protected LootTable.Builder createBaseMultiplicativeOreDrops(Block pBlock, Item pItem, Float pMin, Float pMax) {
        return createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(pItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(pMin, pMax)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
