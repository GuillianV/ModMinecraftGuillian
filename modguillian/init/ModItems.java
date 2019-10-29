package com.guillian.modguillian.init;

import java.util.ArrayList;
import java.util.List;

import com.guillian.modguillian.items.ItemBase;
import com.guillian.modguillian.items.armor.ArmorBase;
import com.guillian.modguillian.items.arrows.ArrowBase;
import com.guillian.modguillian.items.arrows.RubyArrow;
import com.guillian.modguillian.items.bow.BowBase;
import com.guillian.modguillian.items.bow.RubyBow;
import com.guillian.modguillian.items.food.FoodBase;
import com.guillian.modguillian.items.food.FoodEffectBase;
import com.guillian.modguillian.items.test.ItemTest;
import com.guillian.modguillian.items.tools.ToolAxe;
import com.guillian.modguillian.items.tools.ToolHammer;
import com.guillian.modguillian.items.tools.ToolHoe;
import com.guillian.modguillian.items.tools.ToolPickaxe;
import com.guillian.modguillian.items.tools.ToolSpade;
import com.guillian.modguillian.items.tools.ToolSword;
import com.guillian.modguillian.util.Reference;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//MATERIALS
	public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 3, 250, 16.0F, 3.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 14, new int[] {2,5,7,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	
	//ITEMS
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item RUBY_POLISHED = new ItemBase("ruby_polished");
	public static final Item AMETHYST = new ItemBase("amethyst");
	
	//TESTS
	public static final Item ITEM_TEST = new ItemTest("item_test");
	
	//TOOLS
	public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
	public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
	public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
	public static final ItemPickaxe RUBY_HAMMER = new ToolHammer("ruby_hammer", MATERIAL_RUBY);
	
	//ARMOR
	public static final Item RUBY_HELMET = new ArmorBase("ruby_helmet", ARMOR_MATERIAL_RUBY,1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new ArmorBase("ruby_chestplate", ARMOR_MATERIAL_RUBY,1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new ArmorBase("ruby_leggings", ARMOR_MATERIAL_RUBY,2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new ArmorBase("ruby_boots", ARMOR_MATERIAL_RUBY,1, EntityEquipmentSlot.FEET);
	
	//BOW
	public static final Item SUPER_BOW = new RubyBow("ruby_bow");
	
	//ARROW
	public static final Item RUBY_ARROW = new RubyArrow("ruby_arrow");
	
	//FOOD
	public static final Item RUBY_APPLE = new FoodEffectBase("ruby_apple", 6,2.4F,false, new PotionEffect(MobEffects.HASTE, 1*(60*20),1,false,true));
	
}
