package net.bowlofsin.sgear_ascended.block;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.crops.FertileOFruitCropBlock;
import net.bowlofsin.sgear_ascended.block.processing.MilkingStationBlock;
import net.bowlofsin.sgear_ascended.block.wood.ModFlammableRotatedPillarBlock;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.worldgen.tree.MysticalTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SGearAscendedMod.MODID);

    public static final RegistryObject<Block> MANA_CRYSTAL_BLOCK = registerBlock("mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_MANA_CRYSTAL_BLOCK = registerBlock("raw_mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MANA_CRYSTAL_ORE = registerBlock("mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f),
            UniformInt.of(5, 9)));

    public static final RegistryObject<Block> DEEPSLATE_MANA_CRYSTAL_ORE = registerBlock("deepslate_mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f),
            UniformInt.of(5, 12)));

    public static final RegistryObject<Block> NETHER_MANA_CRYSTAL_ORE = registerBlock("nether_mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(3f),
                    UniformInt.of(5, 15)));

    public static final RegistryObject<Block> END_MANA_CRYSTAL_ORE = registerBlock("end_mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f),
                    UniformInt.of(9, 20)));

    public static final RegistryObject<Block> MANA_CRYSTAL_STAIRS = registerBlock("mana_crystal_stairs",
            () -> new StairBlock(ModBlocks.MANA_CRYSTAL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MANA_CRYSTAL_SLAB = registerBlock("mana_crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MANA_CRYSTAL_BUTTON= registerBlock("mana_crystal_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST), BlockSetType.IRON, 50, true));

    public static final RegistryObject<Block> MANA_CRYSTAL_PRESSURE_PLATE = registerBlock("mana_crystal_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), BlockSetType.IRON));
    public static final RegistryObject<Block> MANA_CRYSTAL_FENCE = registerBlock("mana_crystal_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MANA_CRYSTAL_FENCE_GATE = registerBlock("mana_crystal_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                    .requiredFeatures(),
                    WoodType.WARPED));
    public static final RegistryObject<Block> MANA_CRYSTAL_WALL = registerBlock("mana_crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MANA_CRYSTAL_DOOR = registerBlock("mana_crystal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), BlockSetType.IRON));
    public static final RegistryObject<Block> MANA_CRYSTAL_TRAPDOOR = registerBlock("mana_crystal_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), BlockSetType.IRON));

    public static final RegistryObject<Block> FERTILEOFRUIT_CROP =
            BLOCKS.register("fertileofruit_crop",
            () -> new FertileOFruitCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noCollission()
                    .noOcclusion()));


    public static final RegistryObject<Block> MILKING_STATION = registerBlock("milking_station",
            () -> new MilkingStationBlock(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion()));

    public static final RegistryObject<Block> MYSTICAL_LOG = registerBlock("mystical_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5)));
    public static final RegistryObject<Block> MYSTICAL_WOOD = registerBlock("mystical_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5)));
    public static final RegistryObject<Block> STRIPPED_MYSTICAL_LOG = registerBlock("stripped_mystical_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5)));
    public static final RegistryObject<Block> STRIPPED_MYSTICAL_WOOD = registerBlock("stripped_mystical_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5)));

    public static final RegistryObject<Block> MYSTICAL_PLANKS = registerBlock("mystical_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> MYSTICAL_LEAVES = registerBlock("mystical_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });


    public static final RegistryObject<Block> MYSTICAL_SAPLING = registerBlock("mystical_sapling",
            () -> new SaplingBlock(new MysticalTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

//    private static RegistryObject<Block> registerCrop(String pName) {
//        return BLOCKS.register(pName, FertileOFruitCropBlock::new);
//    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
