package net.zauviir.paragon.item.custom;

import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.LinkedHashMap;
import java.util.Map;

public class HugeGeodeItem extends Item {

    // Weighted loot table
    private static final Map<Item, Integer> ORE_WEIGHTS = new LinkedHashMap<>();

    static {
        ORE_WEIGHTS.put(Items.COAL_BLOCK, 40);
        ORE_WEIGHTS.put(Items.IRON_BLOCK, 30);
        ORE_WEIGHTS.put(Items.COPPER_BLOCK, 25);
        ORE_WEIGHTS.put(Items.GOLD_BLOCK, 15);
        ORE_WEIGHTS.put(Items.REDSTONE_BLOCK, 15);
        ORE_WEIGHTS.put(Items.LAPIS_BLOCK, 10);
        ORE_WEIGHTS.put(Items.EMERALD_BLOCK, 5);
        ORE_WEIGHTS.put(Items.DIAMOND_BLOCK, 3);
        ORE_WEIGHTS.put(Items.NETHERITE_INGOT, 1);
    }

    public HugeGeodeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            Item reward = getRandomOre(level.getRandom());

            // Give ore to player
            player.addItem(new ItemStack(reward));

            // Consume one geode
            stack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    private Item getRandomOre(RandomSource random) {
        int totalWeight = 0;

        for (int weight : ORE_WEIGHTS.values()) {
            totalWeight += weight;
        }

        int roll = random.nextInt(totalWeight);

        for (Map.Entry<Item, Integer> entry : ORE_WEIGHTS.entrySet()) {
            roll -= entry.getValue();
            if (roll < 0) {
                return entry.getKey();
            }
        }

        return Items.COAL; // fallback
    }
}
