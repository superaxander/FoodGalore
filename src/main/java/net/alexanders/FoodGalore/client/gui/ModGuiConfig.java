package net.alexanders.FoodGalore.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.alexanders.FoodGalore.handler.ConfigurationHandler;
import net.alexanders.FoodGalore.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiscreen)
    {
        super(guiscreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
