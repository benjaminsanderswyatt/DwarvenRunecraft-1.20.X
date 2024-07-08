package net.bsw.dwarvenrunecraft.entities.client.models;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bsw.dwarvenrunecraft.entities.animations.ModAnimationDefinitions;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class DwarfModel<T extends Entity> extends HierarchicalModel<T> {
	//public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "dwarfmodel"), "main");
	private final ModelPart dwarf;
	private final ModelPart head;

	public DwarfModel(ModelPart root) {
		this.dwarf = root.getChild("dwarf");
		this.head = dwarf.getChild("head");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition dwarf = partdefinition.addOrReplaceChild("dwarf", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = dwarf.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition beard = head.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(40, 22).addBox(-3.0F, 8.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 24).addBox(-4.0F, 9.0F, -5.0F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 30).addBox(-3.0F, 14.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 32).addBox(-2.0F, 15.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -4.0F));

		PartDefinition eyebrow = head.addOrReplaceChild("eyebrow", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = dwarf.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, 10.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition arms = dwarf.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 32).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition legs = dwarf.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(2.0F, -6.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-2.0F, -6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

		this.animate(((DwarfEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
		this.animate(((DwarfEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1f);






	}

	private void applyHeadRotation( float pNetHeadYaw, float pHeadPitch, float pAgeInTicks){
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F,30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F,45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		dwarf.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return dwarf;
	}
}