package me.justahuman.slimefun_essentials.compat.rei.displays;

import me.justahuman.slimefun_essentials.api.IdInterpreter;
import me.justahuman.slimefun_essentials.client.SlimefunCategory;
import me.justahuman.slimefun_essentials.client.SlimefunItemStack;
import me.justahuman.slimefun_essentials.client.SlimefunRecipe;
import me.justahuman.slimefun_essentials.client.SlimefunRecipeComponent;
import me.justahuman.slimefun_essentials.compat.rei.ReiIntegration;
import me.justahuman.slimefun_essentials.utils.TextureUtils;
import me.justahuman.slimefun_essentials.utils.Utils;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public class ProcessDisplay implements Display, IdInterpreter<EntryIngredient> {
    protected final SlimefunCategory slimefunCategory;
    protected final SlimefunRecipe slimefunRecipe;
    
    public ProcessDisplay(SlimefunCategory slimefunCategory, SlimefunRecipe slimefunRecipe) {
        this.slimefunCategory = slimefunCategory;
        this.slimefunRecipe = slimefunRecipe;
    }
    
    public int getDisplayWidth() {
        return TextureUtils.getProcessWidth(slimefunRecipe.labels(), slimefunRecipe.inputs(), slimefunRecipe.outputs(), slimefunRecipe.energy());
    }
    
    @Override
    public List<EntryIngredient> getInputEntries() {
        final List<EntryIngredient> ingredients = new ArrayList<>();
        for (SlimefunRecipeComponent component : slimefunRecipe.inputs()) {
            ingredients.add(entryIngredientFromComponent(component));
        }
        return ingredients;
    }
    
    @Override
    public List<EntryIngredient> getOutputEntries() {
        final List<EntryIngredient> ingredients = new ArrayList<>();
        for (SlimefunRecipeComponent component : slimefunRecipe.outputs()) {
            ingredients.add(entryIngredientFromComponent(component));
        }
        return ingredients;
    }
    
    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CategoryIdentifier.of(Utils.newIdentifier(slimefunCategory.id().toLowerCase()));
    }
    
    public EntryIngredient entryIngredientFromComponent(SlimefunRecipeComponent component) {
        if (component.getMultiId() != null) {
            EntryIngredient.Builder builder = EntryIngredient.builder();
            for (String id : component.getMultiId()) {
                builder.addAll(interpretId(id, EntryIngredient.empty()));
            }
            return builder.build();
        } else {
            return interpretId(component.getId(), EntryIngredient.empty());
        }
    }
    
    @Override
    public EntryIngredient fromTag(TagKey<Item> tagKey, int amount, EntryIngredient defaultValue) {
        return EntryIngredients.ofItemTag(tagKey);
    }
    
    @Override
    public EntryIngredient fromItemStack(ItemStack itemStack, int amount, EntryIngredient defaultValue) {
        itemStack.setCount(amount);
        return EntryIngredients.of(itemStack);
    }
    
    @Override
    public EntryIngredient fromSlimefunItemStack(SlimefunItemStack slimefunItemStack, int amount, EntryIngredient defaultValue) {
        return EntryIngredient.of(EntryStack.of(ReiIntegration.SLIMEFUN, slimefunItemStack.setAmount(amount)));
    }
    
    @Override
    public EntryIngredient fromFluid(Fluid fluid, int amount, EntryIngredient defaultValue) {
        return EntryIngredients.of(fluid, amount);
    }
    
    @Override
    public EntryIngredient fromEntityType(EntityType<?> entityType, int amount, EntryIngredient defaultValue) {
        // TODO: add entity support
        return defaultValue;
    }
}
