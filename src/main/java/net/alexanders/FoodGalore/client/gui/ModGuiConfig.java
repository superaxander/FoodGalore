package net.alexanders.foodgalore.client.gui;

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.alexanders.foodgalore.handler.ConfigurationHandler;
import net.alexanders.foodgalore.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ModGuiConfig extends GuiConfig
{
        public ModGuiConfig(GuiScreen parent) {
            super(parent, getConfigElements(), Reference.MOD_ID, false, false, "My mod's configuration");
        }

        /** Compiles a list of config elements */
        private static List<IConfigElement> getConfigElements() {
            List<IConfigElement> list = new ArrayList<IConfigElement>();

            //Add categories to config GUI
            list.add(categoryElement(ConfigurationHandler.CATEGORY_FOODITEMS, "Food Items", ""));
            list.add(categoryElement(ConfigurationHandler.CATEGORY_CROPS, "Crops", ""));

            return list;
        }

        /** Creates a button linking to another screen where all options of the category are available */
        private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
            return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
                    new ConfigElement(ConfigurationHandler.configuration.getCategory(category)).getChildElements());
        }
}
