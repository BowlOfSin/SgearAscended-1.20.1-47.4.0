package net.bowlofsin.sgear_ascended.datagen;


import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.block.crops.FertileOFruitCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SGearAscendedMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MANA_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.RAW_MANA_CRYSTAL_BLOCK);

        blockWithItem(ModBlocks.MANA_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE);
        blockWithItem(ModBlocks.NETHER_MANA_CRYSTAL_ORE);
        blockWithItem(ModBlocks.END_MANA_CRYSTAL_ORE);

        stairsBlock((StairBlock) ModBlocks.MANA_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.MANA_CRYSTAL_SLAB.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.MANA_CRYSTAL_BUTTON.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MANA_CRYSTAL_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.MANA_CRYSTAL_FENCE.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.MANA_CRYSTAL_FENCE_GATE.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.MANA_CRYSTAL_WALL.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));

        doorBlock((DoorBlock) ModBlocks.MANA_CRYSTAL_DOOR.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()));
        trapdoorBlock((TrapDoorBlock) ModBlocks.MANA_CRYSTAL_TRAPDOOR.get(), blockTexture(ModBlocks.MANA_CRYSTAL_BLOCK.get()), true);

        MakeFertileofruitCrop((CropBlock) ModBlocks.FERTILEOFRUIT_CROP.get(), "fertileofruit_stage", "fertileofruit_stage");

//        simpleBlock(ModBlocks.MANA_INFUSED_FURNACE.get());

        simpleBlockWithItem(ModBlocks.MILKING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/milking_station")));

        logBlock(((RotatedPillarBlock) ModBlocks.MYSTICAL_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.MYSTICAL_WOOD.get()), blockTexture(ModBlocks.MYSTICAL_LOG.get()), blockTexture(ModBlocks.MYSTICAL_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MYSTICAL_LOG.get()), blockTexture(ModBlocks.STRIPPED_MYSTICAL_LOG.get()),
                ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID, "block/stripped_mystical_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MYSTICAL_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MYSTICAL_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_MYSTICAL_LOG.get()));

        blockItem(ModBlocks.MYSTICAL_LOG);
        blockItem(ModBlocks.MYSTICAL_WOOD);
        blockItem(ModBlocks.STRIPPED_MYSTICAL_LOG);
        blockItem(ModBlocks.STRIPPED_MYSTICAL_WOOD);

        blockWithItem(ModBlocks.MYSTICAL_PLANKS);
        leavesBlock(ModBlocks.MYSTICAL_LEAVES);

        saplingBlock(ModBlocks.MYSTICAL_SAPLING);

    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        ResourceLocation.parse("minecraft:block/leaves"), "all",
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(SGearAscendedMod.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void MakeFertileofruitCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> fertileofruitStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] fertileofruitStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((FertileOFruitCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID,
                        "block/" + textureName + state.getValue(((FertileOFruitCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
