package net.bowlofsin.sgear_ascended.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.block.ModBlocks;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.bowlofsin.sgear_ascended.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = SGearAscendedMod.MODID)
public class ModEvents {


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1 trade
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FERTILEOFRUIT.get(), 1),
                    new ItemStack(ModItems.MANA_CRYSTAL.get(), 8),
                    5, 8, 0.2f
            ));


            ItemStack prot4Book =  EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.ALL_DAMAGE_PROTECTION, 4));

            //Level 5 trade
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FERTILEOFRUIT.get(), 30),
                    prot4Book,
                    1, 80, 1.2f
            ));
        }

        if (event.getType() == ModVillagers.MILKMAN_NOT_CARLSON.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1 trade
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RICH_MILK_BUCKET.get(), 1),
                    new ItemStack(Items.EMERALD, 14),
                    25, 8, 0.02f
            ));
        }
    }

    @SubscribeEvent
    public static void addCustomWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.DIAMOND, 4),
                new ItemStack(ModBlocks.END_MANA_CRYSTAL_ORE.get(), 1),
                15, 12, 0.025f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(ModItems.MANA_CRYSTAL.get(), 40),
                new ItemStack(ModItems.ARCANITE_INGOT.get(), 1),
                1, 80, 1.2f
        ));
    }
}
