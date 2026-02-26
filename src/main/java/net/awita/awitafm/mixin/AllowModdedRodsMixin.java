package net.awita.awitafm.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.awita.awitafm.registry.awitafmTags;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingBobberEntity.class)
public class AllowModdedRodsMixin {
    @WrapOperation(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    private boolean allowModdedRodsInMainHand(ItemStack stack, Item item, Operation<Boolean> original) {
        return stack.isIn(awitafmTags.FISHING_RODS) || original.call(stack, item);
    }
    @WrapOperation(method = "removeIfInvalid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1))
    private boolean allowModdedRodsInOffHand(ItemStack stack, Item item, Operation<Boolean> original) {
        return stack.isIn(awitafmTags.FISHING_RODS) || original.call(stack, item);
    }
}
