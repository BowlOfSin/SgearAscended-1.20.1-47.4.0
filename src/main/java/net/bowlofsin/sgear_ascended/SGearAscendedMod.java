package net.bowlofsin.sgear_ascended;

import com.mojang.logging.LogUtils;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.block.entities.ModBlockEntities;
import net.bowlofsin.sgear_ascended.entity.ModEntities;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.loot.ModLootModifiers;
import net.bowlofsin.sgear_ascended.recipe.ModRecipes;
import net.bowlofsin.sgear_ascended.screen.ModMenuTypes;
import net.bowlofsin.sgear_ascended.villager.ModVillagers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SGearAscendedMod.MODID)
public class SGearAscendedMod
{
    public static final String MODID = "sgear_ascended";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SGearAscendedMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);


        ModCreativeModeTabs.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
