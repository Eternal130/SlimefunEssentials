package me.justahuman.slimefun_essentials.compat.rei.displays;

import me.justahuman.slimefun_essentials.api.OffsetBuilder;
import me.justahuman.slimefun_essentials.client.SlimefunCategory;
import me.justahuman.slimefun_essentials.client.SlimefunRecipe;
import me.justahuman.slimefun_essentials.compat.rei.ReiIntegration;
import me.justahuman.slimefun_essentials.utils.TextureUtils;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import net.minecraft.item.ItemStack;

import java.util.List;

public class AncientAltarDisplay extends ProcessDisplay {
    public AncientAltarDisplay(SlimefunCategory slimefunCategory, SlimefunRecipe slimefunRecipe) {
        super(Type.ANCIENT_ALTAR, slimefunCategory, slimefunRecipe);
    }

    @Override
    public List<Widget> setupDisplay(OffsetBuilder offsets, List<Widget> widgets, Rectangle bounds, ItemStack icon) {
        addSlot(widgets, this.inputs.get(3), offsets.getX() + 1, offsets.slot() + 1, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX() + 1, offsets.slot() + 1));
        offsets.x().addSlot(false);
        addSlot(widgets, this.inputs.get(0), offsets.getX() + 1, offsets.slot() + TextureUtils.slotSize, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.slotSize));
        addSlot(widgets, this.inputs.get(6), offsets.getX() + 1, offsets.slot() - TextureUtils.slotSize, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.slotSize));
        offsets.x().addSlot(false);
        addSlot(widgets, this.inputs.get(1), offsets.getX() + 1, offsets.slot() + TextureUtils.slotSize * 2, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.slotSize * 2));
        addSlot(widgets, this.inputs.get(4), offsets.getX() + 1, offsets.slot());
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.ALTAR, offsets.getX(), offsets.slot()));
        addSlot(widgets, this.inputs.get(7), offsets.getX() + 1, offsets.slot() - TextureUtils.slotSize * 2, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.slotSize * 2));
        offsets.x().addSlot(false);
        addSlot(widgets, this.inputs.get(2), offsets.getX() + 1, offsets.slot() + TextureUtils.slotSize, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() + TextureUtils.slotSize));
        addSlot(widgets, this.inputs.get(8), offsets.getX() + 1, offsets.slot() - TextureUtils.slotSize, false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot() - TextureUtils.slotSize));
        offsets.x().addSlot(false);
        addSlot(widgets, this.inputs.get(5), offsets.getX() + 1, offsets.slot(), false);
        widgets.add(ReiIntegration.widgetFromSlimefunLabel(TextureUtils.PEDESTAL, offsets.getX(), offsets.slot()));
        offsets.x().addSlot();
        addArrow(widgets, offsets);
        addSlot(widgets, offsets, this.outputs.get(0));

        return widgets;
    }
}
