package io.github.fallOut015.glazed_bricks.data.client;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.github.fallOut015.glazed_bricks.block.BlocksGlazedBricks;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.data.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BlockStateProviderGlazedBricks extends BlockStateProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator gen;

    public BlockStateProviderGlazedBricks(DataGenerator gen) {
        super(gen);
        this.gen = gen;
    }

    public void act(DirectoryCache cache) {
        Path path = this.gen.getOutputFolder();
        Map<Block, IFinishedBlockState> map = Maps.newHashMap();

        List<RegistryObject<Block>> list = BlocksGlazedBricks.getEntries().stream().filter(block -> !map.containsKey(block.get())).collect(Collectors.toList());

        list.forEach(block -> {
            if(block.get() instanceof FlowerPotBlock) {
                BlockModelDefinition model = new BlockModelDefinition().with(BlockModelFields.MODEL, new ResourceLocation(block.get().getRegistryName().getNamespace() + ":block/" + block.get().getRegistryName().getPath()));
                map.put(block.get(), FinishedVariantBlockState.multiVariant(block.get(), model));
            }
        });

        this.write(cache, path, map, BlockStateProviderGlazedBricks::blockStateResolver);
    }

    private <T> void write(DirectoryCache cache, Path path1, Map<T, ? extends Supplier<JsonElement>> files, BiFunction<Path, T, Path> pathGetter) {
        files.forEach((key, file) -> {
            Path path = pathGetter.apply(path1, key);

            try {
                IDataProvider.save(GSON, cache, file.get(), path);
            } catch (Exception exception) {
                LOGGER.error("Couldn't save {}", path, exception);
            }
        });
    }

    private static Path blockStateResolver(Path p_240082_0_, Block p_240082_1_) {
        ResourceLocation resourcelocation = Registry.BLOCK.getKey(p_240082_1_);
        return p_240082_0_.resolve("assets/" + resourcelocation.getNamespace() + "/blockstates/" + resourcelocation.getPath() + ".json");
    }
}