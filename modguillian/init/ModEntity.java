package com.guillian.modguillian.init;

import javax.swing.text.html.parser.Entity;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.entity.rubyArrow.EntityRubyArrow;
import com.guillian.modguillian.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity {

	public static void registerEntities() {
		registerArrow("ruby_arrow", EntityRubyArrow.class, 1000);
	}
	
	
	private static void registerArrow(String name, Class<? extends net.minecraft.entity.Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID+":"+name), entity, name, id, Main.instance, 64, 20, true);
	}
	
	
}
