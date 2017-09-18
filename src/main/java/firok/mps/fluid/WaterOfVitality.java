package firok.mps.fluid;

import firok.mps.MPs;
import net.minecraft.command.EntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import java.util.HashMap;

public class WaterOfVitality extends Fluid
{
	public static final ResourceLocation still = new ResourceLocation(MPs.MODID + ":" + "fluid/water_of_vitality_still");
    public static final ResourceLocation flowing = new ResourceLocation(MPs.MODID + ":" + "fluid/water_of_vitality_flow");
    
    protected static HashMap<Item,Entity> summonRecipes=new HashMap<Item,Entity>();

	public WaterOfVitality(boolean _addMinecraftSummonIn)
	{
		super("mud", Mud.still, Mud.flowing);
    	this.setDensity(1000); // 密度1倍于水
    	this.setViscosity(1000); // 粘度1倍于水
    	this.setLuminosity(2); // 亮度2
    	this.setTemperature(300); // 水温与水相同
    	this.setGaseous(false); // 不是气体
    	
    	if(_addMinecraftSummonIn) // 添加原版的召唤
    		_addMinecraftSummon();
	}
	
	public static void addSummonRecipe(Item itemIn,Entity entityIn)
	{
		summonRecipes.put(itemIn, entityIn);
	}
	public static boolean hasSummon(Item itemIn)
	{
		return summonRecipes.containsKey(itemIn);
	}
	public static Entity getSummon(Item itemIn)
	{
		return summonRecipes.get(itemIn);
	}
	protected static void _addMinecraftSummon()
	{
		addSummonRecipe(Items.BONE,new EntitySkeleton());
		Entity
	}
}
