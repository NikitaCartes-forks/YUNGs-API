package com.yungnickyoung.minecraft.yungsapi.world;

import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.Direction;
import com.yungnickyoung.minecraft.yungsapi.mixin.BlockBoxAccessor;

public class BoundingBoxHelper {
    /**
     * Generates and rotates a block box.
     * The main axis is the primary of the x and z axes, in the direction
     * the structure should generate from the starting point.
     */
    public static BlockBox boxFromCoordsWithRotation(int x, int y, int z, int secondaryAxisLen, int yLen, int mainAxisLen, Direction mainAxis) {
        BlockBox blockBox = new BlockBox(x, y, z, x, y + yLen - 1, z);
        switch (mainAxis) {
            case NORTH:
            default:
                ((BlockBoxAccessor) blockBox).setMaxX(x + (secondaryAxisLen - 1));
                ((BlockBoxAccessor) blockBox).setMinZ(z - (mainAxisLen - 1));
                break;
            case SOUTH:
                ((BlockBoxAccessor) blockBox).setMinX(x - (secondaryAxisLen - 1));
                ((BlockBoxAccessor) blockBox).setMaxZ(z + (mainAxisLen - 1));
                break;
            case WEST:
                ((BlockBoxAccessor) blockBox).setMinX(x - (mainAxisLen - 1));
                ((BlockBoxAccessor) blockBox).setMinZ(z - (secondaryAxisLen - 1));
                break;
            case EAST:
                ((BlockBoxAccessor) blockBox).setMaxX(x + (mainAxisLen - 1));
                ((BlockBoxAccessor) blockBox).setMaxZ(z + (secondaryAxisLen - 1));
        }
        return blockBox;
    }
}
