package com.ghasto.create_so.fabric;

import com.ghasto.create_so.fabric.sanding_wheel.CrushingWheelBlockEntity;
import com.ghasto.create_so.fabric.sanding_wheel.CrushingWheelControllerBlockEntity;
import com.simibubi.create.content.kinetics.base.CutoutRotatingInstance;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.ghasto.create_so.CreateSO.REGISTRATE;

public class SOTileEntitiesFabric {
    public static final BlockEntityEntry<CrushingWheelBlockEntity> CRUSHING_WHEEL = REGISTRATE
            .blockEntity("sanding_wheel", CrushingWheelBlockEntity::new)
            .instance(() -> CutoutRotatingInstance::new, false)
            .validBlocks(SOBlocksFabric.CRUSHING_WHEEL)
            .renderer(() -> KineticBlockEntityRenderer::new)
            .register();

    public static final BlockEntityEntry<CrushingWheelControllerBlockEntity> CRUSHING_WHEEL_CONTROLLER =
            REGISTRATE
                    .blockEntity("sanding_wheel_controller", CrushingWheelControllerBlockEntity::new)
                    .validBlocks(SOBlocksFabric.CRUSHING_WHEEL_CONTROLLER)
                    // .renderer(() -> renderer)
                    .register();
    public static void register() {}
}
