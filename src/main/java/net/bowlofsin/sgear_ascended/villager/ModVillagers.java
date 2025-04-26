package net.bowlofsin.sgear_ascended.villager;

import com.google.common.collect.ImmutableSet;
import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SGearAscendedMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SGearAscendedMod.MODID);

    public static final RegistryObject<PoiType> MILKING_STATION_POI = POI_TYPES.register("milking_station_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MILKING_STATION.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> MILKMAN_NOT_CARLSON = VILLAGER_PROFESSIONS.register("milkman",
            () -> new VillagerProfession("milkman",
                    holder -> holder.get() == MILKING_STATION_POI.get(),
                    holder -> holder.get() == MILKING_STATION_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
