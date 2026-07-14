package com.jiro.jirodelight;

import com.jiro.jirodelight.init.BlockInit;
import com.jiro.jirodelight.init.ItemInit;
import com.jiro.jirodelight.init.ModTabs; // 追加したクラスをインポート
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JiroDelight.MODID)
public class JiroDelight {
    public static final String MODID = "jirodelight";

    public JiroDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 各初期化クラスを登録
        BlockInit.register(modEventBus);
        ItemInit.register(modEventBus);
        ModTabs.register(modEventBus); // クリエイティブタブを登録

        MinecraftForge.EVENT_BUS.register(this);
    }

    }
