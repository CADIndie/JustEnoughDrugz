package com.blackapple769.justenoughdrugz.init;
import com.blackapple769.justenoughdrugz.item.GenericEffectItem;

public class PostSetupHandler {

	public static void init() {
		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_BLUE_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_BLUE_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.LOW_QUALITY_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.BURNT_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.UNDERCOOKED_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());


		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_BLUE_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.LOW_QUALITY_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.BURNT_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.UNDERCOOKED_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());


		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.HIGH_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.MEDIUM_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.LOW_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.BURNT_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.UNDERCOOKED_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());

		((GenericEffectItem) RegistryHandler.GOLDEN_HIGH_QUALITY_BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_MEDIUM_QUALITY_BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_HIGH_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_MEDIUM_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_LOW_QUALITY_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_BURNT_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_UNDERCOOKED_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());

		((GenericEffectItem) RegistryHandler.DMT_SYRINGE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());
		((GenericEffectItem) RegistryHandler.DMT_PIPE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_DMT_PIPE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());

		((GenericEffectItem) RegistryHandler.PERCS_PILL_BOTTLE.get()).setEffect(RegistryHandler.PERC_EFFECT.get());


	}
}