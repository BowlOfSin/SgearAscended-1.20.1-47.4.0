package net.bowlofsin.sgear_ascended;

import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SGearAscendedMod.MODID);

    public static final RegistryObject<CreativeModeTab> MILKY_INGREDIENS_TAB = CREATIVE_MODE_TABS.register("milky_ingredients_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MANA_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.milky_ingredients_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MANA_CRYSTAL.get());
                        pOutput.accept(ModItems.RAW_MANA_CRYSTAL.get());

                        pOutput.accept(ModBlocks.MANA_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_MANA_CRYSTAL_BLOCK.get());

                        pOutput.accept(ModBlocks.MANA_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_MANA_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.END_MANA_CRYSTAL_ORE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_TOOLS_TAB = CREATIVE_MODE_TABS.register("milky_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COW_DETECTOR.get()))
                    .title(Component.translatable("creativetab.milky_tools_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COW_DETECTOR.get());
                        pOutput.accept(ModItems.ARCANITE_PICKAXE.get());
                        pOutput.accept(ModItems.ARCANITE_AXE.get());
                        pOutput.accept(ModItems.ARCANITE_SWORD.get());
                        pOutput.accept(ModItems.ARCANITE_SHOVEL.get());
                        pOutput.accept(ModItems.ARCANITE_HOE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_FOODS_TAB = CREATIVE_MODE_TABS.register("milky_foods_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RICH_MILK_BUCKET.get()))
                    .title(Component.translatable("creativetab.milky_foods_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RICH_MILK_BUCKET.get());
                        pOutput.accept(ModItems.FERTILEOFRUIT_SEEDS.get());
                        pOutput.accept(ModItems.FERTILEOFRUIT.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_BUILDING_TAB = CREATIVE_MODE_TABS.register("milky_building_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MANA_CRYSTAL_BLOCK.get()))
                    .title(Component.translatable("creativetab.milky_building_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_MANA_CRYSTAL_BLOCK.get());

                        pOutput.accept(ModBlocks.MYSTICAL_LOG.get());
                        pOutput.accept(ModBlocks.MYSTICAL_WOOD.get());
                        pOutput.accept(ModBlocks.MYSTICAL_PLANKS.get());
                        pOutput.accept(ModBlocks.STRIPPED_MYSTICAL_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_MYSTICAL_WOOD.get());
                        pOutput.accept(ModBlocks.MYSTICAL_LEAVES.get());
                        pOutput.accept(ModBlocks.MYSTICAL_SAPLING.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_DECORATIVE_TAB = CREATIVE_MODE_TABS.register("milky_decorative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MANA_CRYSTAL_DOOR.get()))
                    .title(Component.translatable("creativetab.milky_decorative_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_DOOR.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_STAIRS.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_SLAB.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_WALL.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_TRAPDOOR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_FUNCTIONAL_TAB = CREATIVE_MODE_TABS.register("milky_functional_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MANA_CRYSTAL_BUTTON.get()))
                    .title(Component.translatable("creativetab.milky_functional_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_BUTTON.get());
//                        pOutput.accept(ModBlocks.MANA_INFUSED_FURNACE.get());
                        pOutput.accept(ModBlocks.MANA_CRYSTAL_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.MILKING_STATION.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MILKY_MISC_TAB = CREATIVE_MODE_TABS.register("milky_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BULL_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.milky_misc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BULL_SPAWN_EGG.get());
                        pOutput.accept(ModItems.COW_SPAWN_EGG.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
