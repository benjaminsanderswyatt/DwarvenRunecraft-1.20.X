package net.bsw.dwarvenrunecraft.effect;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

import java.util.List;

public class ColouredGlowingEffect extends MobEffect {

    public ColouredGlowingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        int range = 50;

        int i = pLivingEntity.getEffect(this).getDuration();

        if (!pLivingEntity.getCommandSenderWorld().isClientSide()) {
            Scoreboard scoreboard = pLivingEntity.getCommandSenderWorld().getServer().getScoreboard();

            PlayerTeam teamHostile = createTeam(scoreboard, "Hostile", ChatFormatting.RED);
            PlayerTeam teamPassive = createTeam(scoreboard, "Passive", ChatFormatting.GREEN);
            PlayerTeam teamNpc = createTeam(scoreboard, "Npc", ChatFormatting.YELLOW);
            PlayerTeam teamPlayer = createTeam(scoreboard, "Player", ChatFormatting.BLUE);
            PlayerTeam teamMisc = createTeam(scoreboard, "Misc", ChatFormatting.BLACK);


            AABB area = new AABB(pLivingEntity.position().add(-range, -range, -range), pLivingEntity.position().add(range, range, range));

            List<LivingEntity> mobs = pLivingEntity.level().getEntitiesOfClass(LivingEntity.class, area);

            for (LivingEntity mob : mobs) {

                PlayerTeam team = teamMisc;

                if (mob instanceof Monster) {
                    team = teamHostile;
                } else if (mob instanceof Animal || mob instanceof AmbientCreature) {
                    team = teamPassive;
                } else if (mob instanceof Npc) {
                    team = teamNpc;
                } else if (mob instanceof Player) {
                    team = teamPlayer;
                }

                scoreboard.addPlayerToTeam(mob.getScoreboardName(), team);

                mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 5, 0, false, false));
            }

            if (i <= 0) {
                removeTeam(scoreboard, teamHostile);
                removeTeam(scoreboard, teamPassive);
                removeTeam(scoreboard, teamNpc);
                removeTeam(scoreboard, teamPlayer);
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



