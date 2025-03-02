package me.justahuman.slimefun_essentials.compat.rei.displays;

import me.justahuman.slimefun_essentials.api.OffsetBuilder;
import me.justahuman.slimefun_essentials.client.SlimefunRecipeCategory;
import me.justahuman.slimefun_essentials.client.SlimefunRecipe;
import me.justahuman.slimefun_essentials.compat.rei.ReiIntegration;
import me.justahuman.slimefun_essentials.compat.rei.ReiUtils;
import me.justahuman.slimefun_essentials.utils.TextureUtils;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import net.minecraft.item.ItemStack;

import java.util.List;

public class AncientAltarDisplay extends ProcessDisplay {
    public AncientAltarDisplay(SlimefunRecipeCategory slimefunRecipeCategory, SlimefunRecipe slimefunRecipe) {
        super(slimefunRecipeCategory, slimefunRecipe);

        ReiUtils.fillEntries(this.inputs, 9);
        ReiUtils.fillEntries(this.outputs, 1);
    }

    @Override
    public List<Widget> setupDisplay(OffsetBuilder offsets, List<Widget> widgets, Rectangle bounds, ItemStack icon) {
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot()));
        addSlot(widgets, this.inputs.get(3), offsets.getX() + 1, offsets.slot() + 1, false);
        offsets.x().addSlot(false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.SLOT.size(getDrawMode())));
        addSlot(widgets, this.inputs.get(0), offsets.getX() + 1, offsets.slot() + 1 + TextureUtils.SLOT.size(getDrawMode()), false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.SLOT.size(getDrawMode())));
        addSlot(widgets, this.inputs.get(6), offsets.getX() + 1, offsets.slot() + 1 - TextureUtils.SLOT.size(getDrawMode()), false);
        offsets.x().addSlot(false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.SLOT.size(getDrawMode()) * 2));
        addSlot(widgets, this.inputs.get(1), offsets.getX() + 1, offsets.slot() + 1 + TextureUtils.SLOT.size(getDrawMode()) * 2, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.ALTAR, offsets.getX(), offsets.slot()));
        addSlot(widgets, this.inputs.get(4), offsets.getX() + 1, offsets.slot() + 1, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.SLOT.size(getDrawMode()) * 2));
        addSlot(widgets, this.inputs.get(7), offsets.getX() + 1, offsets.slot() + 1 - TextureUtils.SLOT.size(getDrawMode()) * 2, false);
        offsets.x().addSlot(false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.SLOT.size(getDrawMode())));
        addSlot(widgets, this.inputs.get(2), offsets.getX() + 1, offsets.slot() + 1 + TextureUtils.SLOT.size(getDrawMode()), false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.SLOT.size(getDrawMode())));
        addSlot(widgets, this.inputs.get(8), offsets.getX() + 1, offsets.slot() + 1 - TextureUtils.SLOT.size(getDrawMode()), false);
        offsets.x().addSlot(false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot()));
        addSlot(widgets, this.inputs.get(5), offsets.getX() + 1, offsets.slot() + 1, false);
        offsets.x().addSlot();
        addArrow(widgets, offsets);
        addSlot(widgets, offsets, this.outputs.get(0));

        return widgets;
    }
}
