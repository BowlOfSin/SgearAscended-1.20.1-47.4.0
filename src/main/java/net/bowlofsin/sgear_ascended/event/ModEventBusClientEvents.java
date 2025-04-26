package net.bowlofsin.sgear_ascended.event;


import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.entity.client.BullModel;
import net.bowlofsin.sgear_ascended.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SGearAscendedMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {


    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BULL_LAYER, BullModel::createBodyLayer);
    }
}
