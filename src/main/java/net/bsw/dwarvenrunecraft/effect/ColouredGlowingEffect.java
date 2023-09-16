package net.bsw.dwarvenrunecraft.effect;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

import java.util.Objects;

public class ColouredGlowingEffect extends MobEffect {

    public ColouredGlowingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.level().isClientSide) {

            int range = 50;

            int i = pLivingEntity.getEffect(this).getDuration();

            Scoreboard scoreboard = pLivingEntity.getCommandSenderWorld().getServer().getScoreboard();


            PlayerTeam teamMisc = createTeam(scoreboard, "Misc", ChatFormatting.BLACK);

            PlayerTeam teamBoss = createTeam(scoreboard,"Boss", ChatFormatting.DARK_RED);
            PlayerTeam teamPlayer = createTeam(scoreboard,"Player", ChatFormatting.LIGHT_PURPLE);
            PlayerTeam teamNpc = createTeam(scoreboard,"Npc", ChatFormatting.YELLOW);
            PlayerTeam teamGolem = createTeam(scoreboard,"Golem", ChatFormatting.GOLD);
            PlayerTeam teamRideable = createTeam(scoreboard,"Rideable", ChatFormatting.DARK_GREEN);
            PlayerTeam teamPet = createTeam(scoreboard,"Pet", ChatFormatting.DARK_PURPLE);
            PlayerTeam teamHostile = createTeam(scoreboard,"Hostile", ChatFormatting.RED);
            PlayerTeam teamPassive = createTeam(scoreboard,"Passive", ChatFormatting.GREEN);
            PlayerTeam teamWater = createTeam(scoreboard,"Water", ChatFormatting.BLUE);

            PlayerTeam team = teamMisc;


            if (pLivingEntity instanceof ElderGuardian ||
                    pLivingEntity instanceof Warden ||
                    pLivingEntity instanceof PiglinBrute){
                //boss
                team = teamBoss;
            } else if (pLivingEntity instanceof Player){
                //player
                team = teamPlayer;
            } else if (pLivingEntity instanceof Npc) {
                //npc
                team = teamNpc;
            } else if (pLivingEntity instanceof AbstractGolem && !(pLivingEntity instanceof Shulker)) {
                //Golem
                team = teamGolem;
            } else if (pLivingEntity instanceof PlayerRideable) {
                //ridables
                team = teamRideable;
            } else if (pLivingEntity instanceof TamableAnimal ||
                    pLivingEntity instanceof Allay) {
                //Pets
                team = teamPet;
            } else if (pLivingEntity instanceof Monster ||
                    pLivingEntity instanceof Slime ||
                    pLivingEntity instanceof Phantom ||
                    pLivingEntity instanceof Ghast ||
                    pLivingEntity instanceof Shulker) {
                //hostile
                team = teamHostile;
            } else if (pLivingEntity instanceof Animal ||
                    pLivingEntity instanceof AmbientCreature) {
                //passive
                team = teamPassive;
            } else if (pLivingEntity instanceof WaterAnimal) {
                //water
                team = teamWater;
            }

            scoreboard.addPlayerToTeam(pLivingEntity.getScoreboardName(), team);

            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));


            if (i <= 0) {
                removeTeam(scoreboard, teamBoss);
                removeTeam(scoreboard, teamPlayer);
                removeTeam(scoreboard, teamNpc);
                removeTeam(scoreboard, teamGolem);
                removeTeam(scoreboard, teamRideable);
                removeTeam(scoreboard, teamPet);
                removeTeam(scoreboard, teamHostile);
                removeTeam(scoreboard, teamPassive);
                removeTeam(scoreboard, teamWater);
                removeTeam(scoreboard, teamMisc);
            }


        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }



    public static PlayerTeam createTeam(Scoreboard scoreboard, String name, ChatFormatting color) {
        if (scoreboard.getTeamNames().contains(name)) {
            return scoreboard.getPlayerTeam(name);
        } else {
            PlayerTeam team = scoreboard.addPlayerTeam(name);
            team.setDisplayName(Component.literal(name));
            team.setColor(color);
            return team;
        }
    }

    public static void removeTeam(Scoreboard scoreboard, PlayerTeam team) {
        if (scoreboard.getTeamNames().contains(team.getName())) {
            scoreboard.removePlayerTeam(team);
        }
    }
}



