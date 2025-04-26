package net.bowlofsin.sgear_ascended.datagen;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SGearAscendedMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Some vanilla additions
//        this.tag(BlockTags.TOO).addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);
//        this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL).addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);
//        this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL).addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);
//        this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL).addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);
//        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);
//        this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).addTag(ModTags.Blocks.NEEDS_ARCANITE_TOOL);


        // Actual new tags

        this.tag(ModTags.Blocks.MUNCHER_COW_EDIBLE)
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MANA_CRYSTAL_PRESSURE_PLATE.get())
                .add(ModBlocks.MANA_CRYSTAL_WALL.get())
                .add(ModBlocks.MANA_CRYSTAL_SLAB.get())
                .add(ModBlocks.MANA_CRYSTAL_FENCE_GATE.get())
                .add(ModBlocks.MANA_CRYSTAL_TRAPDOOR.get())
                .add(ModBlocks.MANA_CRYSTAL_FENCE.get())
                .add(ModBlocks.MANA_CRYSTAL_BUTTON.get())
                .add(ModBlocks.MANA_CRYSTAL_STAIRS.get())
                .add(ModBlocks.MANA_CRYSTAL_DOOR.get())
                .add(ModBlocks.MANA_CRYSTAL_BLOCK.get())
                .add(ModBlocks.MANA_CRYSTAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_MANA_CRYSTAL_ORE.get())
                .add(ModBlocks.END_MANA_CRYSTAL_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MANA_CRYSTAL_BLOCK.get(),
                        ModBlocks.MANA_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get(),
                        ModBlocks.NETHER_MANA_CRYSTAL_ORE.get(),
                        ModBlocks.END_MANA_CRYSTAL_ORE.get(),
                        ModBlocks.MANA_CRYSTAL_PRESSURE_PLATE.get(),
                        ModBlocks.MANA_CRYSTAL_WALL.get(),
                        ModBlocks.MANA_CRYSTAL_SLAB.get(),
                        ModBlocks.MANA_CRYSTAL_FENCE_GATE.get(),
                        ModBlocks.MANA_CRYSTAL_TRAPDOOR.get(),
                        ModBlocks.MANA_CRYSTAL_FENCE.get(),
                        ModBlocks.MANA_CRYSTAL_BUTTON.get(),
                        ModBlocks.MANA_CRYSTAL_STAIRS.get(),
                        ModBlocks.MANA_CRYSTAL_DOOR.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MANA_CRYSTAL_FENCE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MANA_CRYSTAL_WALL.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MANA_CRYSTAL_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.MANA_CRYSTAL_DOOR.get());


        this.tag(BlockTags.CROPS)
                .add(ModBlocks.FERTILEOFRUIT_CROP.get());

        this.tag(BlockTags.MAINTAINS_FARMLAND)
                .add(ModBlocks.FERTILEOFRUIT_CROP.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTICAL_LOG.get())
                .add(ModBlocks.MYSTICAL_WOOD.get())
                .add(ModBlocks.STRIPPED_MYSTICAL_LOG.get())
                .add(ModBlocks.STRIPPED_MYSTICAL_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MYSTICAL_PLANKS.get());
    }
}
