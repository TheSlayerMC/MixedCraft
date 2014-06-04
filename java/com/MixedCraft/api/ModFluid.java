package com.MixedCraft.api;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluid extends Fluid{

	public ModFluid(String fluidName) {
		super(fluidName);
		FluidRegistry.registerFluid(this);	
	}
}
