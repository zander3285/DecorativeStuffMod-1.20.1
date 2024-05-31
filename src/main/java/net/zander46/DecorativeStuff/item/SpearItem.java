//package net.zander46.DecorativeStuff.item;
//
//import com.google.common.collect.ImmutableMap;
//import net.minecraft.advancements.CriteriaTriggers;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.context.UseOnContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.RotatedPillarBlock;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.gameevent.GameEvent;
//import net.minecraftforge.common.ToolAction;
//import net.minecraftforge.common.ToolActions;
//import net.zander46.DecorativeStuff.DecorativeStuffMod;
//import net.zander46.DecorativeStuff.block.ModBlocks;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.Map;
//import java.util.Optional;
//
//
//public class SpearItem extends Item {
//    protected static final Map<Block, Block> SPEARABLES;
//
//    public SpearItem(Item.Properties pProperties) {
//        super(pProperties);
//    }
//
//    @Override
//    public InteractionResult useOn(UseOnContext pContext) {
//        Level level = pContext.getLevel();
//        BlockPos blockpos = pContext.getClickedPos();
//        Player player = pContext.getPlayer();
//        BlockState blockstate = level.getBlockState(blockpos);
//        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_STRIP, false));
//        ItemStack itemstack = pContext.getItemInHand();
//        Optional<BlockState> optional3 = Optional.empty();
//        if (optional.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
//            optional3 = optional;
//        }
//        if (optional3.isPresent()) {
//            if (player instanceof ServerPlayer) {
//                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
//            }
//            level.setBlock(blockpos, (BlockState) optional3.get(), 11);
//            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, (BlockState) optional3.get()));
//            if (player != null) {
//                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
//                    p_150686_.broadcastBreakEvent(pContext.getHand());
//                });
//            }
//
//            return InteractionResult.sidedSuccess(level.isClientSide);
//        } else {
//            return InteractionResult.PASS;
//        }
//    }
//
//    public static @Nullable BlockState getAxeStrippingState(BlockState originalState) {
//        Block block = (Block) SPEARABLES.get(originalState.getBlock());
//        return block != null ? (BlockState)block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)originalState.getValue(RotatedPillarBlock.AXIS)) : null;
//    }
//
//    private Optional<BlockState> getStripped(BlockState pUnstrippedState) {
//        return Optional.ofNullable((Block) SPEARABLES.get(pUnstrippedState.getBlock())).map((p_150689_) -> {
//            return (BlockState)p_150689_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)pUnstrippedState.getValue(RotatedPillarBlock.AXIS));
//        });
//    }
//
//    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
//        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
//    }
//
//    static {
//        SPEARABLES = (new ImmutableMap.Builder()).put(ModBlocks.PACKED_TERRACOTTA, Blocks.STRIPPED_OAK_WOOD).build();
//    }
//}