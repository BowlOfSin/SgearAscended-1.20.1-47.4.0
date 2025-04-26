package net.bowlofsin.sgear_ascended.recipe;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SGearAscendedMod.MODID);

    public static final RegistryObject<RecipeSerializer<MilkingStationRecipe>> MILKING_STATION_PROCESSING_SERIALIZER =
            SERIALIZERS.register("milking_station_processing", () -> MilkingStationRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
