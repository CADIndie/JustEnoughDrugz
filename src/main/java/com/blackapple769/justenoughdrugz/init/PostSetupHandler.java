package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.item.GenericEffectItem;

public class PostSetupHandler {

	public static void init() {
		((GenericEffectItem) RegistryHandler.BLUE_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.ORANGE_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.CLEAR_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GREEN_METH.get()).setEffect(RegistryHandler.METH_EFFECT.get());

		((GenericEffectItem) RegistryHandler.BLUE_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.CLEAR_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.CHEAP_METH_SYRINGE.get()).setEffect(RegistryHandler.METH_EFFECT.get());

		((GenericEffectItem) RegistryHandler.BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.CLEAR_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.CHEAP_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());

		((GenericEffectItem) RegistryHandler.GOLDEN_BLUE_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_CLEAR_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_CHEAP_METH_PIPE.get()).setEffect(RegistryHandler.METH_EFFECT.get());


		((GenericEffectItem) RegistryHandler.DMT_SYRINGE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());
		((GenericEffectItem) RegistryHandler.DMT_PIPE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());
		((GenericEffectItem) RegistryHandler.GOLDEN_DMT_PIPE.get()).setEffect(RegistryHandler.DMT_EFFECT.get());

		((GenericEffectItem) RegistryHandler.PERCS_PILL_BOTTLE.get()).setEffect(RegistryHandler.PERC_EFFECT.get());
	}
}