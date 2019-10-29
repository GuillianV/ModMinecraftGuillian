package com.guillian.modguillian.util.handlers;

import com.guillian.modguillian.entity.rubyArrow.EntityRubyArrow;
import com.guillian.modguillian.entity.rubyArrow.RenderRubyArrow;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRubyArrow.class, new IRenderFactory<EntityRubyArrow>() {
			
			@Override
			public Render<? super EntityRubyArrow> createRenderFor(RenderManager manager)
			{
				
				return new RenderRubyArrow(manager);
			}
			
			
			
		});
		
	}
	
}
