package com.guillian.modguillian.entity.rubyArrow;

import com.guillian.modguillian.items.arrows.RubyArrow;
import com.guillian.modguillian.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRubyArrow extends RenderArrow<EntityRubyArrow>{

	public RenderRubyArrow(RenderManager manager) {
		super(manager);
	}
	
	
	@Override
    public void doRender(EntityRubyArrow entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);
        this.bindEntityTexture(entity);
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityRubyArrow entity) 
	{
		return  new ResourceLocation(Reference.MOD_ID + ":textures/entity/arrows/ruby_arrow.png");
	
	}
	
	
}
