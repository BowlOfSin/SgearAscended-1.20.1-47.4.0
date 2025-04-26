package net.bowlofsin.sgear_ascended.tag;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        // Vanilla+ tags
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");

        //New tags
        public static final TagKey<Block> MUNCHER_COW_EDIBLE = tag("muncher_cow_edible");
        public static final TagKey<Block> NEEDS_INFUSED_TOOL = tag("needs_infused_tool");
        public static final TagKey<Block> NEEDS_ARCANITE_TOOL = tag("needs_arcanite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ARCANITE_TOOL = tag("incorrect_for_arcanite_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ARCANITE_TOOL_MATERIALS = bind("arcanite_tool_materials");
        public static final TagKey<Item> REPAIRS_ARCANITE_ARMOR = bind("repairs_arcanite_armor");


        private static TagKey<Item> bind(String pName) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID, pName));
        }
    }

    public static class Entities {

    }
}
