package itIsAProject.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {
	
	public void registerRecipe() {
		ItemStack h4 = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta h4Meta = h4.getItemMeta();
		h4Meta.setDisplayName("žaABONNIERT H4_SQUAD");
		h4.setItemMeta(h4Meta);
		@SuppressWarnings("deprecation")
		ShapedRecipe h4Recipe = new ShapedRecipe(h4);
		h4Recipe.shape(" X ","XXX"," X ");
		h4Recipe.setIngredient('X', Material.BEDROCK);
		
		Bukkit.addRecipe(h4Recipe);
	}
}
