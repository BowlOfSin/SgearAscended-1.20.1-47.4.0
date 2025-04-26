package net.bowlofsin.sgear_ascended.event;

import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.entity.ModEntities;
import net.bowlofsin.sgear_ascended.entity.custom.BullEntity;
import net.bowlofsin.sgear_ascended.entity.custom.CowEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SGearAscendedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BULL.get(), BullEntity.createAttributes().build());
        event.put(ModEntities.COW.get(), CowEntity.createAttributes().build());
    }
}
