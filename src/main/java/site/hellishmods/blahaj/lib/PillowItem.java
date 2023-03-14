package site.hellishmods.blahaj.lib;

import java.util.List;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class PillowItem extends Item { // Cuddly item :3
    public PillowItem() {
        super(new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)); // Add to misc tab and make it unstackable
        if (FMLEnvironment.dist==Dist.CLIENT) MinecraftForge.EVENT_BUS.register(this); // Add to event bus if on client side
    }

    @Override
    public void onCraftedBy(ItemStack stack, World world, PlayerEntity owner) {
        if (owner!=null && !(owner instanceof FakePlayer))
            stack.getOrCreateTag().putString("Owner", owner.getName().getString()); // Add the owner username to nbt on craft

        super.onCraftedBy(stack, world, owner);
    }
    @Override
    @OnlyIn(Dist.CLIENT) // Only on client
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (I18n.exists(stack.getItem().getDescriptionId()+".tooltip"))
            tooltip.add(new TranslationTextComponent(stack.getItem().getDescriptionId()+".tooltip").withStyle(TextFormatting.GRAY)); // Append tooltip if exists in lang

        if (stack.hasTag()) { // If the item has nbt
            String owner = stack.getTag().getString("Owner");
            if (owner=="") return; // If the "Owner" tag is in the nbt

            if (stack.hasCustomHoverName()) tooltip.add(new TranslationTextComponent("tooltip.blahaj.owner.rename", stack.getItem().getDescription().getString(), owner).withStyle(TextFormatting.GRAY)); // Tooltip if the haj was renamed
            else tooltip.add(new TranslationTextComponent("tooltip.blahaj.owner.craft", owner).withStyle(TextFormatting.GRAY)); // Tooltip if it wasn't
        }
    }

    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent.Pre e) {
        if (e.getPlayer().getItemInHand(Hand.MAIN_HAND).getItem()==this.getItem() || e.getPlayer().getItemInHand(Hand.OFF_HAND).getItem()==this.getItem()) {
            PlayerModel<AbstractClientPlayerEntity> model = e.getRenderer().getModel();

            // Make the player hug the haj
            model.rightArmPose = ArmPose.CROSSBOW_CHARGE;
            model.leftArmPose = ArmPose.CROSSBOW_CHARGE;
        }
    }
}
