package net.bowlofsin.sgear_ascended.item;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.entity.ModEntities;
import net.bowlofsin.sgear_ascended.item.tools.CowDetectorItem;
import net.bowlofsin.sgear_ascended.item.tools.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SGearAscendedMod.MODID);

    // ingredients
    public static final RegistryObject<Item> MANA_CRYSTAL = ITEMS.register("mana_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MANA_CRYSTAL = ITEMS.register("raw_mana_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_INGOT = ITEMS.register("arcanite_ingot",
            () -> new Item(new Item.Properties()
                    .fireResistant()));
    public static final RegistryObject<Item> COW_DETECTOR = ITEMS.register("cow_detector",
            () -> new CowDetectorItem(new Item.Properties()
                    .durability(100)));

    // Foods & Crops & Consumables
    public static final RegistryObject<Item> RICH_MILK_BUCKET = ITEMS.register("rich_milk_bucket",
            () -> new MilkBucketItem(new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .food(ModFoods.RICH_MILK_BUCKET)));
    public static final RegistryObject<Item> FERTILEOFRUIT_SEEDS = ITEMS.register("fertileofruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.FERTILEOFRUIT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> FERTILEOFRUIT = ITEMS.register("fertileofruit",
            () -> new Item(new Item.Properties()
                    .food(ModFoods.FERTILEOFRUIT)));


    // Tools
    public static final RegistryObject<Item> ARCANITE_PICKAXE = ITEMS.register("arcanite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ARCANITE, -10, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_AXE = ITEMS.register("arcanite_axe",
            () -> new AxeItem(ModToolTiers.ARCANITE, +80, -1.8f, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_SWORD = ITEMS.register("arcanite_sword",
            () -> new SwordItem(ModToolTiers.ARCANITE, +20, +3.8f, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_HOE = ITEMS.register("arcanite_hoe",
            () -> new HoeItem(ModToolTiers.ARCANITE, -80, -3.8f, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_SHOVEL = ITEMS.register("arcanite_shovel",
            () -> new ShovelItem(ModToolTiers.ARCANITE, -80, -3.8f, new Item.Properties()));



    // Armors
    public static final RegistryObject<Item> ARCANITE_HELMET = ITEMS.register("arcanite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ARCANITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_CHESTPLATE = ITEMS.register("arcanite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ARCANITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_LEGGINGS = ITEMS.register("arcanite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ARCANITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ARCANITE_BOOTS = ITEMS.register("arcanite_boots",
            () -> new ArmorItem(ModArmorMaterials.ARCANITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> BULL_SPAWN_EGG = ITEMS.register("bull_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BULL, 0X443636, 0XB2A5F2, new Item.Properties()));
    public static final RegistryObject<Item> COW_SPAWN_EGG = ITEMS.register("cow_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.COW, 0X443626, 0XA1A1A1, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> registerSeed(String pSeed, Block pCrop, Item.Properties pProperties) {
        return ITEMS.register(pSeed, () -> new BlockItem(pCrop, pProperties));
    }
}
