package io.github.fallOut015.glazed_bricks.data.client;

import io.github.fallOut015.glazed_bricks.MainGlazedBricks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class LanguageProviderGlazedBricks extends LanguageProvider {
    private final String locale;

    public LanguageProviderGlazedBricks(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        ForgeRegistries.BLOCKS.getValues().stream().filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID)).forEach(block -> {
            String name = switch (this.locale) {
                case "en_us" -> LanguageProviderGlazedBricks.separate(block.getRegistryName().getPath());
                case "en_au", "en_ca", "en_gb", "en_nz" -> LanguageProviderGlazedBricks.separate(block.getRegistryName().getPath()).replaceAll("Gray", "Grey");
                default -> "";
            };
            this.add(block, name);
        });
        ForgeRegistries.ITEMS.getValues().stream().filter(item -> Objects.requireNonNull(item.getRegistryName()).getNamespace().equals(MainGlazedBricks.MODID) && item.getRegistryName().getPath().endsWith("glazed_brick")).forEach(item -> {
            String name = switch (this.locale) {
                case "en_us" -> LanguageProviderGlazedBricks.separate(item.getRegistryName().getPath());
                case "en_au", "en_ca", "en_gb", "en_nz" -> LanguageProviderGlazedBricks.separate(item.getRegistryName().getPath()).replaceAll("Gray", "Grey");
                default -> "";
            };
            this.add(item, name);
        });
    }

    private static String separate(String s) {
        StringBuilder sb = new StringBuilder();
        for(String t : s.split("_")) {
            sb.append(t.substring(0, 1).toUpperCase()).append(t.substring(1)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}