package net.bowlofsin.sgear_ascended.entity;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.entity.custom.BullEntity;
import net.bowlofsin.sgear_ascended.entity.custom.CowEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SGearAscendedMod.MODID);

    public static final RegistryObject<EntityType<BullEntity>> BULL =
            ENTITY_TYPES.register("bull", () -> EntityType.Builder.of(BullEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.2f).build("bull"));

    public static final  RegistryObject<EntityType<CowEntity>> COW =
            ENTITY_TYPES.register("cow", () -> EntityType.Builder.of(CowEntity::new, MobCategory.CREATURE).build("cow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
