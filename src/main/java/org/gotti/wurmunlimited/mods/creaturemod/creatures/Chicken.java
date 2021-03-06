package org.gotti.wurmunlimited.mods.creaturemod.creatures;

import com.wurmonline.server.Server;
import org.gotti.wurmunlimited.modsupport.creatures.TraitsSetter;
import com.wurmonline.server.creatures.NoSuchCreatureTemplateException;
import com.wurmonline.server.creatures.CreatureTemplateFactory;
import com.wurmonline.server.creatures.CreatureTemplateIds;
import com.wurmonline.server.creatures.CreatureTemplate;
import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.ModTraits;

public class Chicken implements ModCreature {
	private static final int COLOR_SILVER_CAMPINE = 26;
	private static final int COLOR_RHODE_ISLAND_RED = 25;
	private static final int COLOR_AUSTRALORP = 24;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {
		return new CreatureTemplateBuilder(CreatureTemplateIds.CHICKEN_CID) {
			public CreatureTemplate build() {
				try {
					return CreatureTemplateFactory.getInstance().getTemplate(CreatureTemplateIds.CHICKEN_CID);
				} catch (NoSuchCreatureTemplateException e) {
					throw new RuntimeException((Throwable) e);
				}
			}
		};
	}

	public boolean hasTraits() {
		return true;
	}

	@Override
	public String getTraitName(final int trait) {
		switch (trait) {
		case COLOR_AUSTRALORP:
			return "australorp";
		case COLOR_RHODE_ISLAND_RED:
			return "rhodeislandred";
		case COLOR_SILVER_CAMPINE:
			return "silvercampine";
		default:
			return null;
		}
	}
	
	@Override
	public String getColourName(final int trait) {
		switch (trait) {
		case COLOR_AUSTRALORP:
			return "australorp";
		case COLOR_RHODE_ISLAND_RED:
			return "rhode island red";
		case COLOR_SILVER_CAMPINE:
			return "silver campine";
		default:
			return null;
		}
	}

	public void assignTraits(final TraitsSetter traitsSetter) {
		if (Server.rand.nextInt(4) == 0) {
			traitsSetter.setTraitBit(COLOR_AUSTRALORP, true);
		} else if (Server.rand.nextInt(4) == 0) {
			traitsSetter.setTraitBit(COLOR_RHODE_ISLAND_RED, true);
		} else if (Server.rand.nextInt(4) == 0) {
			traitsSetter.setTraitBit(COLOR_SILVER_CAMPINE, true);
		}
	}
	
	@Override
	public long calcNewTraits(double breederSkill, boolean inbred, long mothertraits, long fathertraits) {
		return ModTraits.calcNewTraits(breederSkill, inbred, mothertraits, fathertraits, ModTraits.REGULAR_TRAITS, 1 << COLOR_AUSTRALORP | 1 << COLOR_RHODE_ISLAND_RED | 1 << COLOR_SILVER_CAMPINE);
	}
	
}
