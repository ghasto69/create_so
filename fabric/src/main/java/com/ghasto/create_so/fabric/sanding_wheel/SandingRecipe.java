package com.ghasto.create_so.fabric.sanding_wheel;


import com.ghasto.create_so.fabric.SORecipeTypesFabric;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SandingRecipe extends AbstractSandingRecipe {

	public SandingRecipe(ProcessingRecipeParams params) {
		super(SORecipeTypesFabric.Sanding, params);
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		if (inv.isEmpty())
			return false;
		return ingredients.get(0)
				.test(inv.getItem(0));
	}

	@Override
	protected int getMaxOutputCount() {
		return 7;
	}

}
