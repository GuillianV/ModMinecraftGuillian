package com.guillian.modguillian.items.tools;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolAxe extends ItemAxe implements IHasModel{
	
public ToolAxe(String name, ToolMaterial material) {
		
		super(material, 6.0F, -3.2F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}

}
