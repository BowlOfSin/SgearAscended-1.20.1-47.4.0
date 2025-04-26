package net.bowlofsin.sgear_ascended.datagen;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SGearAscendedMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.PICKAXES).add(ModItems.ARCANITE_PICKAXE.get());

        this.tag(ModTags.Items.ARCANITE_TOOL_MATERIALS).add(ModItems.ARCANITE_INGOT.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARCANITE_HELMET.get(),
                        ModItems.ARCANITE_CHESTPLATE.get(),
                        ModItems.ARCANITE_BOOTS.get(),
                        ModItems.ARCANITE_LEGGINGS.get());


        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTICAL_LOG.get().asItem())
                .add(ModBlocks.MYSTICAL_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MYSTICAL_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MYSTICAL_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.MYSTICAL_PLANKS.get().asItem());
    }
}
