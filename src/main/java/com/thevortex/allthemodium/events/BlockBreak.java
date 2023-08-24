package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.init.ModItems;
import com.thevortex.allthemodium.reference.Reference;


import com.thevortex.allthemodium.reference.TagRegistry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreak {


	@SubscribeEvent
	public static void on(BreakEvent event) {
		if(event.getPlayer().isCreative()) { return; }

		//TODO Add a config entry to toggle this on or off
		/*if((event.getState().is(TagRegistry.OTHER_PROTECTION)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null)) && ((event.getWorld().dimensionType().hasCeiling() == false) && (event.getWorld().dimensionType().piglinSafe() == true) && (event.getWorld().dimensionType().hasFixedTime() == false))) {

			event.setCanceled(true);
			return;
		}*/
		if((event.getState().is(TagRegistry.ALLTHEMODIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.VIBRANIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null || (event.getPlayer().getMainHandItem().isEmpty())))) {
			
			event.setCanceled(true);
			return;
		}
		if((event.getState().is(TagRegistry.UNOBTAINIUM_ORE)) && ((event.getPlayer() instanceof FakePlayer) || (event.getPlayer() == null) || (event.getPlayer().getMainHandItem().isEmpty()))) {
			
			event.setCanceled(true);
			return;
		}
		if(event.getPlayer() instanceof FakePlayer) {

			return;
		}

		
	}


	
}
