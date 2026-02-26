package net.awita.awitafm.Item.custom;

import net.awita.awitafm.entity.custom.CustomFishingHookEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomFishingRodBaseItem extends FishingRodItem {
    public CustomFishingRodBaseItem(Settings settings, ROD_TYPE type) {
        super(settings);
        this.type = type;
    }
    private final ROD_TYPE type;
    private int tensionCap = 100;

    public int getTensionCap(){
        return tensionCap;
    }
    public void setTensionCap(int v){
        tensionCap=v;
    }

    private Reel reel;
    public void setReel(Reel r){
        reel=r;
    }

    private FishingLine line;
    public void setLine(FishingLine l){
        line=l;
    }

    private Bobber bobber;
    public void setBobber(Bobber b){
        bobber=b;
    }

    private Lure lure;
    public void setLure(Lure l){
        lure=l;
    }

    private Bait bait;
    public void setBait(Bait b){
        bait=b;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            CustomFishingHookEntity hook =
                    new CustomFishingHookEntity(player.getType(), world);
            world.spawnEntity(hook);
        }

        player.swingHand(hand);
        return TypedActionResult.success(stack, world.isClient());
    }
}

