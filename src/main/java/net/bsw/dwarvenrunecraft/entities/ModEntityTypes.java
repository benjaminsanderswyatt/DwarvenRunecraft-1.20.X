package net.bsw.dwarvenrunecraft.entities;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.bsw.dwarvenrunecraft.entities.custom.IdentifierEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DwarvenRunecraft.MOD_ID);

    public static final RegistryObject<EntityType<IdentifierEntity>> IDENTIFIER =
            ENTITY_TYPES.register("identifier",
                    () -> EntityType.Builder.of(IdentifierEntity::new, MobCategory.CREATURE)
                    .sized(1f,1f)
                    .build(new ResourceLocation(DwarvenRunecraft.MOD_ID,"identifier").toString()));


    public static final RegistryObject<EntityType<DwarfEntity>> DWARF =
            ENTITY_TYPES.register("dwarf",
                    () -> EntityType.Builder.of(DwarfEntity::new, MobCategory.CREATURE)
                            .sized(1f,1f)
                            .build(new ResourceLocation(DwarvenRunecraft.MOD_ID,"dwarf").toString()));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
