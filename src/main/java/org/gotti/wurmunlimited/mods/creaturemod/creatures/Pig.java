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

public class Pig implements ModCreature {
	private static final int COLOR_RED_WATTLE = 24;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {
		return new CreatureTemplateBuilder(CreatureTemplateIds.PIG_CID) {
			public CreatureTemplate build() {
				try {
					return CreatureTemplateFactory.getInstance().getTemplate(CreatureTemplateIds.PIG_CID);
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
			case COLOR_RED_WATTLE:
				return "redwattle";
			default:
				return null;
		}
	}

	@Override
	public String getColourName(final int trait) {
		switch (trait) {
			case COLOR_RED_WATTLE:
				return "red wattle";
			default:
				return null;
		}
	}

	public void assignTraits(final TraitsSetter traitsSetter) {
		if (Server.rand.nextInt(3) == 0) {
			traitsSetter.setTraitBit(COLOR_RED_WATTLE, true);
		}
	}
	
	@Override
	public long calcNewTraits(double breederSkill, boolean inbred, long mothertraits, long fathertraits) {
		return ModTraits.calcNewTraits(breederSkill, inbred, mothertraits, fathertraits, ModTraits.REGULAR_TRAITS, 1 << COLOR_RED_WATTLE);
	}
}
